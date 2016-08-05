package com.vdlm.service.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.vdlm.dal.model.Image;

public class MeilaImageUtils {
 	
	public static List<Image> meilaTrans2ImageArray(String imgArrayStr) {		 
		if (StringUtils.isBlank(imgArrayStr)) {
			return null;
		}
		List<Image> list = new ArrayList<Image>();	
		String[] strImg=imgArrayStr.split(",");
		for(int i=0;i<strImg.length;i++){
			String imgStr = strImg[i];
			String imgKey = "";
			if(!imgStr.startsWith("/")){
				imgKey = "/";
			}
			imgKey = imgKey + imgStr.substring(0, imgStr.indexOf("?"));
			String width = imgStr.substring(imgStr.indexOf("width") + 6,
					imgStr.indexOf("&"));
			String height = imgStr.substring(imgStr.indexOf("height") + 7);
			Image image = new Image();
			image.setKey(imgKey);
			image.setWidth(Integer.parseInt(width));
			image.setHeight(Integer.parseInt(height));
			list.add(image);
		}  
		return list;
	}

	public static Image meilaTrans2Image(String imgStr) {
		if (StringUtils.isBlank(imgStr)) {
			return null;
		}
//		List<String> imgArray = JSONObject.parseArray(imgStr, String.class);
//		if (imgArray != null) {
//			String imgString = imgArray.get(0);
			String imgKey = "";
			if(!imgStr.startsWith("/")){
				imgKey = "/";
			}
			imgKey = imgKey + imgStr.substring(0, imgStr.indexOf("?"));
			String width = imgStr.substring(imgStr.indexOf("width") + 6,
					imgStr.indexOf("&"));
			String height = imgStr.substring(imgStr.indexOf("height") + 7);
			Image image = new Image();
			image.setKey(imgKey);
			image.setWidth(Integer.parseInt(width));
			image.setHeight(Integer.parseInt(height));
			return image;
//		}
//		return null;
	}
	
	public static void main(String[] args) {
		Image image = MeilaImageUtils.meilaTrans2Image("[\"FlGqdkmw_0kqAJofzVSzvDYkIURp?width=540&height=540\",\"FlCzCpf8bVCQzFCLSneqFXrQ6zFJ?width=774&height=1032\"]");
		System.out.println(image.getKey());
		System.out.println(image.getWidth());
		System.out.println(image.getHeight());
	}
}
