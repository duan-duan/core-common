package com.common.util;

import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import net.sf.cglib.beans.BeanMap;

import org.apache.commons.lang.StringUtils;

public class BeanPropertyUtil {

	private static final String DOT = ".";
	
	/**
	 * Get field value by java.lang.reflection
	 * @param fieldName
	 * @param obj
	 * @return
	 */
	public static Object getProperty(String fieldName, Object obj) {
		
		Object returnObj = null;
		try {
//			Class detailClss = obj.getClass();
			BeanMap beanMap = BeanMap.create(obj);
			// check if there is need for inner class 
			if (StringUtils.indexOf(fieldName, DOT) != -1) {
				String[] temp = split(fieldName);
				Set set = beanMap.keySet();
				Iterator ite = set.iterator();
				while (ite.hasNext()) {
					String tempName = (String)ite.next();
					String propType = beanMap.getPropertyType(tempName).toString();
					if (StringUtils.indexOf(propType, temp[0]) != -1) {
						Object tempObj = beanMap.get(tempName);
						BeanMap tempBeanMap = BeanMap.create(tempObj);
						returnObj = tempBeanMap.get(temp[1]);
					}
				}
			} else {
								
				returnObj = beanMap.get(fieldName);
			}
			return returnObj;
		} catch (Exception e) {
			e.printStackTrace();
			return StringUtils.EMPTY;
		}
		
	}

	/**
	 * Set the value to object
	 * @param fieldName
	 * @param obj
	 * @param value
	 */
	public static void setProperty(String fieldName, 
			Object obj, Object value) {
		
		BeanMap beanMap = BeanMap.create(obj);
		beanMap.put(fieldName, value);
		
	}
	
	public static String[] split(String val) {
		
		StringTokenizer st = new StringTokenizer(val, DOT);
		int i= 0;
		String[] temp = new String[2];
		while (st.hasMoreElements()) {
			temp[i] = (String)st.nextElement();
			i++;
		}		
		
		return temp;
	}	

}
