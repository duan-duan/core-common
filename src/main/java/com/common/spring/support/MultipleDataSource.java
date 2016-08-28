/**
 * 
 */
package com.common.spring.support;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.common.util.PropertiesUtils;

/**
 * @author huanggaoren
 *
 * @date 2014/11/28
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

	/**
	 * 获取属性文件中的数据源
	 * 
	 * 
	 */
	public final static String DATA_SOURCE = PropertiesUtils
			.getPropValue("query_report_source");

	/**
	 * 一种是从属性文件中获取数据源 另一种是从自定义资源中获取数据源
	 */
	@Override
	protected Object determineCurrentLookupKey() {

		// 自定义获取数据源
		if (StringUtils.isNotEmpty(CustomerContextHolder.getCustomerType())) {
			return CustomerContextHolder.getCustomerType();
		} else {
			// 从属性文件中获取数据源
			return DATA_SOURCE;
		}

	}

}
