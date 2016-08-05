package com.vdlm.dal.type;

public enum LogisticsCompanyInfo {
	DMJY("1", "gongsineibu", "当面交易", ""),
	SF_EXPRESS("190090", "shunfeng", "顺丰快递", "shunfeng"),
	ZTO("260050", "zhongtong", "中通快递", "zhongtong"),
	YUNDA("250140", "yunda", "韵达快递", "yunda"),
    BESTEX("80090", "huitongkuaidi", "汇通快递", "huitongkuaidi"),
    YTO("250100", "yuantong", "圆通速递", "yuantong"),
    STO("190070", "shentong", "申通快递", "shentong"),
    EMS("50000", "ems", "EMS经济快递", "ems"), 
    XFWL("240010", "xinfengwuliu", "信丰物流", "xinfengwuliu"),
    YZ("250060", "youzhengguonei", "邮政-国内邮件/挂号信", "youzhengguonei"),
    GTKD("70040", "guotongkuaidi", "国通快递", "guotongkuaidi"),
    TTKD("200010", "tiantian", "天天快递", "tiantian"),  
    QFKD("170010", "quanfengkuaidi", "全峰快递", "quanfengkuaidi"),
    ZJS("260000", "zhaijisong", "宅急送", "zhaijisong"),
    KJKD("110010", "kuaijiesudi", "快捷快递", "kuaijiesudi"),
    YSKD("250040", "youshuwuliu", "优速快递", "youshuwuliu");    

	
	private String company_name;
	private String company_no;
	private String company_remark;
	private String company_com;
	
	private LogisticsCompanyInfo(String company_no, String remark,String company_name, String com) {
		this.company_no = company_no;
		this.company_name = company_name;		
		this.company_remark = remark;
		this.company_com = com;
	}
	
	public static String getCompany_com(String company_name) {
		for(LogisticsCompanyInfo c : LogisticsCompanyInfo.values()) {
		    if(c.getCompany_name().equals(company_name)) {
				return c.getCompany_com();		              
			}
		}
	   return null;
	}

    public static String getCompany_name(String company_no) {
		for(LogisticsCompanyInfo c : LogisticsCompanyInfo.values()) {
		    if(c.getCompany_no().equals(company_no)) {
				return c.getCompany_name();		              
			}
		}
	   return null;
	}		

    public static String getCompany_nameByCode(String enumCode) {
		for(LogisticsCompanyInfo c : LogisticsCompanyInfo.values()) {
		    if(c.name().equals(enumCode)) {
				return c.getCompany_name();		              
			}
		}
	   return null;
	}		
    
	public String getCompany_name() {
		return company_name;
	}
	
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	public String getCompany_no() {
		return company_no;
	}
	
	public void setCompany_no(String company_no) {
		this.company_no = company_no;
	}

	public String getCompany_remark() {
		return company_remark;
	}

	public void setCompany_remark(String company_remark) {
		this.company_remark = company_remark;
	}

	public String getCompany_com() {
		return company_com;
	}

	public void setCompany_com(String company_com) {
		this.company_com = company_com;
	}
	
}
