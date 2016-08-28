/**   
 * @Title: LogTracking.java 
 * @Package com.gome.common.util 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author huangagoren itorac@sina.com.cn
 * @date 2014 2:27:24 AM 
 * @version V1.0   
 */
package com.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: LogUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author huanggaoren itorac@sina.com.cn
 * @date
 * 
 */
@SuppressWarnings("rawtypes")
public class LogTracking {

	private static final Logger log = LoggerFactory
			.getLogger(LogTracking.class);

	public LogTracking() {

	}

	/**
	 * 
	 * @Title: logDebug
	 * @Description: TODO Debug
	 * @param 调试
	 * @param message
	 * @param
	 * @param clazz
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */

	public static void logDebug(String message, Class clazz) {
		if (log.isDebugEnabled()) {
			log.debug(message + "\n" + clazz);
		}
	}

	/**
	 * 
	 * @Title: logDebug
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @param message
	 * @param
	 * @param clazz
	 * @param
	 * @param t
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void logDebug(String message, Class clazz, Throwable t) {
		if (log.isDebugEnabled()) {
			log.debug(message + "\n" + clazz, t);
		}
	}

	/**
	 * 
	 * @Title: logInfo
	 * @Description: TODO Info 信息
	 * @param
	 * @param message
	 * @param
	 * @param clazz
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void logInfo(String message, Class clazz) {
		if (log.isInfoEnabled()) {
			log.info(message + "\n" + clazz);
		}
	}

	/**
	 * 
	 * @Title: logInfo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @param message
	 * @param
	 * @param clazz
	 * @param
	 * @param t
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void logInfo(String message, Class clazz, Throwable t) {
		if (log.isInfoEnabled()) {
			log.info(message + "\n" + clazz, t);
		}
	}

	/**
	 * 
	 * @Title: logError
	 * @Description: TODO Error 错误的
	 * @param
	 * @param message
	 * @param
	 * @param clazz
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void logError(String message, Class clazz) {
		if (log.isErrorEnabled()) {
			log.error(message + "\n" + clazz);
		}
	}

	/**
	 * 
	 * @Title: logError
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @param message
	 * @param
	 * @param clazz
	 * @param
	 * @param t
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void logError(String message, Class clazz, Throwable t) {
		if (log.isErrorEnabled()) {
			log.error(message + "\n" + clazz, t);
		}
	}

	/**
	 * 
	 * @Title: logTrace
	 * @Description: TODO Trace 跟踪
	 * @param
	 * @param message
	 *            跟踪
	 * @param
	 * @param clazz
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void logTrace(String message, Class clazz) {
		if (log.isTraceEnabled()) {
			log.trace(message + "\n" + clazz);
		}
	}
	
	
	/**
	 * 
	 * @Title: logTrace
	 * @Description: TODO Trace 跟踪
	 * @param
	 * @param message
	 *            跟踪
	 * @param
	 * @param clazz
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void logTrace(String message, Object... arg) {
		if (log.isTraceEnabled()) {
			log.trace(message, arg);
		}
	}

	/**
	 * 
	 * @Title: logTrace
	 * @Description: TODO 跟踪
	 * @param
	 * @param message
	 * @param
	 * @param clazz
	 * @param
	 * @param t
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void logTrace(String message, Class clazz, Throwable t) {
		if (log.isTraceEnabled()) {
			log.trace(message + "\n" + clazz, t);
		}
	}

	/**
	 * 
	 * @Title: logTrace
	 * @Description: TODO Warn 警告
	 * @param
	 * @param message
	 * @param
	 * @param clazz
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void logWarn(String message, Class clazz) {
		if (log.isWarnEnabled()) {
			log.warn(message + "\n" + clazz);
		}
	}

	/**
	 * 
	 * @Title: logWarn
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param
	 * @param message
	 * @param
	 * @param clazz
	 * @param
	 * @param t
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void logWarn(String message, Class clazz, Throwable t) {
		if (log.isWarnEnabled()) {
			log.warn(message + "\n" + clazz, t);
		}
	}

	/**
	 * 
	 * @param obj
	 * @param methodName
	 * @param message
	 */
	public static void debugLog(Class objClass, String methodName,
			String message) {
		if (log.isDebugEnabled()) {
			String s = objClass.getName();
			log.debug(s + "." + methodName + "||" + message);
		}
	}

	/**
	 * 
	 * @param obj
	 * @param methodName
	 * @param message
	 */
	public static void debugLog(Class objClass, String methodName,
			String message, boolean bln) {
		debugLog(objClass, methodName, message + bln);
	}

	/**
	 * 
	 * @param obj
	 * @param methodName
	 * @param message
	 */
	public static void infoLog(Class objClass, String methodName, String message) {
		if (log.isInfoEnabled()) {
			String s = objClass.getName();
			log.info(s + "." + methodName + "|| " + message);
		}
	}

	/**
	 * 
	 * @param obj
	 * @param methodName
	 */
	public static void entryLog(Class objClass, String methodName) {
		infoLog(objClass, methodName, "Entering method.");
	}

	/**
	 * 
	 * @param obj
	 * @param methodName
	 * @param returnValue
	 */
	public static void exitLog(Class objClass, String methodName,
			Object returnValue) {
		infoLog(objClass, methodName, "Exiting method, returning  "
				+ returnValue);
	}

	/**
	 * 
	 * @param obj
	 * @param methodName
	 */
	public static void exitLog(Class objClass, String methodName) {
		infoLog(objClass, methodName, "|| Exiting Method.");
	}

	/**
	 * 
	 * @param obj
	 * @param methodName
	 * @param message
	 */
	public static void errorLog(Class objClass, String methodName,
			String message) {
		String s = objClass.getName();
		log.error(s + "." + methodName + "|| " + message);
	}

	/**
	 * 
	 * @param obj
	 * @param string
	 * @param exception
	 */
	public static void errorLog(Class objClass, String string,
			Throwable exception) {
		String s = objClass.getName();
		string = "Exception in " + string + "->\n" + s;
		log.error(string, exception);
	}

	/**
	 * 
	 * @param obj
	 * @param paramName
	 * @param paramValue
	 */
	public static void logParam(Class objClass, String paramName,
			Object paramValue) {
		if (log.isDebugEnabled()) {
			String s = objClass.getName();
			log.debug(s + "Received parameter, ||" + paramName + " = "
					+ paramValue);
		}
	}

	/**
	 * 
	 * @param obj
	 * @param methodName
	 * @param message
	 */
	public static void debugLog(Object objClass, String methodName,
			String message) {
		debugLog(objClass.getClass(), methodName, message);
	}

	/**
	 * 
	 * @param obj
	 * @param methodName
	 * @param message
	 */
	public static void infoLog(Object objClass, String methodName,
			String message) {
		infoLog(objClass, methodName, message);
	}

	/**
	 * 
	 * @param obj
	 * @param methodName
	 */
	public static void entryLog(Object objClass, String methodName) {
		infoLog(objClass, methodName, "Entering method.");
	}

	/**
	 * 
	 * @param obj
	 * @param methodName
	 * @param returnValue
	 */
	public static void exitLog(Object objClass, String methodName,
			Object returnValue) {
		if (log.isInfoEnabled()) {
			infoLog(objClass, methodName, "Exiting method, returning  "
					+ returnValue);
		}
	}

	/**
	 * 
	 * @param obj
	 * @param methodName
	 */
	public static void exitLog(Object objClass, String methodName) {
		infoLog(objClass, methodName, "|| Exiting Method.");
	}

	/**
	 * 
	 * @param obj
	 * @param methodName
	 * @param message
	 */
	public static void errorLog(Object objClass, String methodName,
			String message) {
		errorLog(objClass.getClass(), methodName, message);
	}

	/**
	 * 
	 * @param obj
	 * @param string
	 * @param exception
	 */
	public static void errorLog(Object objClass, String string,
			Throwable exception) {
		errorLog(objClass.getClass(), string, exception);
	}

	/**
	 * 
	 * @param obj
	 * @param paramName
	 * @param paramValue
	 */
	public static void logParam(Object objClass, String paramName,
			Object paramValue) {
		logParam(objClass.getClass(), paramName, paramValue);
	}

	/**
	 * 
	 * @return
	 */
	public static boolean isLogging() {
		return log.isDebugEnabled();
	}

	/**
	 * 
	 * @return
	 */
	public static boolean isInfoEnabled() {
		return log.isInfoEnabled();
	}

}
