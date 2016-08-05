package com.vdlm.web.address;

import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vdlm.dal.model.Address;
import com.vdlm.dal.model.Zone;
import com.vdlm.dal.mybatis.IdTypeHandler;
import com.vdlm.meila.client.ReportAddrActModel;
import com.vdlm.meila.client.ReportModel;
import com.vdlm.service.address.AddressService;
import com.vdlm.service.address.AddressVO;
import com.vdlm.service.constants.Constants;
import com.vdlm.service.error.BizException;
import com.vdlm.service.error.GlobalErrorCode;
import com.vdlm.service.sns.MeiLaSNSReportService;
import com.vdlm.service.utils.IdCardUtils;
import com.vdlm.service.utils.NameUtils;
import com.vdlm.service.zone.ZoneService;
import com.vdlm.web.MeilaBaseController;
import com.vdlm.web.common.JsonResult;
import com.vdlm.web.utils.MeiLaDeviceUtils;
import com.vdlm.web.utils.MeiLaSNSReportUtils;

/**
 * 
 ************************************************************
 * @类名 : MeiLaAddressController.java
 *
 * @DESCRIPTION :收获地址维护
 * @AUTHOR : peter
 * @DATE : 2016年3月1日
 ************************************************************
 */
@Controller
@RequestMapping("/address")
public class MeiLaAddressController extends MeilaBaseController {
    private static final Logger logger = LoggerFactory.getLogger(MeiLaAddressController.class);

    @Autowired
    private AddressService addressService;

    @Autowired
    private ZoneService zoneService;

    @Autowired
    private MeiLaSNSReportService meiLaSNSReportService;

    @RequestMapping("list.xhtml")
    public String addresses(String needIdCard, String manage, Model model, HttpServletRequest request) {
        List<AddressVO> addresses = addressService.listUserAddresses();
        if (CollectionUtils.isNotEmpty(addresses)) {
            model.addAttribute("addresses", addresses);
            // 收货地址处理
            if (StringUtils.isNotBlank(manage) && "0".equals(manage)) {
                model.addAttribute("button_label", "完成");
                model.addAttribute("title_label", "管理我的地址");
                model.addAttribute("is_manage", "0");
            } else {
                model.addAttribute("button_label", "管理");
                model.addAttribute("title_label", "我的地址");
                model.addAttribute("is_manage", "1");
            }
            model.addAttribute("needIdCard", Objects.toString(needIdCard, ""));
            // 上报社区 地址操作数据
            doReportAddressAction(Constants.ReportAddressActionEnum.VIEWADDRS.getCode(), addresses, request, null);
            return "meila/address/list";
        } else {
            return "redirect:/address/add.xhtml";
        }
    }

    /**
     *
     * 功能描述：上报社区 地址操作数据 void
     * 
     * @param action
     * @param addresses
     * @param request
     * @param addressId 地址ID slug
     * 
     * @Exception :
     */

    private void doReportAddressAction(String action, List<AddressVO> addresses, HttpServletRequest request, String addressId) {
        // 向社区上报数据
        try {
            String userId = super.getCurrentUser().getId();
            Long addressIdLong = addressId == null ? null : IdTypeHandler.decode(addressId);
            int count = CollectionUtils.isNotEmpty(addresses) ? addresses.size() : 0;
            ReportAddrActModel reportModel = new ReportAddrActModel();
            reportModel.setAction(action);
            reportModel.setCount(count);
            reportModel.setSource(MeiLaDeviceUtils.isApp(request) ? "" : "web");
            reportModel.setUserId(IdTypeHandler.decode(userId));
            reportModel.setAddrId(addressIdLong);

            ReportModel repModel = MeiLaSNSReportUtils.createReportModel(action, request, userId);
            if (Constants.ReportAddressActionEnum.VIEWADDRS.getCode().equals(action)) {
                repModel.getAction().getExtra_data().put("count", count);
            } else {
                repModel.getAction().getExtra_data().put("addr_id", addressIdLong);
            }
            reportModel.setReportModel(repModel);
            meiLaSNSReportService.onAddressAction(reportModel);
        } catch (Exception e) {
            logger.error("向社区上报地址操作数据失败", e);
        }
        // 向社区上报数据

    }

    @RequestMapping("add.xhtml")
    public String add(@RequestParam(required = true, defaultValue = "") String skuId, String needIdCard, HttpServletRequest req, Model model) {
        model.addAttribute("is_wechat", true);
        model.addAttribute("app_link", true);

        model.addAttribute("title_label", "我的收货地址");
        model.addAttribute("skuId", skuId);
        model.addAttribute("needIdCard", Objects.toString(needIdCard, ""));
        return "meila/address/address";
    }

    /**
     * 功能描述：保存收获地址
     * 
     * @param form
     * @param req
     * @param model
     * @param referer
     * @return
     */
    @ResponseBody
    @RequestMapping("save.json")
    public JsonResult save(@ModelAttribute AddressForm form, String needIdCard, @RequestParam(required = true, defaultValue = "") String skuId,
        HttpServletRequest request) {
        JsonResult result = new JsonResult();
        try {
            this.addressVerify(form, needIdCard);
            Address address = new Address();
            BeanUtils.copyProperties(form, address);
            AddressVO addressVO = addressService.saveUserAddress(address);
            result.setData("/ptuan/address/list.xhtml?skuId=" + skuId + "&needIdCard=" + java.util.Objects.toString(needIdCard, ""));

            // 上报社区 地址操作数据
            String referer = request.getHeader("referer");
            String action = Constants.ReportAddressActionEnum.ADDADDR.getCode();
            if (StringUtils.isNotBlank(referer) && StringUtils.indexOf(referer, "/edit") != -1) {
                action = Constants.ReportAddressActionEnum.EDITADDR.getCode();
            }
            doReportAddressAction(action, null, request, addressVO.getId());

            return result;
        } catch (BizException e) {
            result.setRet(JsonResult.FAILED);

            if (GlobalErrorCode.INTERNAL_ERROR.equals(e.getErrorCode())) {
                result.setErrCode(e.getBizCode());
                result.setMsg(e.getMessage());
            } else {
                result.setErrCode(Constants.GeneralError.EXCEPTION.getCode());
                result.setMsg(Constants.GeneralError.EXCEPTION.getValue());
            }
            return result;
        }
    }

    /**
     *
     * 功能描述：地址后端校验方法
     * 
     * @param form
     * @param needIdCard void
     *
     */
    private void addressVerify(AddressForm form, String needIdCard) {
        // 收货人姓名非空与长度校验
        if (StringUtils.isBlank(form.getConsignee())) {
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, Constants.GeneralError.NAME__EMPTY.getCode(),
                Constants.GeneralError.NAME__EMPTY.getValue());
        } else {
            if (form.getConsignee().getBytes().length > 20) {
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, Constants.GeneralError.NAME__TOO_LONG.getCode(),
                    Constants.GeneralError.NAME__TOO_LONG.getValue());
            }
        }

        // 保税仓商品校验
        if ("1".equals(needIdCard)) {
            // 保税仓商品，需要填写身份证和中文姓名
            if (StringUtils.isBlank(form.getIdCard())) {
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, Constants.GeneralError.IDCARD_EMPTY_ERROR.getCode(),
                    Constants.GeneralError.IDCARD_EMPTY_ERROR.getValue());
            }

            if (!NameUtils.isChinese(form.getConsignee())) {
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, Constants.GeneralError.NAME__NOT_CHINESE.getCode(),
                    Constants.GeneralError.NAME__NOT_CHINESE.getValue());
            }

        }

        // 身份证有效性校验，如果填写了就校验
        if (StringUtils.isNotBlank(form.getIdCard()) && !IdCardUtils.isIDCard(form.getIdCard())) {
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, Constants.GeneralError.IDCARD_FORMAT_ERROR.getCode(),
                Constants.GeneralError.IDCARD_FORMAT_ERROR.getValue());
        }
        // 手机号码非空校验
        if (StringUtils.isBlank(form.getPhone())) {
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, Constants.GeneralError.MOBILE_EMPTY_ERROR.getCode(),
                Constants.GeneralError.MOBILE_EMPTY_ERROR.getValue());
        }
        // 校验手机号码位数与规则
        if (!this.checkPhoneNo(form.getPhone())) {
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, Constants.GeneralError.MOBILE_FORMAT_ERROR.getCode(),
                Constants.GeneralError.MOBILE_FORMAT_ERROR.getValue());
        }

        // 省市区校验
        int zoneIdInt = 0;
        try {
            zoneIdInt = Integer.valueOf(form.getZoneId());

        } catch (Exception ex) {
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, Constants.GeneralError.EXCEPTION.getCode(), "省市区设置错误");
        }
        if (0 == zoneIdInt) {
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, Constants.GeneralError.EXCEPTION.getCode(), "省市区设置错误");
        }
        // 详情地址非空与长度校验
        if (StringUtils.isBlank(form.getStreet())) {
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, Constants.GeneralError.STREET__EMPTY.getCode(),
                Constants.GeneralError.STREET__EMPTY.getValue());
        } else {
            if (form.getStreet().getBytes().length > 200) {
                throw new BizException(GlobalErrorCode.INTERNAL_ERROR, Constants.GeneralError.STREET__TOO_LONG.getCode(),
                    Constants.GeneralError.STREET__TOO_LONG.getValue());
            }
        }
    }

    /**
     * 功能描述：跳转到收货地址
     * 
     * @param id
     * @param req
     * @param model
     * @param referer
     * @return
     */
    @RequestMapping("{id}/edit.xhtml")
    public String edit(@PathVariable("id") String id, String needIdCard, @RequestParam(required = true, defaultValue = "") String skuId,
        Model model) {
        model.addAttribute("is_wechat", true);
        model.addAttribute("app_link", true);

        model.addAttribute("title_lebal", "我的收货地址");
        Address address = addressService.load(id);
        model.addAttribute("address", address);
        model.addAttribute("needIdCard", Objects.toString(needIdCard, ""));
        model.addAttribute("skuId", skuId);
        List<Zone> parents = zoneService.listParents(address.getZoneId());

        Zone province = null;
        List<Zone> provinceList = null;
        if (parents.size() > 1) {
            province = parents.get(1);
            provinceList = zoneService.listSiblings(province.getId());
        } else {
            provinceList = zoneService.listChildren("1");
        }
        model.addAttribute("province", province);
        model.addAttribute("provinceList", provinceList);

        Zone city = null;
        List<Zone> cityList = null;
        if (parents.size() > 2) {
            city = parents.get(2);
            cityList = zoneService.listSiblings(city.getId());
        }
        model.addAttribute("city", city);
        model.addAttribute("cityList", cityList);

        Zone district = null;
        List<Zone> districtList = null;
        if (parents.size() > 3) {
            district = parents.get(3);
            districtList = zoneService.listSiblings(district.getId());
        }
        model.addAttribute("district", district);
        model.addAttribute("districtList", districtList);
        return "meila/address/address";
    }

    @ResponseBody
    @RequestMapping("{addressId}/delete.json")
    public JsonResult addressesDelete(@PathVariable("addressId") String addressId, HttpServletRequest request) {
        JsonResult result = new JsonResult();
        try {
            this.addressService.delete(addressId);
            doReportAddressAction(Constants.ReportAddressActionEnum.DELADDR.getCode(), null, request, addressId);
            return result;
        } catch (BizException e) {
            result.setRet(JsonResult.FAILED);
            result.setErrCode(e.getBizCode());
            result.setMsg(e.getMessage());
            return result;
        }
    }

    @ResponseBody
    @RequestMapping("{addressId}/asDefault.json")
    public JsonResult addressesDefault(@PathVariable("addressId") String addressId) {
        JsonResult result = new JsonResult();
        try {
            this.addressService.asDefault(addressId);
            return result;
        } catch (BizException e) {
            result.setRet(JsonResult.FAILED);
            result.setErrCode(e.getBizCode());
            result.setMsg(e.getMessage());
            return result;
        }
    }

    private boolean checkPhoneNo(String phoneNo) {
        // 如果为空
        if (StringUtils.isBlank(phoneNo)) {
            return false;
        }
        // 如果不等于11位
        if (StringUtils.length(phoneNo) != 11) {
            return false;
        }
        // 如果不全为数字
        if (!StringUtils.isNumeric(phoneNo)) {
            return false;
        }

        // 如果不是1开头的
        if (!StringUtils.startsWith(phoneNo, "1")) {
            return false;
        }
        return true;
    }
}
