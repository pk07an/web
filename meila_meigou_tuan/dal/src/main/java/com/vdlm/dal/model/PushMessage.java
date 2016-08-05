package com.vdlm.dal.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vdlm.dal.BaseEntityImpl;
import com.vdlm.dal.status.PushMessageStatus;
import com.vdlm.dal.type.PushMessageDeviceType;
import com.vdlm.dal.type.PushMessageType;
import com.vdlm.dal.util.json.JsonResourceUrlSerializer;

/**
 * push到客户端的消息对象
 * 
 * @author odin
 * 
 */
public class PushMessage extends BaseEntityImpl {
	private static final long serialVersionUID = 1L;
	
	private Integer msgId;
	
	private String userId;

	private String title;

	private String desc;

	@JsonSerialize(using = JsonResourceUrlSerializer.class)
	private String imageUrl;

	private String detailUrl;
	
	private PushMessageDeviceType deviceType;

	private PushMessageType type;
	
	private Integer msgType;

	private PushMessageStatus status;
	
	private Integer count;
	
	private String orderId;
	
	private String productId;
	
	private String app;
	
	private Object extData;
	
	/**
	 * 百度云推送暂时只支持tag方式发送消息，解决一个用户多点登录的场景
	 */
	private String baiduTagName;

	private Long baiduChannelId;

	private String baiduUserId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDetailUrl() {
		return detailUrl;
	}

	public void setDetailUrl(String detailUrl) {
		this.detailUrl = detailUrl;
	}

	public PushMessageStatus getStatus() {
		return status;
	}

	public void setStatus(PushMessageStatus status) {
		this.status = status;
	}
	
	public PushMessageDeviceType getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(PushMessageDeviceType deviceType) {
		this.deviceType = deviceType;
	}

	public PushMessageType getType() {
		return type;
	}

	public void setType(PushMessageType type) {
		this.type = type;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public boolean valid(){
		return true;
	}
	
	public String getBaiduTagName() {
		return baiduTagName;
	}

	public void setBaiduTagName(String baiduTagName) {
		this.baiduTagName = baiduTagName;
	}
	
	public Long getBaiduChannelId() {
		return baiduChannelId;
	}

	public void setBaiduChannelId(Long baiduChannelId) {
		this.baiduChannelId = baiduChannelId;
	}

	public String getBaiduUserId() {
		return baiduUserId;
	}

	public void setBaiduUserId(String baiduUserId) {
		this.baiduUserId = baiduUserId;
	}

	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Object getExtData() {
		return extData;
	}

	public void setExtData(Object extData) {
		this.extData = extData;
	}

	public Integer getMsgId() {
		return msgId;
	}

	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}

}
