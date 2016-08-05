package com.vdlm.dal.meilavo;

import java.util.List;

import com.vdlm.dal.model.Image;
import com.vdlm.dal.model.OrderItemComment;

public class MeiLaSaveOrderItemCommentVO extends OrderItemComment{

	private static final long serialVersionUID = 1L;
	
	private List<Image> images;

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}
	
}
