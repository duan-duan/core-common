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
public class GenericResponseHeader implements BaseSerializable {

	private static final long serialVersionUID = -50654568185794250L;

	private String responseCode = "";

	private String remark = "";

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

}
