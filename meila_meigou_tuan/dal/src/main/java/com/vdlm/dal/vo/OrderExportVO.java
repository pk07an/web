package com.vdlm.dal.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vdlm.dal.model.*;
import com.vdlm.dal.mybatis.IdTypeHandler;
import com.vdlm.dal.type.LogisticsCompany;
import com.vdlm.dal.type.PaymentMode;
import com.vdlm.dal.type.RefundType;
import com.vdlm.dal.util.json.JsonResourceUrlSerializer;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderExportVO extends Order {

	private static final long serialVersionUID = 1L;

    private String item_id ;
    private String product_id ;
    private String shop_id ;
    private String addr_id ;
    private String zone_id ;
    private String product_name ;
    private String buyer_name ;
    private String buyer_phone ;
    private String buyer_id_str ;
    private String seller_name ;
    private String shop_name ;
    private BigDecimal price ;
    private BigDecimal per_discount_fee ;//优惠券
    private BigDecimal product_fee ;//商品销量*单价
    private String  sku_product_id ;//sku与product id联合
    private String  sku_id ;
    private String  sku_str ;
    private Long amount ;
    private String phone ;
    private String consignee ;
    private String full_address ;
    private String settlement_status ; //结算状态
    private String refund_status ; //结算状态
    private String refundStatusStr ; //结算状态
    private String logisticsCompanyStr ;
    private String success_at_str ;
    private String paid_at_str ;
    private String create_at_str ;
    private String shipped_at_str ;
    private String refund_at_str ;
    private String dealRefundAt ;
    private String payTypeStr1 ;

    private String status_str ;


    private String trade_no ;
    private String out_id ;
    private BigDecimal per_total_fee ; //每件商品优惠券后的价格
    private BigDecimal getPer_total_fee_2 ; //每件商品优惠券后的价格

    private String product_id_str ;

    public String getBuyer_id_str() {
        if(this.getBuyerId()==null){
            return "" ;
        }
        return String.valueOf(IdTypeHandler.decode(this.getBuyerId()));
    }

    public void setBuyer_id_str(String buyer_id_str) {
        this.buyer_id_str = buyer_id_str;
    }

    public String getCreate_at_str() {
        if(this.getCreatedAt()==null){
            return "";
        }
        return DateFormatUtils.format(this.getCreatedAt(), "yyyy-MM-dd HH:mm:ss");
    }
    public String getRefund_at_str() {
        if(this.getRefundAt()==null){
            return "";
        }
        return DateFormatUtils.format(this.getRefundAt(), "yyyy-MM-dd HH:mm:ss");
    }
    public String getDealRefundAt() {
        return dealRefundAt;
    }

    public String getShipped_at_str() {
        if(this.getShippedAt()==null){
            return "";
        }
        return DateFormatUtils.format(this.getShippedAt(), "yyyy-MM-dd HH:mm:ss");
    }

    public void setCreate_at_str(String create_at_str) {
        this.create_at_str = create_at_str;
    }

    public String getPaid_at_str() {
        if(this.getPaidAt()==null){
            return "";
        }
        return DateFormatUtils.format(this.getPaidAt(), "yyyy-MM-dd HH:mm:ss");
    }

    public void setPaid_at_str(String paid_at_str) {
        this.paid_at_str = paid_at_str;
    }

    public String getSuccess_at_str() {
        if(this.getSucceedAt()==null){
            return "";
        }
        return DateFormatUtils.format(this.getSucceedAt(), "yyyy-MM-dd HH:mm:ss");
    }

    public void setSuccess_at_str(String success_at_str) {
        this.success_at_str = success_at_str;
    }

    public String getStatus_Str() {
        if (this.getStatus() == null) {
            return "";
        }
        String str = "";
        switch (this.getStatus()) {
            case SUBMITTED:
                str = "已提交";
                break;
            case CANCELLED:
                str = "取消";
                break;
            case PAID:
                str = "已付款";
                break;
            case SHIPPED:
                str = "已发货";
                break;
            case SUCCESS:
                str = "交易成功";
                break;
            case REFUNDING:
                str = "退款申请中";
                break;
            case CLOSED:
                str = "交易关闭";
                break;
            default:
                str = this.getStatus().toString();
                break;
        }
        return str;
    }

    public String getSettlement_status() {
        String str = "";
        if(StringUtils.isBlank(settlement_status)){
            settlement_status = "0" ;
        }
        switch (settlement_status) {
            case "0":
                str = "未结算";
                break;
            case "1":
                str = "已结算";
                break;
        }
        return str;
    }

    public void setSettlement_status(String settlement_status) {
        this.settlement_status = settlement_status;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getShop_id() {
        return shop_id;
    }

    public void setShop_id(String shop_id) {
        this.shop_id = shop_id;
    }

    public String getAddr_id() {
        return addr_id;
    }

    public void setAddr_id(String addr_id) {
        this.addr_id = addr_id;
    }

    public String getZone_id() {
        return zone_id;
    }

    public void setZone_id(String zone_id) {
        this.zone_id = zone_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getBuyer_name() {
        return buyer_name;
    }

    public void setBuyer_name(String buyer_name) {
        this.buyer_name = buyer_name;
    }
    
    public String getSeller_id_str() {
        if(this.getSellerId()==null){
            return "" ;
        }
        return String.valueOf(IdTypeHandler.decode(this.getSellerId()));
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getFull_address() {
        return full_address;
    }

    public void setFull_address(String full_address) {
        this.full_address = full_address;
    }

    public BigDecimal getPer_discount_fee() {
        return per_discount_fee;
    }

    public void setPer_discount_fee(BigDecimal per_discount_fee) {
        this.per_discount_fee = per_discount_fee;
    }

    public String getSku_product_id() {
        return sku_product_id;
    }

    public void setSku_product_id(String sku_product_id) {
        this.sku_product_id = sku_product_id;
    }

    public String getSku_id() {
        return sku_id;
    }

    public void setSku_id(String sku_id) {
        this.sku_id = sku_id;
    }

    public String getSku_str() {
        return sku_str;
    }

    public void setSku_str(String sku_str) {
        this.sku_str = sku_str;
    }

    public String getBuyer_phone() {
        return buyer_phone;
    }

    public void setBuyer_phone(String buyer_phone) {
        this.buyer_phone = buyer_phone;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getOut_id() {
        return out_id;
    }

    public void setOut_id(String out_id) {
        this.out_id = out_id;
    }

    public BigDecimal getPer_total_fee() {
    	BigDecimal price = null == this.price ? BigDecimal.ZERO : this.price;
    	BigDecimal discountFee = null == getDiscountFee() ? BigDecimal.ZERO : getDiscountFee();
    	BigDecimal amount = null == this.amount ? BigDecimal.ZERO : new  BigDecimal(this.amount);
    	
    	BigDecimal perTotalFee = price.multiply(amount).subtract(discountFee); // price * amount - discountFee
        return perTotalFee.doubleValue() >= 0 ? perTotalFee : price;
    }

    public BigDecimal getPer_total_fee_2() {
        BigDecimal price = null == this.price ? BigDecimal.ZERO : this.price;
        BigDecimal discountFee = null == getPer_discount_fee() ? BigDecimal.ZERO : getPer_discount_fee();
        BigDecimal amount = null == this.amount ? BigDecimal.ZERO : new  BigDecimal(this.amount);

        BigDecimal perTotalFee = price.multiply(amount).subtract(discountFee); // price * amount - discountFee
        return perTotalFee.doubleValue() >= 0 ? perTotalFee : price;
    }

    public void setPer_total_fee(BigDecimal per_total_fee) {
        this.per_total_fee = per_total_fee;
    }

    public String getProduct_id_str() {
        if(this.getProduct_id()==null){
            return "" ;
        }
        return String.valueOf(IdTypeHandler.decode(this.getProduct_id()));
    }

    public void setProduct_id_str(String product_id_str) {
        this.product_id_str = product_id_str;
    }

	public String getPayTypeStr() {
		PaymentMode type = this.getPayType();
		if (null == type) {
			return "";
		} else if (PaymentMode.WEIXIN.equals(type)) {
			return "微信";
		} else  if (PaymentMode.ALIPAY.equals(type)) {
			return "支付宝";
		} else {
			return type.toString();
		}
	}

    public String getPayTypeStr1() {
        String type = this.getOut_id();
        if (null == type) {
            return "";
        } else if ("WEIXIN".equals(type)) {
            return "微信";
        } else  if ("ALIPAY".equals(type)) {
            return "支付宝";
        } else {
            return type.toString();
        }
    }

    public String getRefund_status() {
       return  refund_status ;
    }

    public void setRefund_status(String refund_status) {
        this.refund_status = refund_status;
    }

    public String getRefundStatusStr() {
        if (this.getRefund_status() == null) {
            return "";
        }
        String str = "";
        switch (this.getRefund_status()) {
            case "0":
                str = "无退款";
                break;
            case "1":
                str = "可退款";
                break;
            case "2":
                str = "正常";
                break;
            case "3":
                str = "待买家退货";
                break;
            case "4":
                str = "待卖家收货";
                break;
            case "5":
                str = "失败";
                break;
            case "91":
                str = "已取消";
                break;
            case "92":
                str = "申请通过";
                break;
            case "93":
                str = "退款完成";
                break;
            default:
                str = this.getRefund_status().toString();
                break;
        }
        return str;
    }

    public void setRefundStatusStr(String refundStatusStr) {
        this.refundStatusStr = refundStatusStr;
    }

    public BigDecimal getProduct_fee() {
        return product_fee;
    }

    public void setProduct_fee(BigDecimal product_fee) {
        this.product_fee = product_fee;
    }

    public String getLogisticsCompanyStr() {
        if(StringUtils.isBlank(this.getLogisticsCompany())){
            return "" ;
        }
        /*
        若是英文，试着转换为中文
         */
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(this.getLogisticsCompany());
        if(m.find()){
            return this.getLogisticsCompany();
        }else{
            LogisticsCompany lc = LogisticsCompany.valueOf(this.getLogisticsCompany());
            return lc==null?this.getLogisticsCompany():lc.getName();
        }
    }

    public void setLogisticsCompanyStr(String logisticsCompanyStr) {
        this.logisticsCompanyStr = logisticsCompanyStr;
    }
}
