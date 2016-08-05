package com.vdlm.dal.model;

public class HelperMessage {
	
	private String id;
	
	private String title;
	
	private String intro;
	
	private String icon;
	
	private String iconKey;
	
	private String url;
	
	private boolean archive;
	
	private int sort;
	
	public String getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getIconKey() {
		return iconKey;
	}
	public void setIconKey(String iconKey) {
		this.iconKey = iconKey;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean getArchive() {
		return archive;
	}
	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
}
