/**
 * @Title:MustDateException.java
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

public class MustDateException extends TemplateModelException {

	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = 2924832331376094299L;

	public MustDateException(String paramName) {
		super("The \"" + paramName + "\"  参数必须是一个日期类型.");
	}
}
