package com.vdlm.service.export;

/**
 *
 * @author: chenxi
 */

public abstract class AbstractFileDestGenerator implements FileDestGenerator {

	protected String rootPath;
	protected String fileName;
	
	public String getRootPath() {
		return rootPath;
	}
	
	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
