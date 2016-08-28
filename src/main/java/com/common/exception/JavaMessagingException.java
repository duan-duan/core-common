/**
 * 
 */
package com.common.exception;

/**
 * @author huanggaoren jms消息异常
 */
public class JavaMessagingException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3208096414456628423L;

	public JavaMessagingException() {
		super();
	}

	public JavaMessagingException(String message) {
		super(message);
	}

	public JavaMessagingException(String message, Throwable cause) {
		super(message, cause);
	}

	public JavaMessagingException(Throwable cause) {
		super(cause);
	}

}
