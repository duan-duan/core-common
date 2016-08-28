package com.common.exception;

/**
 * 
 * @ClassName:NegativeQtyException
 *
 * @Description:TODO
 *
 * @author huanggaoren itorac@sina.com
 * 
 * @date 2014年6月11日 下午11:06:16
 *
 */
public class NegativeQtyException extends BaseException {

	private static final long serialVersionUID = 6552174961624501795L;

	private String remark;

	public NegativeQtyException(String s) {
		super(s);
	}

	public NegativeQtyException() {
		super();
	}

	public NegativeQtyException(String message, Throwable cause) {
		super(message, cause);
	}

	public NegativeQtyException(String message, String remark) {
		super(message);
		this.remark = remark;
	}

	public NegativeQtyException(Throwable cause) {
		super(cause);
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
