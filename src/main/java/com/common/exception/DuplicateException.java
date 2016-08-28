/**
 * 
 */
package com.common.exception;

/**
 * 
 * @ClassName:DuplicateException
 * 
 * @Description:TODO 重复异常
 * 
 * @author huanggaoren itorac@sina.com
 * 
 * @date 2014年6月25日 下午11:02:36
 * 
 */
public class DuplicateException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String remark;

	public DuplicateException(String s) {
		super(s);
	}

	public DuplicateException() {
		super();
	}

	public DuplicateException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateException(String message, String remark) {
		super(message);
		this.remark = remark;
	}

	public DuplicateException(Throwable cause) {
		super(cause);
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
