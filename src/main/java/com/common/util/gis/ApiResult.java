package com.common.util.gis;

import java.util.Map;
//地图共同类
public class ApiResult {
	private int code;
	private String message;
	private Map params;
	private Object data;
	
	public ApiResult() {
		code = 0;
	}
	public ApiResult(int code, String msg) {
		this.code = code;
		this.message = msg;
	}
	public ApiResult(Object data) {
		this();
		this.data = data;
	}	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("code=").append(code).append(",");
		sb.append("message=").append(message).append(",");
		sb.append("params=").append(params).append(",");
		sb.append("data=").append(data);
		return sb.toString();
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getData() {
		return data;
	}
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map getParams() {
		return params;
	}
	public void setParams(Map params) {
		this.params = params;
	}
}
