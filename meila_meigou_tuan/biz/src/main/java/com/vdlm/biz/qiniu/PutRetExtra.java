package com.vdlm.biz.qiniu;

import org.json.JSONException;
import org.json.JSONObject;

public class PutRetExtra {
	private String hash;
	private String key;
	private String url;
	private String name;
	private Integer size;
	private Integer width;
	private Integer height;
	private String suffix;
	private String imageAve;
	

	public PutRetExtra(String response) throws JSONException {
		unmarshal(response);
	}

	private void unmarshal(String json) throws JSONException {
		JSONObject jsonObject = new JSONObject(json);
		if (jsonObject.has("hash")) {
			this.hash = jsonObject.optString("hash");
		}
		if (jsonObject.has("key")) {
			this.key = jsonObject.optString("key");
		}
		if (jsonObject.has("name")) {
			this.name = jsonObject.optString("name");
		}
		if (jsonObject.has("size")) {
			this.size = jsonObject.optInt("size");
		}
		if (jsonObject.has("w")) {
			this.width = jsonObject.optInt("w");
		}
		if (jsonObject.has("h")) {
			this.height = jsonObject.optInt("h");
		}
		if (jsonObject.has("suffix")) {
			this.suffix = jsonObject.optString("suffix");
		}
		if (jsonObject.has("imageAve")) {
			this.imageAve = jsonObject.optString("imageAve");
		}
	}

	public String getHash() {
		return this.hash;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public String getUrl() {
		return url;
	}

	public String getName() {
		return name;
	}

	public Integer getSize() {
		return size;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeight() {
		return height;
	}

	public String getSuffix() {
		return suffix;
	}

	public String getImageAve() {
		return imageAve;
	}

	
}
