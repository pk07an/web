package com.vdlm.dal.vo;

import java.util.Date;

public class OrderRefundOperateDetail {

	private static final long serialVersionUID = 1L;

	int type;   // 0-文字; 1-图片url;    未定义类型-显示default内容
	int from;	//1系统 2买家 3卖家
	java.util.Date time;
	String title; // 标题为空时，不显示标题与分割线；
	String content;
	String defaultTitle;
	String defaultContent;
	
	public OrderRefundOperateDetail(){
		
	}
	
	public OrderRefundOperateDetail(int type, int from, Date time,
			String title, String content) {
		super();
		this.type = type;
		this.from = from;
		this.time = time;
		this.title = title;
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public java.util.Date getTime() {
		return time;
	}
	public void setTime(java.util.Date time) {
		this.time = time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDefaultTitle() {
		return defaultTitle;
	}
	public void setDefaultTitle(String defaultTitle) {
		this.defaultTitle = defaultTitle;
	}
	public String getDefaultContent() {
		return defaultContent;
	}
	public void setDefaultContent(String defaultContent) {
		this.defaultContent = defaultContent;
	}
	
	
}
