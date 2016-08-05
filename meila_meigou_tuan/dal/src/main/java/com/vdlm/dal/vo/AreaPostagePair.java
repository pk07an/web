package com.vdlm.dal.vo;

import java.math.BigDecimal;
import java.util.List;

public class AreaPostagePair {
	
	private BigDecimal poatage;
	private List<AreaPair> areas;
	
	public BigDecimal getPoatage() {
		return poatage;
	}
	public void setPoatage(BigDecimal poatage) {
		this.poatage = poatage;
	}
	public List<AreaPair> getAreas() {
		return areas;
	}
	public void setAreas(List<AreaPair> areas) {
		this.areas = areas;
	}
	
}
