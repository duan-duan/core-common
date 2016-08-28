/**
 * @Title:MustStringException.java
 *
 * @Package:com.common.exception
 *
 * @Desciption:TODO
 *
 * @author aijava
 * 
 * 
 * @version V1.0
 *
 */
package com.common.exception;

import freemarker.template.TemplateModelException;

/**
 * 
 * @author huanggaoren
 *
 */
public class MustStringException extends TemplateModelException {

	/**
	 * @Fields serialVersionUID:TODO
	 */
	private static final long serialVersionUID = -9123883499910572780L;

	public MustStringException() {
		super();
	}

	public MustStringException(String paramName) {
		super("这个 \"" + paramName + "\" 参数必须是一个字符串类型.");
	}

}
