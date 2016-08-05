package com.vdlm.web.thymeleaf.dialect;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.doctype.resolution.IDocTypeResolutionEntry;
import org.thymeleaf.doctype.translation.IDocTypeTranslation;
import org.thymeleaf.processor.IProcessor;

import com.vdlm.biz.res.ResourceFacade;

public class VdlmDialect extends AbstractDialect {

	private ResourceFacade resourceFacade;

	/**
	 * @param resourceFacade
	 *            资源识别器
	 */
	public VdlmDialect(ResourceFacade resourceFacade) {
		this.resourceFacade = resourceFacade;
	}

	@Override
	public String getPrefix() {
		return "vd";
	}

	@Override
	public Set<IProcessor> getProcessors() {
		final Set<IProcessor> processors = new HashSet<IProcessor>(2);
		processors.add(new VdHrefResourceProcessor(resourceFacade));
		processors.add(new VdSrcResourceProcessor(resourceFacade));
		processors.add(new PriceTextDisplayProcessor());
		return processors;
	}

	@Override
	public Map<String, Object> getExecutionAttributes() {
		// TODO Auto-generated method stub
		return super.getExecutionAttributes();
	}

	@Override
	public Set<IDocTypeTranslation> getDocTypeTranslations() {
		// TODO Auto-generated method stub
		return super.getDocTypeTranslations();
	}

	@Override
	public Set<IDocTypeResolutionEntry> getDocTypeResolutionEntries() {
		// TODO Auto-generated method stub
		return super.getDocTypeResolutionEntries();
	}

}
