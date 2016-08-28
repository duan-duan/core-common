package com.common.exception;

/**
 * 
 * @ClassName:QuantityNotEnoughException
 *
 * @Description:TODO(这里用一句话描述这个类的作用)
 *
 * @author huanggaoren itorac@sina.com
 * 
 * @date 2014年6月11日 下午11:05:46
 *
 */
public class QuantityNotEnoughException extends BaseException {

	private static final long serialVersionUID = -5049915590867196505L;

	private String remark;

	public QuantityNotEnoughException(String s) {
		super(s);
	}

	public QuantityNotEnoughException() {
		super();
	}

	public QuantityNotEnoughException(String message, Throwable cause) {
		super(message, cause);
	}

	public QuantityNotEnoughException(String message, String remark) {
		super(message);
		this.remark = remark;
	}

	public QuantityNotEnoughException(Throwable cause) {
		super(cause);
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
