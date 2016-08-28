/**
 * @Title:MustNumberException.java
 *
 * @Package:com.common.exception
 *
 * @Desciption:TODO
 *
 * @author aijava
 * 
 * @date Nov 7, 2012 11:27:56 PM
 * 
 * @version V1.0
 *
 */
package com.common.exception;

import freemarker.template.TemplateModelException;

public class MustNumberException extends TemplateModelException {

	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = -5658404008635680402L;

	public MustNumberException() {
		super();
	}

	public MustNumberException(String paramName) {
		super("这个 \"" + paramName + "\" 参数必须是一个数字类型.");
	}
}
