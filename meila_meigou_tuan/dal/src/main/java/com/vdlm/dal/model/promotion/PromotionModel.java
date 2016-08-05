package com.vdlm.dal.model.promotion;

import java.sql.Timestamp;
import java.util.Date;

import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.model.ObjectRange;
import com.vdlm.dal.model.Product;
import com.vdlm.dal.model.Shop;

/**
 * The most important class in promotion framework.
 *
 * @author: chenxi
 */

public class PromotionModel extends BaseEntityImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1074633248139603134L;
	
	private String partner;
	private String sellerId;
	/** 
	 * the id of partner/shop/product/sku/buyer and so on, see {@link #objId}
	 */
	private String objId; 
	/**
	 * this field and objId can determine a unique object id.
	 */
	private ObjectRange range; 
	/**
	 * the start date of the promotion activity
	 */
	private Date start;
	/**
	 * the start end of the promotion activity
	 */
	private  Date end;
	/**
	 * a fast el condition
	 */
	private String condition;
	/**
	 * exhaustively list almost all possible scenarios in promotion activity
	 */
	private PromotionActionType action;
	/**
	 * a json like string which provide some concrete values in all types of promotion scenarios, which is used in
	 * all kinds of promotion rules like {@link ShopPromotionRule}, {@link ProductPromotionRule}, {@link OrderPromotionRule} 
	 * and so on for process.
	 */
	private String actionData;
	/**
	 * the priority of the promotion model, the combination of {@link #priority}, {@link #objId} and {@link #range} must
	 * be unique in the global scope.
	 */
	private int priority;
	/**
	 * whether the start date and end date is periodically
	 */
	private boolean periodicity = false;
	/**
	 * the quartz cron expression only works when {@link #periodicity} is true, which creates a quartz job which will be triggered 
	 * to update {@link #start} and {@link #end} at proper time.
	 */
	private String cronExpression;
	/**
	 * the max number of purchase
	 */
	private int maxAmount;
	/**
	 * the id of {@link CouponCode}, null indicates no coupon
	 */
	private String couponCodeId;
	/**
	 * the max credit can be used in this promotion activity
	 */
	private int maxCredit;
	/**
	 * true indicates several promotion rules can be composed in one activity, Note the value only effect the 
	 * upper level {@link PromotionModel}
	 * false indicates when a promotion rule match it, no other promotion rule can continue
	 * 
	 * The {@link PromotionModel} match order is from highest ordinal to lowest ordinal in {@link ObjectRange}
	 */
	private boolean superposition = false;
	/**
	 * true indicates this is a platform promotion activity, which is always a superposition to other
	 * {@link PromotionModel}s, in this case the field {@link PromotionModel#superposition} has no sense
	 * At most cases, the range field should be {@link ObjectRange#PARTNER}
	 * 
	 * false by default
	 */
	private boolean platform = false;
	/**
	 * this description is also important, which can be used in {@link ShopPromotionRule}, {@link ProductPromotionRule} 
	 * and so on to inject this field to {@link Shop} view or {@link Product} view for displaying 
	 */
	private String description;
	
	public String getPartner() {
		return partner;
	}
	
	public void setPartner(String partner) {
		this.partner = partner;
	}
	
	public String getSellerId() {
		return sellerId;
	}
	
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	
	public String getObjId() {
		return objId;
	}
	
	public void setObjId(String objId) {
		this.objId = objId;
	}
	
	public ObjectRange getRange() {
		return range;
	}
	
	public void setRange(ObjectRange range) {
		this.range = range;
	}
	


	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getCondition() {
		return condition;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public PromotionActionType getAction() {
		return action;
	}
	
	public void setAction(PromotionActionType action) {
		this.action = action;
	}
	
	public String getActionData() {
		return actionData;
	}
	
	public void setActionData(String actionData) {
		this.actionData = actionData;
	}
	
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean isPeriodicity() {
		return periodicity;
	}
	
	public void setPeriodicity(boolean periodicity) {
		this.periodicity = periodicity;
	}
	
	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public int getMaxAmount() {
		return maxAmount;
	}
	
	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}
	
	public String getCouponCodeId() {
		return couponCodeId;
	}
	
	public void setCouponCodeId(String couponCodeId) {
		this.couponCodeId = couponCodeId;
	}
	
	public int getMaxCredit() {
		return maxCredit;
	}
	
	public void setMaxCredit(int maxCredit) {
		this.maxCredit = maxCredit;
	}
	
	public boolean isSuperposition() {
		return superposition;
	}
	
	public void setSuperposition(boolean superposition) {
		this.superposition = superposition;
	}
	
	public boolean isPlatform() {
		return platform;
	}
	
	public void setPlatform(boolean platform) {
		this.platform = platform;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "PromotionModel [partner=" + partner + ", sellerId=" + sellerId
				+ ", objId=" + objId + ", range=" + range + ", start=" + start
				+ ", end=" + end + ", condition=" + condition + ", action="
				+ action + ", actionData=" + actionData + ", priority="
				+ priority + ", periodicity=" + periodicity
				+ ", cronExpression=" + cronExpression + ", maxAmount="
				+ maxAmount + ", couponCodeId=" + couponCodeId + ", maxCredit="
				+ maxCredit + ", superposition=" + superposition
				+ ", platform=" + platform + ", description=" + description
				+ "]";
	}
	
}
