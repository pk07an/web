package com.vdlm.dal.page;

/**
 * 分页类
 * 
 * @author huxaya
 *
 */
public class PageHelper implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private int page = 0;// 当前页
	private int pageSize = 10;// 每页显示记录数
	private int startNo;
	private String sort;// 排序字段
	private String order;// asc/desc
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSort() {
		return sort;
	}
	
	public int getStartNo() {
		this.startNo = this.getPage()*this.getPageSize();
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	
}
