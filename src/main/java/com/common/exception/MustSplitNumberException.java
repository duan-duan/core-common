/**
 * @Title:MustSplitNumberException.java
 *
 * @Package:com.common.exception
 *
 * @Desciption:TODO
 *
 * @author huanggaoren
 * 
 * @version V1.0
 *
 */
package com.common.exception;

import freemarker.template.TemplateModelException;

public class MustSplitNumberException extends TemplateModelException {

	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 2454928249748657173L;

	public MustSplitNumberException(String paramName) {
		super("The \"" + paramName
				+ "\" parameter must be a number split by ','");
	}

	public MustSplitNumberException(String paramName, Exception cause) {
		super("The \"" + paramName
				+ "\" parameter must be a number split by ','", cause);
	}
}
