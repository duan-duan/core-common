package com.common.exception;

public class BusinessException extends BaseException{

	private static final long serialVersionUID = -3851616875836340001L;
	
	public BusinessException() {
		
	}
	
	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public BusinessException(Throwable cause) {
		super(cause);
	}

}
