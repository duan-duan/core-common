/**
 * 
 */
package com.common.exception;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author zhanghaiyang
 *
 */
public class CodeException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2034566880751102888L;

    private String code;
    
    private String message;

    public CodeException(String code) {
        super();
        this.code = code;
    }

    public CodeException(String code, String message) {
        this.message = message;
        this.code = code;
    }

    public CodeException(String code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public CodeException(String errorCode, String message, Throwable cause) {
        super(message, cause);

        this.code = errorCode;
    }

    public String getCode() {
        return code;
    }
    
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 封装错误码和错误信息到Map中
	 * 
	 * @param map
	 * @param code
	 * @param message
	 */
	public static void setCodeExceptionInToMap(Map<String,Object> map,String code,String message){
		if(null==map){
			map = Maps.newHashMap();
		}
		map.put("CodeException", new CodeException(code,message));
	}
}
