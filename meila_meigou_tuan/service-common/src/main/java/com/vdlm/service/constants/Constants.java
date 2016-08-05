package com.vdlm.service.constants;

import com.vdlm.service.error.GlobalErrorCode;

/**
 * @类名： Constants.java
 * @描述：常量定义类
 * @作者： toney
 * @修改日期： 2015年6月15日
 */
public class Constants {

    public enum GeneralError{
        EXCEPTION(String.valueOf(GlobalErrorCode.INTERNAL_ERROR.getErrorCode()),"亲  系统繁忙，请稍后再试！"),
        NOT_FOUND(String.valueOf(GlobalErrorCode.NOT_FOUND.getErrorCode()),"亲  系统资源未找到，请稍后再试！"),
        OBJ_EXIST("OBJ_EXIST","亲  对象已经存在不能再次操作！"),
        MOBILE_EMPTY_ERROR("MOBILE_EMPTY_ERROR","请填写手机号"),
        MOBILE_FORMAT_ERROR("MOBILE_FORMAT_ERROR","亲 手机号格式错误哦~"),
        IDCARD_FORMAT_ERROR("IDCARD_FORMAT_ERROR","请填写正确的身份证号码。"),
        IDCARD_EMPTY_ERROR("IDCARD_EMPTY_ERROR","亲 身份证必须填写哦~"),
        NAME__EMPTY("NAME__EMPTY","请填写收货人信息"),
        NAME__TOO_LONG("NAME__TOO_LONG","收货人信息太长，最多20字符"),
        NAME__NOT_CHINESE("NAME__NOT_CHINESE","请填写正确的收货人姓名以便海关清关哦~"),
        STREET__EMPTY("STREET__EMPTY","请填写详细地址"),
        STREET__TOO_LONG("STREET__TOO_LONG","详细地址太长，最多200字符"),
        OBJ_EMPTY("OBJ_EMPTY","亲  对象不能为空哦~"),
        NOT_FOUND_ADDRESS("NOT_FOUND_ADDRESS","亲  没有找到对应的地址");
        private final String code;
        private final String value;
        private GeneralError(String code, String value) {
            this.code = code;
            this.value = value;
        }
        public String getCode() {
            return code;
        }
        public String getValue() {
            return value;
        }
    }
    
    public enum ReportAddressActionEnum{
        VIEWADDRS("view_addrs","地址列表"),
        ADDADDR("add_addr","添加地址"),
        DELADDR("del_addr","删除地址"),
        EDITADDR("edit_addr","编辑地址");
        private final String code;
        private final String value;
        private ReportAddressActionEnum(String code, String value) {
            this.code = code;
            this.value = value;
        }
        public String getCode() {
            return code;
        }
        public String getValue() {
            return value;
        }
    }
    
    public enum SnsReportActionEnum {
        EC_VIEW_ACT_LIST("ec_view_act_list","查看拼团活动列表"),
        EC_VIEW_TUAN_LIST("ec_view_tuan_list","查看我的拼团"),
        EC_VIEW_TUAN_PRODUCT_DETAIL("ec_view_tuan_product_detail","查看商品详情"),
        EC_VIEW_TUAN_ORDER_CONFIRM("ec_view_tuan_order_confirm","团订单确认"),
        EC_VIEW_TUAN_INFO("ec_view_tuan_info","团状态页"),
        CREATEORDERITEM("create_orderitem","创建订单条目"),
        CREATEORDERS("createorders","创建订单");
        private final String code;
        private final String value;

        private SnsReportActionEnum(String code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getCode() {
            return code;
        }

        public String getValue() {
            return value;
        }
    }
}
