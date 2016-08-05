package com.vdlm.web.thymeleaf.dialect;

import com.vdlm.biz.res.ResourceFacade;

/**
 * 静态资源src url生成
 * 
 * @author jamesp
 */
public class VdHrefResourceProcessor extends VdResourceProcessor {

	public static final String ATTR_NAME = "href";

	public VdHrefResourceProcessor(ResourceFacade resourceFacade) {
		super(ATTR_NAME, resourceFacade);
	}
}
