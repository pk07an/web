package com.vdlm.service.tuan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meila.dal.slave.dao.OrderItemSlaveDao;
import com.meila.dal.slave.dao.TuanActivitySlaveDao;
import com.meila.dal.slave.dao.TuanOrderSlaveDao;
import com.vdlm.dal.mapper.OrderAddressMapper;
import com.vdlm.dal.mapper.OrderExtMapper;
import com.vdlm.dal.mapper.OrderItemMapper;
import com.vdlm.dal.mapper.OrderItemPromotionMapper;
import com.vdlm.dal.mapper.OrderMapper;
import com.vdlm.dal.mapper.TuanOrderMapper;
import com.vdlm.dal.mapper.TuanStatusMapper;
import com.vdlm.dal.model.Address;
import com.vdlm.dal.model.Order;
import com.vdlm.dal.model.OrderAddress;
import com.vdlm.dal.model.OrderExt;
import com.vdlm.dal.model.OrderItem;
import com.vdlm.dal.model.OrderItemPromotion;
import com.vdlm.dal.model.Product;
import com.vdlm.dal.model.TuanActivity;
import com.vdlm.dal.model.TuanOrder;
import com.vdlm.dal.model.TuanStatus;
import com.vdlm.dal.model.User;
import com.vdlm.dal.model.Zone;
import com.vdlm.dal.mybatis.IdTypeHandler;
import com.vdlm.dal.status.OrderStatus;
import com.vdlm.dal.type.OrderType;
import com.vdlm.dal.type.UserPartnerType;
import com.vdlm.meila.client.MeilaClient;
import com.vdlm.meila.client.MeilaUser;
import com.vdlm.meila.client.ReportModel;
import com.vdlm.service.address.AddressService;
import com.vdlm.service.address.AddressVO;
import com.vdlm.service.constants.Constants;
import com.vdlm.service.error.BizException;
import com.vdlm.service.error.GlobalErrorCode;
import com.vdlm.service.product.MeiLaProductService;
import com.vdlm.service.product.vo.ProductSkuVO;
import com.vdlm.service.sns.MeiLaSNSReportService;
import com.vdlm.service.tuan.status.TuanOrderStatus;
import com.vdlm.service.tuan.status.TuanType;
import com.vdlm.service.tuan.status.UserTuanStatus;
import com.vdlm.service.tuan.vo.Page;
import com.vdlm.service.tuan.vo.TuanActivityVo;
import com.vdlm.service.tuan.vo.TuanAdderssVo;
import com.vdlm.service.tuan.vo.TuanOrderVo;
import com.vdlm.service.tuan.vo.TuanUserVo;
import com.vdlm.service.user.UserService;
import com.vdlm.service.zone.ZoneService;
import com.vdlm.utils.UniqueNoUtils;
import com.vdlm.utils.UniqueNoUtils.UniqueNoType;

/**
 * 
 ************************************************************
 * @类名 : TuanOrderService.java
 *
 * @DESCRIPTION :
 * @AUTHOR : peter
 * @DATE : 2016年3月1日
 ************************************************************
 */
@Service
public class TuanOrderService {
    private static Logger LOG = LoggerFactory.getLogger(TuanOrderService.class);
    @Autowired
    private AddressService addressService;
    @Autowired
    private ZoneService zoneService;
    @Autowired
    private MeiLaProductService meiLaProductService;
    @Autowired
    private TuanActivitySlaveDao tuanActivitySlaveDao;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderExtMapper orderExtMapper;
    @Autowired
    private OrderAddressMapper orderAddressMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private OrderItemPromotionMapper orderItemPromotionMapper;
    @Autowired
    private TuanStatusMapper tuanStatusMapper;
    @Autowired
    private TuanOrderMapper tuanOrderMapper;

    @Autowired
    private TuanOrderSlaveDao tuanOrderSlaveDao;
    @Autowired
    private TuanActivityService tuanActivityService;
    @Autowired
    private OrderItemSlaveDao orderItemSlaveDao;

    @Autowired
    private MeiLaSNSReportService meiLaSNSReportService;
    @Autowired
    private UserService userService;
    @Autowired
    private MeilaClient meilaClient;
    @Autowired
    private TuanStatusService tuanStatusService;

    /**
     * 功能描述：收获地址处理
     * 
     * @param addressId
     * @return
     */
    public TuanAdderssVo getAddress(String addressId) {
        TuanAdderssVo tuanAdderssVo = null;
        // 收货地址处理
        AddressVO addressVo = null;
        if (StringUtils.isNotBlank(addressId)) {
            Address address = addressService.load(addressId);
            if (null != address) {
                List<Zone> zoneList = zoneService.listParents(address.getZoneId());
                String details = "";
                for (Zone zone : zoneList) {
                    if (null != zone) {
                        details += zone.getName();
                    }

                }
                details += address.getStreet();
                addressVo = new AddressVO(address, details);
            }
        } else {
            List<AddressVO> adderssVoList = addressService.listUserAddresses();
            if (CollectionUtils.isNotEmpty(adderssVoList)) {
                addressVo = adderssVoList.get(0);
            }
        }

        if (null != addressVo) {
            tuanAdderssVo = new TuanAdderssVo();
            BeanUtils.copyProperties(addressVo, tuanAdderssVo);
            tuanAdderssVo.setAddressId(addressVo.getId());
            tuanAdderssVo.setAddressStr(addressVo.getDetails());
        }
        return tuanAdderssVo;
    }

    @Transactional
    public Map<String, String> submitTuanOrder(String userId, long actId, OrderAddress orderAddress, String remark, String orderType, String tuanNo,
        long tuanId, Map<String, String> sourceMap, ReportModel reportModel) {
        TuanActivity tuanActivity = tuanActivitySlaveDao.selectById(actId);
        if (null == tuanActivity) {
            LOG.error("找不到活动明细：" + actId);
            throw new BizException(GlobalErrorCode.NOT_FOUND, "找不到该活动");
        }
        Product product = meiLaProductService.selectByProductCode(tuanActivity.getProductCode());
        if (null == product) {
            LOG.error("找不到活动对应的商品明细：" + tuanActivity.getProductCode());
            throw new BizException(GlobalErrorCode.NOT_FOUND, "找不到该商品");
        }

        Map<String, String> resultMap = new HashMap<String, String>();
        String payNo = UniqueNoUtils.next(UniqueNoType.P);
        if ("0".equals(orderType)) {
            // 如果订单类型是0的，代表开团，重新分配团单号
            tuanNo = UniqueNoUtils.next(UniqueNoType.PT);
        }
        resultMap.put("payNo", payNo);
        resultMap.put("tuanNo", tuanNo); // hgw.2016-03-18/Add : 返回tuanNo,返回交互优化使用.

        Order order = this.createOrder(userId, remark, tuanActivity.getTuanPrice(), tuanActivity.getDiscount(), product, payNo, orderType);
        OrderExt orderExt = this.createOrderExt(sourceMap);
        List<OrderItem> orderItems = this.createOrderItem(product.getId(), tuanActivity);
        this.save(order, orderAddress, orderExt, orderItems, tuanActivity, orderType, tuanNo, tuanId, sourceMap);

        // 上报社区订单信息
        try {
            meiLaSNSReportService.notifyOtherSystem(order, sourceMap, orderItems, reportModel);
        } catch (Exception ex) {
            LOG.error("订单提交上报订单数据失败", ex);
        }
        return resultMap;
    }

    /**
     * 功能描述：把地址转化为可供订单保存的地址数据。
     * 
     * @param addressId
     * @return
     */
    public OrderAddress orderAddress(String addressId) {
        AddressVO address = addressService.loadUserAddress(addressId);
        if (address == null) {
            LOG.info("address is null ,addressId:{}", new Object[] { addressId });
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, Constants.GeneralError.NOT_FOUND_ADDRESS.getValue());
        }
        OrderAddress orderAddress = new OrderAddress();
        BeanUtils.copyProperties(address, orderAddress);
        return orderAddress;
    }

    private Order createOrder(String userId, String remark, BigDecimal tuanPrice, BigDecimal discount, Product product, String payNo,
        String orderType) {
        String orderNo = UniqueNoUtils.next(UniqueNoType.SO);
        Order order = new Order();
        order.setOrderNo(orderNo);
        order.setPayNo(payNo);
        order.setStatus(OrderStatus.SUBMITTED);
        order.setShopId(product.getShopId());
        order.setSellerId(product.getUserId());
        order.setBuyerId(userId);
        order.setType(OrderType.DANBAO);
        if (StringUtils.isNotBlank(remark)) {
            order.setRemark(remark);
        }
        order.setPartnerType(UserPartnerType.MEILA);
        // 订单金额处理
        LOG.info("团订单保存 orderNo:{} cart shopId:{} tuanprices:{} discount{}",
            new Object[] { order.getOrderNo(), order.getShopId(), tuanPrice, "0".equals(orderType) ? discount : 0 });
        order.setGoodsFee(tuanPrice);

        if ("0".equals(orderType)) {
            // 开团需要计算优惠
            order.setDiscountFee(discount);
            order.setTotalFee(tuanPrice.subtract(discount));
        } else {
            order.setDiscountFee(BigDecimal.ZERO.setScale(2));
            order.setTotalFee(tuanPrice);
        }
        order.setLogisticsFee(BigDecimal.ZERO.setScale(2));
        return order;
    }

    private OrderExt createOrderExt(Map<String, String> sourceMap) {
        OrderExt orderExt = new OrderExt();
        orderExt.setSettlementStatus(0);
        orderExt.setCoin(0);
        orderExt.setCoinPrice(BigDecimal.ZERO.setScale(2));
        orderExt.setRefundStatus(0);
        orderExt.setMcode("");
        orderExt.setTuanFlag(true);

        // utm channel
        if (sourceMap != null && sourceMap.containsKey("utm_channel") && StringUtils.isNotBlank(sourceMap.get("utm_channel"))) {
            orderExt.setUtmChannel(sourceMap.get("utm_channel"));
        } else {
            // 这个不能删除 因为数据库中必填且没有默认值，
            orderExt.setUtmChannel("");
        }

        // utm_activity
        if (sourceMap != null && sourceMap.containsKey("utm_activity") && StringUtils.isNotBlank(sourceMap.get("utm_activity"))) {
            orderExt.setUtmActivity(sourceMap.get("utm_activity"));
        } else {
            orderExt.setUtmActivity("");
        }
        // in_channel
        if (sourceMap != null && sourceMap.containsKey("in_channel") && StringUtils.isNotBlank(sourceMap.get("in_channel"))) {
            orderExt.setInChannel(sourceMap.get("in_channel"));
        } else {
            orderExt.setInChannel("");
        }

        // user slug
        if (sourceMap != null && sourceMap.containsKey("utm_user") && StringUtils.isNotBlank(sourceMap.get("utm_user"))) {
            User utmUser = userService.loadByCodeSlave(sourceMap.get("utm_user"));
            if (utmUser != null) {
                orderExt.setUtmUserId(NumberUtils.toInt(String.valueOf(IdTypeHandler.decode(utmUser.getId()))));
            }
        }

        // source
        if (sourceMap != null && sourceMap.containsKey("source") && StringUtils.isNotBlank(sourceMap.get("source"))) {
            orderExt.setSource(sourceMap.get("source"));
        }
        return orderExt;
    }

    /**
     * 功能描述： 构造订单orderItem
     * 
     * @param cartItems
     * @param cartItemMap
     * @param s
     * @return
     */
    private List<OrderItem> createOrderItem(String productId, TuanActivity tuanActivity) {
        List<OrderItem> orderItems = new ArrayList<OrderItem>(1);
        OrderItem orderItem = new OrderItem();
        ProductSkuVO productSkuVO = meiLaProductService.loadById(productId, IdTypeHandler.encode(tuanActivity.getSkuId()));
        if (productSkuVO == null) {
            LOG.info("product is null ,productId:{} ,skuId:{}", new Object[] { productId, IdTypeHandler.encode(tuanActivity.getSkuId()) });
            throw new BizException(GlobalErrorCode.INVALID_ARGUMENT, "找不到对应规格的商品");
        }

        orderItem.setProductId(productSkuVO.getId());
        // orderItem.setProductName(productSkuVO.getName());
        // 取活动的商品名称
        orderItem.setProductName(tuanActivity.getProductName());
        orderItem.setProductImg(productSkuVO.getImg());
        orderItem.setMarketPrice(tuanActivity.getSkuPrice());

        if (productSkuVO.getImgWidth() != null) {
            orderItem.setProductImgWidth(productSkuVO.getImgWidth());
        }
        if (productSkuVO.getImgHeight() != null) {
            orderItem.setProductImgHeight(productSkuVO.getImgHeight());
        }
        orderItem.setPrice(tuanActivity.getTuanPrice());
        orderItem.setSkuId(productSkuVO.getSku().getId());
        String spec = productSkuVO.getSku().getSpec1();
        spec = StringUtils.isBlank(productSkuVO.getSku().getSpec2()) ? spec : (spec + "," + productSkuVO.getSku().getSpec2());
        spec = StringUtils.isBlank(productSkuVO.getSku().getSpec3()) ? spec : (spec + "," + productSkuVO.getSku().getSpec3());
        spec = StringUtils.isBlank(productSkuVO.getSku().getSpec4()) ? spec : (spec + "," + productSkuVO.getSku().getSpec4());
        spec = StringUtils.isBlank(productSkuVO.getSku().getSpec5()) ? spec : (spec + "," + productSkuVO.getSku().getSpec5());
        orderItem.setSkuStr(spec);
        orderItem.setAmount(1);
        orderItems.add(orderItem);
        return orderItems;
    }

    private TuanStatus createTuanStatus(TuanActivity tuanActivity, String tuanNo, long userId) {
        TuanStatus tuanStatus = new TuanStatus();
        Date now = new Date();
        tuanStatus.setActId(tuanActivity.getId());
        tuanStatus.setAliveTime(tuanActivity.getActiveAlive());
        tuanStatus.setArchive(false);
        tuanStatus.setCreatedAt(now);
        tuanStatus.setMemberNum(tuanActivity.getMemberNum());
        tuanStatus.setProductId(tuanActivity.getProductId());
        tuanStatus.setSkuId(tuanActivity.getSkuId());
        tuanStatus.setStartTime(now);
        tuanStatus.setStatus(TuanOrderStatus.PROCESS.name());
        tuanStatus.setTuanNo(tuanNo);
        tuanStatus.setUpdatedAt(now);
        tuanStatus.setUserId(userId);
        tuanStatus.setTuanType(tuanActivity.getTuanType());
        return tuanStatus;
    }

    private TuanOrder createTuanOrder(TuanActivity tuanActivity, String tuanNo, long userId, long tuanId, String orderNo, String payNo,
        String orderType) {
        if (tuanId == 0) {
            throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "拼团订单下单失败");
        }
        TuanOrder tuanOrder = new TuanOrder();
        tuanOrder.setArchive(false);
        tuanOrder.setCreatedAt(new Date());
        tuanOrder.setOrderNo(orderNo);
        tuanOrder.setPayNo(payNo);
        if ("0".equals(orderType)) {
            // 开团
            tuanOrder.setRole("CHIEF");
        } else {
            tuanOrder.setRole("MEMBER");
        }
        tuanOrder.setTuanNo(tuanNo);
        tuanOrder.setUpdatedAt(new Date());
        tuanOrder.setUserId(userId);
        tuanOrder.setTuanId(tuanId);
        return tuanOrder;
    }

    @Transactional
    void save(Order order, OrderAddress orderAddress, OrderExt orderExt, List<OrderItem> orderItems, TuanActivity tuanActivity, String orderType,
        String tuanNo, long tuanId, Map<String, String> sourceMap) {
        // 插入订单
        orderMapper.insert(order);

        // 插入订单地址
        orderAddress.setOrderId(order.getId());
        orderAddressMapper.insert(orderAddress);

        // 插入订单ext表
        if (orderExt != null) {
            orderExt.setOrderId(order.getId());
            orderExt.setTuanNo(tuanNo);
            orderExtMapper.insertSelective(orderExt);
        }

        // 插入订单商品明细表
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrderId(order.getId());
            orderItemMapper.insert(orderItem);
            OrderItemPromotion orderItemPromotion = new OrderItemPromotion();
            orderItemPromotion.setOrderItemId(orderItem.getId());
            if ("0".equals(orderType)) {
                orderItemPromotion.setDiscountFee(tuanActivity.getDiscount());
            } else {
                orderItemPromotion.setDiscountFee(BigDecimal.ZERO.setScale(2));
            }

            // 插入优惠信息表
            orderItemPromotionMapper.insert(orderItemPromotion);
        }

        if ("0".equals(orderType)) {
            // 开团
            TuanStatus tuanStatus = this.createTuanStatus(tuanActivity, tuanNo, IdTypeHandler.decode(order.getBuyerId()));
            // 插入开团记录
            tuanStatusMapper.insert(tuanStatus);
            TuanOrder tuanOrder = this.createTuanOrder(tuanActivity, tuanNo, IdTypeHandler.decode(order.getBuyerId()), tuanStatus.getId(),
                order.getOrderNo(), order.getPayNo(), orderType);
            tuanOrderMapper.insert(tuanOrder);
        } else if ("1".equals(orderType)) {
            // 参团
            TuanOrder tuanOrder = this.createTuanOrder(tuanActivity, tuanNo, IdTypeHandler.decode(order.getBuyerId()), tuanId, order.getOrderNo(),
                order.getPayNo(), orderType);
            tuanOrderMapper.insert(tuanOrder);
        }
    }

    public int countValidTuanOrderByTuanNo(String tuanNo) {
        return tuanOrderSlaveDao.countValidTuanOrderByTuanNo(tuanNo);
    }

    /**
     * 
     *
     * 功能描述：我的拼团列表
     * 
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return Page<TuanOrderVo>
     *
     */
    public Page<TuanOrderVo> getMyTuanOrderList(long userId, int pageNo, int pageSize) {

        int startRow = (pageNo - 1) * pageSize;
        List<TuanOrder> tuanOrders = tuanOrderSlaveDao.selectUserTuanOrder(userId, startRow, pageSize);
        Long total = tuanOrderSlaveDao.countUserTuanOrder(userId);
        Long totalPage = this.getTotalPages(total, pageSize);

        return new Page<TuanOrderVo>(this.convertTuanOrderVoList(tuanOrders), pageNo, pageSize, totalPage.intValue(), total.intValue());
    }

    private Long getTotalPages(Long totalCount, int pageSize) {
        if (totalCount <= 0)
            return 0l;

        Long pageCount = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            pageCount++;
        }
        return pageCount;
    }

    private UserTuanStatus getUserTranStatus(TuanOrder tuanOrder, TuanStatus tuanStatus, int validTuanCount) {
        boolean isFull = false;
        if (validTuanCount >= tuanStatus.getMemberNum()) {
            isFull = true;
        }
        String orderStatus = tuanOrder.getOrderStatus();
        String status = tuanStatus.getStatus();

        // 订单已取消
        if (OrderStatus.CANCELLED.name().equals(orderStatus)) {
            return UserTuanStatus.PAY_CANCEL;
        }
        // 订单已提交
        else if ((OrderStatus.SUBMITTED.name().equals(orderStatus))) {
            if (isFull) {
                return UserTuanStatus.PAY_CANCEL;
            }
            // 待支付
            else if (TuanOrderStatus.PROCESS.name().equals(status)) {
                return UserTuanStatus.WAIT_PAID;
            }
        }

        // 订单待退款
        else if (OrderStatus.REFUNDING.name().equals(orderStatus)) {
            return UserTuanStatus.REFUNDING;
        }
        // 订单已退款
        else if (OrderStatus.CLOSED.name().equals(orderStatus)) {
            return UserTuanStatus.REFUNDED;
        }

        // 订单是已支付状态
        else {
            // 拼团成功
            if (TuanOrderStatus.SUCCESS.name().equals(status) || isFull) {
                return UserTuanStatus.SUCCESS;
            }
            // 拼团进行中
            else if (TuanOrderStatus.PROCESS.name().equals(status)) {
                UserTuanStatus userTuanStatus = UserTuanStatus.PROCESS;
                int count = tuanStatus.getMemberNum() - validTuanCount;
                userTuanStatus.setMsg("拼团中,还差<span class=\"error\">" + count + "</span>人");
                return userTuanStatus;
            }
            // 待退款
            else if (TuanOrderStatus.CANCEL.name().equals(status)) {
                return UserTuanStatus.WAIT_REFUNDING;
            }

        }

        return UserTuanStatus.WAIT_COMFIRM;
    }

    public int countValidTuanOrderByTuanNoAndUserId(String tuanNo, long userId) {
        return tuanOrderSlaveDao.countValidTuanOrderByTuanNoAndUserId(tuanNo, userId);
    }

    public TuanOrder findOrderByUser(long tuanId, long userId) {
        return tuanOrderSlaveDao.findOrderByUser(tuanId, userId);
    }

    /**
     * 
     *
     * 功能描述：根据活动id获取用户开/参团的信息
     * 
     * @param userId
     * @param actId
     * @return List<TuanOrderVo>
     *
     */
    public List<TuanOrderVo> getMyTuanOrderListByActId(long userId, long actId) {
        List<TuanOrder> tuanOrders = tuanOrderSlaveDao.selectUserTuanOrderByActId(userId, actId);
        return this.convertTuanOrderVoList(tuanOrders);
    }

    private List<TuanOrderVo> convertTuanOrderVoList(List<TuanOrder> tuanOrders) {
        List<TuanOrderVo> tuanOrderVos = new ArrayList<TuanOrderVo>();
        if (CollectionUtils.isNotEmpty(tuanOrders)) {
            for (TuanOrder tuanOrder : tuanOrders) {
                TuanStatus tuanStatus = tuanOrder.getTuanStatus();
                Date endDate = DateUtils.addHours(tuanStatus.getStartTime(), tuanStatus.getAliveTime());
                if (endDate.before(new Date()) && TuanOrderStatus.PROCESS.name().equals(tuanStatus.getStatus())) {
                    // 已经结束
                    tuanStatus.setStatus(TuanOrderStatus.CANCEL.name());

                    if (TuanType.MAJIA.name().equals(tuanOrder.getTuanStatus().getTuanType())) {
                        // 马甲模式
                        if (OrderStatus.PAID.name().equals(tuanOrder.getOrderStatus())
                                || OrderStatus.PART_SHIPPED.name().equals(tuanOrder.getOrderStatus())
                                || OrderStatus.SHIPPED.name().equals(tuanOrder.getOrderStatus())
                                || OrderStatus.SUCCESS.name().equals(tuanOrder.getOrderStatus())) {
                            tuanStatus.setStatus(TuanOrderStatus.SUCCESS.name());
                        }
                    }
                }
                TuanActivity tuanActivity = tuanActivitySlaveDao.selectById(tuanStatus.getActId());
                if (null == tuanActivity) {
                    throw new BizException(GlobalErrorCode.INTERNAL_ERROR, "找不到团活动信息");
                }
                TuanActivityVo tuanActivityVo = new TuanActivityVo();
                BeanUtils.copyProperties(tuanActivity, tuanActivityVo);
                tuanActivityService.initTuanActStatus(tuanActivity, tuanActivityVo);

                // 我的团列表取orderItem，下订单时候的信息，和订单详情保持一致
                List<OrderItem> orderItems = orderItemSlaveDao.selectOrderItemsByOrderNoAndBuyerId(tuanOrder.getOrderNo(),
                    String.valueOf(tuanOrder.getUserId()));
                OrderItem orderItem = orderItems.get(0);
                tuanActivityVo.setProductName(orderItem.getProductName());// 下订单时候活动的商品名称
                // tuanActivityVo.setImg(orderItem.getProductImg());//下订单时候的商品图片
                tuanActivityVo.setImg(tuanActivity.getImg2());// 拼团活动的商品图片
                tuanActivityVo.setSkuPrice(orderItem.getMarketPrice());// 下订单时候的原价
                tuanActivityVo.setTuanPrice(tuanOrder.getTotalFee());// 购买的价格

                TuanOrderVo tuanOrderVo = new TuanOrderVo();
                BeanUtils.copyProperties(tuanOrder, tuanOrderVo);
                tuanOrderVo.setTuanActivity(tuanActivityVo);
                tuanOrderVo.setTuanStatus(tuanStatus.getStatus());
                int validTuanCount = tuanOrderSlaveDao.countValidTuanOrderByTuanNo(tuanOrder.getTuanNo());
                // 设置还差多少人成团
                int count = tuanStatus.getMemberNum() - validTuanCount;
                tuanOrderVo.setCount(count < 0 ? 0 : count);
                UserTuanStatus userTuanStatus = this.getUserTranStatus(tuanOrder, tuanStatus, validTuanCount);
                if (null != userTuanStatus) {
                    tuanOrderVo.setStatus(userTuanStatus.getCode());
                    tuanOrderVo.setStatusDesc(userTuanStatus.getMsg());
                }

                tuanOrderVos.add(tuanOrderVo);

            }
        }
        return tuanOrderVos;
    }

    /**
     * 
     *
     * 功能描述：根据团号获取该团下用户的信息
     * 
     * @param tuanNo
     * @return List<TuanUserVo>
     *
     */
    public List<TuanUserVo> getTuanUserListByTuanNo(String tuanNo, final String currentUserId, String status) {
        List<TuanUserVo> tuanOrderUserList = new ArrayList<TuanUserVo>();

        List<TuanOrder> tuanOrderList = tuanOrderSlaveDao.findTuanOrderByTuanNo(tuanNo);
        if (CollectionUtils.isNotEmpty(tuanOrderList)) {
            Set<String> userIds = new HashSet<String>();
            for (TuanOrder tuanOrder : tuanOrderList) {
                userIds.add(String.valueOf(tuanOrder.getUserId()));
                TuanUserVo tuanUserVo = new TuanUserVo();
                tuanUserVo.setId(String.valueOf(tuanOrder.getUserId()));
                tuanUserVo.setUserRole(tuanOrder.getRole());
                tuanUserVo.setCreatedAt(tuanOrder.getCreatedAt());
                tuanOrderUserList.add(tuanUserVo);
            }

            TuanStatus tuanStatus = tuanOrderList.get(0).getTuanStatus();

            // 如果是马甲模式，并且团状态是成功的，并且参团人数少于预定的人数的
            if (TuanType.MAJIA.name().equals(tuanStatus.getTuanType()) && UserTuanStatus.SUCCESS.name().equals(status)
                    && tuanOrderList.size() < tuanStatus.getMemberNum()) {
                int needNum = tuanStatus.getMemberNum() - tuanOrderList.size();
                Set<String> maJiaUserIdSet = tuanStatusService.getMaJiaUserSet(tuanNo, needNum);
                if (CollectionUtils.isNotEmpty(maJiaUserIdSet)) {
                    for (String maJiaUserId : maJiaUserIdSet) {
                        userIds.add(maJiaUserId);
                        TuanUserVo tuanUserVo = new TuanUserVo();
                        tuanUserVo.setId(maJiaUserId);
                        tuanUserVo.setUserRole("MEMBER");
                        tuanUserVo.setCreatedAt(new Date());
                        tuanOrderUserList.add(tuanUserVo);
                    }
                }
            }

            List<MeilaUser> userList = meilaClient.getUserInfoListFromCache(userIds);

            for (TuanUserVo tuanUserVo : tuanOrderUserList) {
                if (CollectionUtils.isNotEmpty(userList)) {
                    for (MeilaUser meilaUser : userList) {
                        if (tuanUserVo.getId().equals(meilaUser.getId())) {
                            tuanUserVo.setNickName(meilaUser.getNickname());
                            tuanUserVo.setUserImg(meilaUser.getAvatar());
                        }
                    }
                }
            }
        }

        // 按创建时间时间排序，自己本人的头像排在前面
        Collections.sort(tuanOrderUserList, new Comparator<TuanUserVo>() {

            @Override
            public int compare(TuanUserVo o1, TuanUserVo o2) {
                if (o1.getId().equals(currentUserId)) {
                    return -1;
                }
                if (o2.getId().equals(currentUserId)) {
                    return 1;
                }

                return -(o1.getCreatedAt().compareTo(o2.getCreatedAt()));
            }
        });
        return tuanOrderUserList;
    }
}
