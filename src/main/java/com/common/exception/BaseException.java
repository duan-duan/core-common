/**
 * 
 */
package com.common.exception;

/**
 * @author huanggaoren
 * 
 */
public class BaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3315617598767145701L;

	public BaseException(String s) {
		super(s);
	}

	public BaseException() {
		super();
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}
}
