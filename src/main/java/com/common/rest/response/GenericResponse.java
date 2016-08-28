package com.common.rest.response;

import com.common.entity.BaseSerializable;


/**
 * 
 * @ClassName:GenericResponse
 *
 * @Description:TODO(这里用一句话描述这个类的作用)
 *
 * @author huanggaoren itorac@sina.com
 * 
 * @date 2014年6月11日 下午10:50:40
 *
 * @param <T>
 */
public class GenericResponse<T> implements BaseSerializable {

	private static final long serialVersionUID = 2111778438971236835L;

	private GenericResponseHeader header = new GenericResponseHeader();

	private T body;

	public GenericResponseHeader getHeader() {
		return header;
	}

	public void setHeader(GenericResponseHeader header) {
		this.header = header;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
	
	public static GenericResponse buildErrorResponse(){
		GenericResponse response = new GenericResponse();
		response.getHeader().setResponseCode("500");
		return response;
	}
}
