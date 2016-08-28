package com.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 日志
 * @author yanjia
 *
 */
public class TracingLog {
	
	private static final Logger cat = LoggerFactory.getLogger(TracingLog.class);

	/**
	 * 
	 * @param obj
	 * @param methodName
	 * @param message
	 */
	public static void debugLog(Class objClass, String methodName,
			String message) {
		if (cat.isDebugEnabled()) {
			String s = objClass.getName();
			cat.debug(s + "." + methodName + "||" + message);
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
		if (cat.isInfoEnabled()) {
			String s = objClass.getName();
			cat.info(s + "." + methodName + "|| " + message);
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
		cat.error(s + "." + methodName + "|| " + message);
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
		cat.error(string, exception);
	}

	/**
	 * 
	 * @param obj
	 * @param paramName
	 * @param paramValue
	 */
	public static void logParam(Class objClass, String paramName,
			Object paramValue) {
		if (cat.isDebugEnabled()) {
			String s = objClass.getName();
			cat.debug(s + "Received parameter, ||" + paramName + " = "
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
		if (cat.isInfoEnabled()) {
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
		return cat.isDebugEnabled();
	}
	
	/**
	 * 
	 * @return
	 */
	public static boolean isInfoEnabled() {
		return cat.isInfoEnabled();
	}
	

}
