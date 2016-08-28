package com.common.exception;

/**
 * 
 * @ClassName:CountOutOfBoundsException
 *
 * @Description:TODO <p>
 *                   超出最大个数
 *                   </p>
 *
 * @author huanggaoren itorac@sina.com
 * 
 * @date 2014年6月15日 下午11:01:38
 *
 */
public class CountOutOfBoundsException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6552174962624501795L;

	private String remark;

	public CountOutOfBoundsException(String s) {
		super(s);
	}

	public CountOutOfBoundsException() {
		super();
	}

	public CountOutOfBoundsException(String message, Throwable cause) {
		super(message, cause);
	}

	public CountOutOfBoundsException(String message, String remark) {
		super(message);
		this.remark = remark;
	}

	public CountOutOfBoundsException(Throwable cause) {
		super(cause);
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
