/**
 * 
 */
package com.common.interceptor;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.common.exception.BaseException;
import com.common.exception.CountOutOfBoundsException;
import com.common.exception.QuantityNotEnoughException;
import com.common.exception.RangeException;
import com.common.exception.TransactionDuplicateException;
import com.common.web.util.ResponseUtils;

/**
 * @author huanggaoren
 *
 */
@SuppressWarnings({ "static-access", "unchecked" })
public class ExceptionInterceptor extends HandlerInterceptorAdapter {
	
	private final static Logger log = Logger.getLogger(ExceptionInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (ex != null) {
			String msg = "";
			if (ex instanceof BaseException) {
				msg = ex.getMessage();
			} else if (ex instanceof CountOutOfBoundsException) {
				msg = "超出最大个数";
			} else if (ex instanceof RangeException) {
				msg = "范围异常";
			} else if (ex instanceof TransactionDuplicateException) {
				msg = "重复异常";
			} else if (ex instanceof QuantityNotEnoughException) {
				msg = "数量不够异常";
			} else if (ex instanceof NullPointerException) {
				msg = "空指针异常";
			} else if (ex instanceof IOException) {
				msg = "文件读写异常";
			} else {
				msg = ex.toString();
			}
			logger(request, handler, ex);
			response.setStatus(response.SC_SERVICE_UNAVAILABLE);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("success", false);
			result.put("msg", msg);
			ResponseUtils.renderJson(response, result);
		} else {
			super.afterCompletion(request, response, handler, ex);
		}
	}

	/**
	 * 记录日志
	 * 
	 * @param request
	 * @param handler
	 * @param ex
	 */

	private void logger(HttpServletRequest request, Object handler, Exception ex) {
		StringBuffer msg = new StringBuffer();
		msg.append("异常拦截日志");
		msg.append("[uri＝").append(request.getRequestURI()).append("]");
		Enumeration<String> enumer = request.getParameterNames();
		while (enumer.hasMoreElements()) {
			String name = (String) enumer.nextElement();
			String[] values = request.getParameterValues(name);
			msg.append("[").append(name).append("=");
			if (values != null) {
				int i = 0;
				for (String value : values) {
					i++;
					msg.append(value);
					if (i < values.length) {
						msg.append("｜");
					}

				}
			}
			msg.append("]");
		}
		log.error(msg, ex);
	}

}
