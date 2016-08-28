/**
 * 
 */
package com.common.exception;

/**
 * 
 * @ClassName:CountOutOfBoundsException
 * 
 * @Description:TODO <p>
 *                   UR异常
 *                   </p>
 * 
 * @author huanggaoren
 * 
 */
public class URLException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7584715458852604673L;

	private String remark;

	public URLException(String s) {
		super(s);
	}

	public URLException() {
		super();
	}

	public URLException(String message, Throwable cause) {
		super(message, cause);
	}

	public URLException(String message, String remark) {
		super(message);
		this.remark = remark;
	}

	public URLException(Throwable cause) {
		super(cause);
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
