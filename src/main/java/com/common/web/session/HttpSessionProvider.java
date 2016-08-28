package com.common.web.session;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * HttpSession提供类
 */
public abstract class HttpSessionProvider {

	/**
	 * 获取Session
	 * 
	 * @param request
	 * @param name
	 * @return
	 */
	public static Serializable getAttribute(HttpServletRequest request,
			String name) {
		HttpSession session = request.getSession(true);
		if (session != null) {
			return (Serializable) session.getAttribute(name);
		} else {
			return null;
		}
	}

	/**
	 * 设置Session
	 * 
	 * @param request
	 * @param response
	 * @param name
	 * @param value
	 */
	public static void setAttribute(HttpServletRequest request, String name,
			Serializable value) {
		HttpSession session = request.getSession(true);
		session.setAttribute(name, value);
	}

	/**
	 * 获取SessionId
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public static String getSessionId(HttpServletRequest request) {
		return request.getSession(true).getId();
	}

	/**
	 * 销毁Session
	 * 
	 * @param request
	 * @param response
	 */
	public static void invalidateSerssion(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

	/**
	 * 删除Session值
	 * 
	 * @param request
	 * @param key
	 */
	public static void removeAttribute(HttpServletRequest request, String key) {
		request.getSession(true).removeAttribute(key);
	}

}
