/**   
 * @Title: JsonUtil.java 
 * @Package com.common.util 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author aijava itorac@sina.com.cn
 * @date Sep 15, 2013 10:49:51 PM 
 * @version V1.0   
 */
package com.common.util;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

/**
 * @ClassName: JsonUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ajava itorac@sina.com.cn
 * @date Sep 15, 2013 10:49:51 PM
 * 
 */
public class JsonUtil {

	public JsonUtil() {

	}

	/**
	 * @Title: toJavaObject
	 * @Description: TODO从json字符串中解析出java对象
	 * @param
	 * @param jsonStr
	 *            json格式
	 * @param
	 * @param clazz
	 *            类
	 * @param
	 * @return 设定文件
	 * @return Object 返回类型
	 * @throws
	 */
	public static Object toJavaObject(String json, Class<?> clazz) {

		return JSON.toJavaObject(JSON.parseObject(json), clazz);
	}
	

	/**
	 * TODO从json字符串中解析出List对象
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static List<?> jsonToList(String json, Class<?> clazz) {
		return JSON.parseArray(json, clazz);
	}

	/**
	 * 
	 * @Title: javaObjectToJson
	 * @Description: TODO 对象转化为JSON
	 * @param
	 * @param object
	 *            转化对象
	 * @param
	 * @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String objectToJSON(Object object) {
		return JSON.toJSON(object).toString();
	}

	/**
	 * 
	 * @Title: objectToJSON
	 * @Description: TODO 对象转化为JSON
	 * @param
	 * @param object
	 *            转化对象
	 * @param
	 * @param mapping
	 *            过滤掉的字段
	 * @param
	 * @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String objectToJSON(Object object, ParserConfig mapping) {
		return JSON.toJSON(object, mapping).toString();
	}
}
