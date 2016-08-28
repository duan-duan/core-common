/**
 * 
 */
package com.common.exception;

/**
 * @author huanggaoren
 *
 */
public class PrintException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4150100692691766576L;

	private String remark;

	public PrintException(String s) {
		super(s);
	}

	public PrintException() {
		super();
	}

	public PrintException(String message, Throwable cause) {
		super(message, cause);
	}

	public PrintException(String message, String remark) {
		super(message);
		this.remark = remark;
	}

	public PrintException(Throwable cause) {
		super(cause);
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
