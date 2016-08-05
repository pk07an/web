package com.vdlm.dal.type;

public enum LogisticsCompany {
	SF_EXPRESS("顺丰速运","http://www.sf-express.com/"),
    YTO("圆通速递","http://www.yto.net.cn/"),
    STO("申通快递","http://www.sto.cn/"),
    ZTO("中通快递","http://www.zto.cn/"),
    BESTEX("汇通快运","http://www.htky365.com/"),
    YUNDA("韵达快递","http://www.yundaex.com/"),
    TTKD("天天快递","http://www.ttkdex.com/"),
    QFKD("全峰快递","http://www.qfkd.com.cn/"),
    ZJS("宅急送","http://www.zjs.com.cn/"),
    EMS("EMS","http://www.ems.com.cn/"), 
    OTHER("其它物流","");
	// cash on delivery

	private LogisticsCompany(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}
	
	public String getUrl(){
		return url;
	}

	private String name;
	private String url;
}
