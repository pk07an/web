package com.vdlm.dal.type;

/**
 * 商品采购地(国家及地区)
 * @authory ongqi.wu@meila.com
 */
public enum PurchaseSourceEnum{
	
 // A
    AUSTRIA("奥地利", "AUT"),
    AUSTRALIA("澳大利亚", "AU"),
    IRELAND("爱尔兰","IE"),
    EMIRATES("阿联酋", "AE"),
    MACAO("澳门", "MO"),
    
    // B
    POLAND("波兰","PL"),
    BELGIUM("比利时","BE"),
    BRAZIL("巴西", "BR"),
    
    // D
    GERMANY("德国", "DE"),
    DENMARK("丹麦", "DNK"),
    
    // E
    RUSSIAN("俄罗斯", "RU"),
    
    // F
    FRANCE("法国", "FR"),
    PHILIPPINES("菲律宾","PH"),
    
    // H
    KOREA("韩国", "KR"),
    HOLLAND("荷兰", "NLD"),
    
    // J
    CZECH("捷克","CS"),
    CANADA("加拿大", "CA"),
    
    // M
    AMERICA("美国", "US"),
    MALAYSIA("马来西亚", "MY"),
    MEXICO("墨西哥","MX"),
    
    // N
    NEPAL("尼泊尔","NP"),
    SOUTHAFRICA("南非", "ZA"),
    
    // P
    PORTUGAL("葡萄牙","PT"),
    
    // R
    JAPAN("日本", "JP"),
    SWEDEN("瑞典", "SE"),
    
    // S
    SWITZERLAND("瑞士", "CH"),
    
    // T
    TURKEY("土耳其", "TR"),
    THAILAND("泰国", "TH"),
    TAIWAN("台湾", "TW"),

    // X
    SPAIN("西班牙", "ES"),
    HONGKONG("香港", "HK"),
    SINGAPORE("新加坡","SG"),
    NEWZEALAND("新西兰","NZ"),
    SYRIA("叙利亚 ", "SYR"),
    
    // W
    UKRAINE("乌克兰","UA"),
    
    // Y 
    ITALY("意大利", "IT"),
    ENGLAND("英国", "UK"),
    
    // Z
    CHINA("中国", "CN");
	
	private String name;
	private String code;

	private PurchaseSourceEnum(String name, String code) {
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}