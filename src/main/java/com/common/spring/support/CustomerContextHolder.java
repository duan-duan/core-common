/**
 * 
 */
package com.common.spring.support;

/**
 * 根据不同的报表选择不同的数据源
 * 
 * 可以用于业务逻辑中，根据不同的报表，设置不同的数据源
 * 
 * 
 * @author huanggaoren
 * 
 */
public class CustomerContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	/**
	 * 设置数据源
	 * 
	 * @param customerType
	 */
	public static void setCustomerType(String customerType) {
		contextHolder.set(customerType);
	}

	/**
	 * 获取数据源
	 * 
	 * @return
	 */
	public static String getCustomerType() {
		return contextHolder.get();
	}

	/**
	 * 清除数据源
	 */
	public static void clearCustomerType() {
		contextHolder.remove();
	}
}
