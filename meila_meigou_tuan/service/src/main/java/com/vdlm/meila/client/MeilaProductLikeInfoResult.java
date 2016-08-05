package com.vdlm.meila.client;

import java.util.List;

public class MeilaProductLikeInfoResult {

	private Integer sns_status;
	private Boolean is_collected;
	private MeilaProductLikeInfo info;
	private List<MeilaProductRecommendation> recommendations;

	public MeilaProductLikeInfo getInfo() {
		return info;
	}

	public void setInfo(MeilaProductLikeInfo info) {
		this.info = info;
	}

	public List<MeilaProductRecommendation> getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(List<MeilaProductRecommendation> recommendations) {
		this.recommendations = recommendations;
	}

	public Integer getSns_status() {
		return sns_status;
	}

	public void setSns_status(Integer sns_status) {
		this.sns_status = sns_status;
	}

	public Boolean getIs_collected() {
		return is_collected;
	}

	public void setIs_collected(Boolean is_collected) {
		this.is_collected = is_collected;
	}

}
