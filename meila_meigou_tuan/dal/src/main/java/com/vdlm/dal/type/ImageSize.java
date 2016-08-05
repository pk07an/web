package com.vdlm.dal.type;

public enum ImageSize {
	SIZE1(80, 80), SIZE2(200, 200), SIZE3(300, 300);

	private ImageSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public String toString() {
		return width + "_" + height;
	}

	private int width;
	private int height;
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
