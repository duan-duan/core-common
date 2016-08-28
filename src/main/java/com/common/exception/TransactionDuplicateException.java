/**
 * 
 */
package com.common.exception;

/**
 * 
 * @ClassName:TransactionDuplicateException
 *
 * @Description:TODO(这里用一句话描述这个类的作用)
 *
 * @author huanggaoren itorac@sina.com
 * 
 * @date 2014年6月11日 下午11:03:49
 *
 */
public class TransactionDuplicateException extends BaseException {

	/**
	 * @Fields serialVersionUID :TODO (用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -6511659833050823753L;
	private String remark;

	public TransactionDuplicateException(String s) {
		super(s);
	}

	public TransactionDuplicateException() {
		super();
	}

	public TransactionDuplicateException(String message, Throwable cause) {
		super(message, cause);
	}

	public TransactionDuplicateException(String message, String remark) {
		super(message);
		this.remark = remark;
	}

	public TransactionDuplicateException(Throwable cause) {
		super(cause);
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
