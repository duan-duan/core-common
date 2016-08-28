package com.common.exception;

/**
 * 
 * @ClassName:IdentifyKeyNotExistException
 *
 * @Description:TODO(这里用一句话描述这个类的作用)
 *
 * @author huanggaoren itorac@sina.com
 * 
 * @date 2014年6月11日 下午11:06:29
 *
 */
public class IdentifyKeyNotExistException extends BaseException {

	private static final long serialVersionUID = 633571924913019153L;

	private String remark;

	public IdentifyKeyNotExistException(String s) {
		super(s);
	}

	public IdentifyKeyNotExistException() {
		super();
	}

	public IdentifyKeyNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public IdentifyKeyNotExistException(String message, String remark) {
		super(message);
		this.remark = remark;
	}

	public IdentifyKeyNotExistException(Throwable cause) {
		super(cause);
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
