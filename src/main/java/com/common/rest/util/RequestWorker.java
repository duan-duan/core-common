package com.common.rest.util;

import org.apache.commons.lang.NullArgumentException;

import com.common.exception.DuplicateException;
import com.common.exception.IdentifyKeyNotExistException;
import com.common.exception.NegativeQtyException;
import com.common.exception.QuantityNotEnoughException;
import com.common.exception.TransactionDuplicateException;
import com.common.rest.response.GenericResponse;
import com.common.rest.response.GenericResponseHeader;
import com.common.util.JaxbUtils;
import com.common.util.LogTracking;

/**
 * 
 * @ClassName:RequestWorker
 *
 * @Description:TODO
 *
 * @author huanggaoren itorac@sina.com
 * 
 * @date 2014年6月11日 下午10:46:27
 *
 * @param <T>
 */
public abstract class RequestWorker<T> {

	protected abstract T processRequest() throws Exception;

	public RequestWorker() {

	}

	public RequestWorker(Object data) {
		this.data = data;
	}

	private Object data = null;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	private String getRequestXml() {
		if (data != null) {
			return JaxbUtils.convertToXmlString(data);
		} else {
			return "";
		}
	}

	public GenericResponse<T> execute() {
		GenericResponse<T> response = new GenericResponse<T>();
		GenericResponseHeader header = new GenericResponseHeader();
		// 默认为100,也就是代表成功

		String error = "";
		Exception ex = null;
		String respCode = "100";
		try {
			T t = processRequest();
			response.setBody(t);
		} catch (TransactionDuplicateException e) {
			error = "transactionDuplicate:501";
			ex = e;
			// 重复请求
			respCode = "501";
			header.setRemark(e.getRemark());
		} catch (DuplicateException e) {
			error = "DuplicateException:504";
			ex = e;
			// 重复请求
			respCode = "504";
			header.setRemark(e.getRemark());
		} catch (IdentifyKeyNotExistException e) {
			error = "IdentifyKeyNotExistException:601";
			ex = e;
			// 信息不存在
			respCode = "601";
			header.setRemark(e.getRemark());

		} catch (QuantityNotEnoughException e) {
			error = "QuantityNotEnoughException:602";
			ex = e;
			// 数量不足
			respCode = "602";
			header.setRemark(e.getRemark());
		} catch (NullArgumentException e) {
			error = "NullArgumentException:603";
			ex = e;
			// 缺少reserveNUM或transactionID
			respCode = "603";
			header.setRemark(e.getMessage());
		} catch (NegativeQtyException e) {
			error = "NegativeQtyException:604";
			ex = e;
			// 数量为负数
			respCode = "604";
			header.setRemark(e.getRemark());
		} catch (Exception e) {
			ex = e;
			// 如果出错，那么可以在这里判断抛出的Exception，来设置对应的reponseCode
			respCode = "500";
		}
		if (!respCode.equalsIgnoreCase("100")) {
			LogTracking.errorLog(this.getClass(), "execute", error
					+ getRequestXml());
			LogTracking.errorLog(this.getClass(), "Exception", ex);
		}
		header.setResponseCode(respCode);
		response.setHeader(header);
		return response;
	}

}
