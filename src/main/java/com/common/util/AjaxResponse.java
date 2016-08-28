/**   
 * @Title: AjaxResponse.java 
 * @Package com.gome.common.util 
 * @Description: TODO 
 * @author lianzhiqiang
 * @date 2014年11月7日 下午2:21:22 
 * @version V1.0   
 */
package com.common.util;

import java.io.Serializable;

/** 
 * @ClassName: AjaxResponse 
 * @Description: TODO
 * @author lianzhiqiang
 * @date 2014年11月7日 下午2:21:22 
 *  
 */
public class AjaxResponse implements Serializable {

	/** 
	 * @Fields serialVersionUID : TODO
	 */ 
	private static final long serialVersionUID = -2273002289979854953L;

	private static AjaxResponse ajaxResponse = new AjaxResponse();
	
	protected AjaxResponse() {
	}
	
	public static AjaxResponse getInstance(){
		return ajaxResponse;
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
    

	public AjaxResponse(boolean flag) {
		this.flag = flag;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

}
