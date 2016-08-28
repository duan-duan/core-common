package com.common.util;

import com.common.entity.BaseSerializable;

/**
 * 返回结果类
 * @author guoqiushi
 *
 */
public class BaseResponse implements BaseSerializable{
	
	private static final long serialVersionUID = 1L;
	
	private static BaseResponse baseResponse = new BaseResponse();
	
	protected BaseResponse() {
	}
	
	public static BaseResponse getInstance(){
		return baseResponse;
	}
	
    private boolean flag;//返回页面true or  false
    
    /**
     * 返回的对象
     */
    private Object result;
    
    /**
     * 返回码
     */
    public String code;
    /**
     * 返回码描述
     */
    public String text;
    
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
		this.setText(code);
	}

	public BaseResponse(boolean flag) {
		this.flag = flag;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getText() {
		return text;
	}

	public void setText(String code) {
		this.text = ReturnCode.codeToMsg(code);
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
