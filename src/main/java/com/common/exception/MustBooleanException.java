/**
 * @Title:MustBooleanException.java
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

public class MustBooleanException extends TemplateModelException {

	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 3045466227828850474L;

	public MustBooleanException() {
		super();
	}

	public MustBooleanException(String paramName) {
		super("这个 \"" + paramName + "\" 参数必须是一个布尔类型.");
	}
}
