/**
 * 
 */
package com.common.exception;

/**
 * @author huanggaoren
 * 
 */
public class RangeException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7173536999750617466L;
	private String remark;

	public RangeException(String s) {
		super(s);
	}

	public RangeException() {
		super();
	}

	public RangeException(String message, Throwable cause) {
		super(message, cause);
	}

	public RangeException(String message, String remark) {
		super(message);
		this.remark = remark;
	}

	public RangeException(Throwable cause) {
		super(cause);
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
