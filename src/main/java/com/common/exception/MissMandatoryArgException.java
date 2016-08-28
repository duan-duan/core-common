/**
 * 
 */
package com.common.exception;

/**
 * @author huanggaoren
 *
 */
public class MissMandatoryArgException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -307337889247782985L;

	public MissMandatoryArgException(String s) {
		super(s);
	}

	public MissMandatoryArgException() {
		super();
	}

	public MissMandatoryArgException(String message, Throwable cause) {
		super(message, cause);
	}

	public MissMandatoryArgException(Throwable cause) {
		super(cause);
	}
}
