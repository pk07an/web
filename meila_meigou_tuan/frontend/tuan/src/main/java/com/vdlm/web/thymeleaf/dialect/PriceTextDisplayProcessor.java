package com.vdlm.web.thymeleaf.dialect;

import org.springframework.context.i18n.LocaleContextHolder;
import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.attr.AbstractTextChildModifierAttrProcessor;
import org.thymeleaf.standard.expression.Expression;
import org.thymeleaf.standard.expression.StandardExpressions;

import com.vdlm.dal.type.Money;
import com.vdlm.utils.CommonUtils;

public class PriceTextDisplayProcessor extends AbstractTextChildModifierAttrProcessor {

	/**
	 * Sets the name of this processor to be used in Thymeleaf template
	 */
	public PriceTextDisplayProcessor() {
		super("price");
	}

	@Override
	public int getPrecedence() {
		return 1500;
	}

	@Override
	protected String getText(Arguments arguments, Element element, String attributeName) {

		Money price = null;

		Expression expression = (Expression) StandardExpressions.getExpressionParser(arguments.getConfiguration())
				.parseExpression(arguments.getConfiguration(), arguments, element.getAttributeValue(attributeName));
		Object result = expression.execute(arguments.getConfiguration(), arguments);
		if (result instanceof Money) {
			price = (Money) result;
		} else if (result instanceof Number) {
			price = new Money(((Number) result).doubleValue());
		}

		if (price == null) {
			return "N/A";
		}

		// TODO use current user locale
		return CommonUtils.getNumberFormatFromCache(LocaleContextHolder.getLocale(), price.getCurrency()).format(price.getAmount());
	}
}