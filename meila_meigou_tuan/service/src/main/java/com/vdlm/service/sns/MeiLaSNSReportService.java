package com.vdlm.service.sns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.vdlm.dal.model.Order;
import com.vdlm.dal.model.OrderItem;
import com.vdlm.dal.mybatis.IdTypeHandler;
import com.vdlm.meila.client.MeilaClient;
import com.vdlm.meila.client.OnPurchaseModel;
import com.vdlm.meila.client.ReportAddrActModel;
import com.vdlm.meila.client.ReportLogUtils;
import com.vdlm.meila.client.ReportModel;
import com.vdlm.service.constants.Constants;
import com.vdlm.utils.CommonUtils;

@Service
public class MeiLaSNSReportService {
    private static final Logger logger = LoggerFactory.getLogger(MeiLaSNSReportService.class);

    @Autowired
    @Lazy
    private MeilaClient meilaClient;

    @Autowired
    private ThreadPoolTaskExecutor syncTaskExecutor;

    public void onPurchaseToMeila(final OnPurchaseModel model) {
        syncTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    logger.info("向社区上报购物流程访问数据:{}", CommonUtils.objectToString(model));
                    ReportLogUtils.doReport(model.getReportModel());
                    meilaClient.doOnPurchaseToMeila(model);
                } catch (Throwable t) {
                    logger.error("向社区上报物流程访问数据失败,数据:" + CommonUtils.objectToString(model), t);
                }
            }
        });
    }

    /**
     * 功能描述：订单提交上报订单数据.
     * 
     * @param orders
     * @param sourceMap
     * @param cartItems
     * @param prices
     * @param extUserId
     */
    public void notifyOtherSystem(final Order order, final Map<String, String> sourceMap, final List<OrderItem> orderItems,
        final ReportModel reportModel) {
        logger.info("开始处理订单提交上报订单数据......");
        syncTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                reportModel.getUser().setId(IdTypeHandler.decode(order.getBuyerId()));
                List<ReportModel> reportList = new ArrayList<ReportModel>();
                ReportModel orderReportModel = new ReportModel();
                try {
                    BeanUtils.copyProperties(reportModel, orderReportModel);
                } catch (Exception ex) {
                }
                orderReportModel.getAction().setName(Constants.SnsReportActionEnum.CREATEORDERS.getCode());
                Map<String, Object> exterdata = new HashMap<String, Object>();
                exterdata.put("discount_price", order.getDiscountFee());
                exterdata.put("in_channel", sourceMap.get("in_channel"));
                exterdata.put("paid_price", order.getTotalFee());
                exterdata.put("pay_no", order.getPayNo());
                exterdata.put("utm_activity", sourceMap.get("utm_activity"));
                exterdata.put("utm_channel", sourceMap.get("utm_channel"));
                orderReportModel.getAction().setExtra_data(exterdata);
                reportList.add(orderReportModel);

                Map<String, Object> map = new HashMap<String, Object>();
                map.put("suborders", new ArrayList<Map<String, Object>>());
                map.put("pay_type", "");
                map.put("discount_price", order.getDiscountFee());
                map.put("trade_no", order.getPayNo());
                map.put("utm_source", sourceMap.get("utm_source"));
                map.put("utm_channel", sourceMap.get("utm_channel"));
                map.put("utm_user", sourceMap.get("utm_user"));
                map.put("in_channel", sourceMap.get("in_channel"));
                map.put("utm_medium", sourceMap.get("utm_medium"));
                map.put("utm_activity", sourceMap.get("utm_activity"));
                map.put("total_price", order.getTotalFee());
                // 美币
                map.put("discount_coin", "0");
                map.put("source", sourceMap.get("source"));
                map.put("user_id", IdTypeHandler.decode(order.getBuyerId()));

                ArrayList<Map<String, Object>> suborders = new ArrayList<Map<String, Object>>();

                for (OrderItem orderItem : orderItems) {
                    ReportModel orderItemReportModel = new ReportModel();
                    try {
                        BeanUtils.copyProperties(reportModel, orderItemReportModel);
                    } catch (Exception ex) {

                    }
                    orderReportModel.getAction().setName(Constants.SnsReportActionEnum.CREATEORDERITEM.getCode());
                    Map<String, Object> exterOrderItemdata = new HashMap<String, Object>();
                    exterOrderItemdata.put("count", orderItem.getAmount());
                    exterOrderItemdata.put("ware_id", IdTypeHandler.decode(orderItem.getProductId()));
                    exterOrderItemdata.put("sku_id", IdTypeHandler.decode(orderItem.getSkuId()));
                    exterOrderItemdata.put("cart_item_id", 0);
                    exterOrderItemdata.put("order_item_id", IdTypeHandler.decode(orderItem.getId()));
                    exterOrderItemdata.put("price", orderItem.getPrice());
                    orderItemReportModel.getAction().setExtra_data(exterOrderItemdata);
                    reportList.add(orderItemReportModel);

                    Map<String, Object> itemMap = new HashMap<String, Object>();
                    itemMap.put("count", orderItem.getAmount());
                    itemMap.put("ware_id", IdTypeHandler.decode(orderItem.getProductId()));
                    itemMap.put("total_price", order.getTotalFee().toString());
                    itemMap.put("trade_no", order.getOrderNo());
                    itemMap.put("cart_item_id",0);
                    itemMap.put("order_item_id", IdTypeHandler.decode(orderItem.getId()));
                    suborders.add(itemMap);

                }
                map.put("suborders", suborders);
                try {
                    boolean notify = meilaClient.notifySNSOrder(JSONObject.toJSONString(map));
                    logger.info("上报社区订单 订单order_no:{} 参数信息:{} 通知结果:{}", new Object[] { map.get("trade_no"), JSONObject.toJSONString(map), notify });
                } catch (Exception e) {
                    logger.error("通知社区，上报订单失败,参数信息:{}", e, new Object[] { JSONObject.toJSONString(map) });
                }
            }
        });
    }
    
    public void onAddressAction(final ReportAddrActModel model){
        syncTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    logger.info("向社区上报地址操作访问数据:{}", CommonUtils.objectToString(model));
                    ReportLogUtils.doReport(model.getReportModel());
                    meilaClient.doAdderssActionToMeila(model);
                } catch (Throwable t) {
                    logger.error("向社区上报地址操作访问数据失败,数据:" + CommonUtils.objectToString(model), t);
                }
            }
        }); 
    }
}
