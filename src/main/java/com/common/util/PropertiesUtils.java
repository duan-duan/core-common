package com.common.util;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 
 * @author huanggaoren
 *
 */
public class PropertiesUtils {

	private static Properties props = null;

	public static Properties getDomainProps() throws IOException {
		if (props == null) {
			props = PropertiesLoaderUtils.loadAllProperties("application.properties");
		}
		return props;
	}

	/**
	 * 根据Key获取数据
	 * 
	 * @param prop
	 * @return
	 */
	public static String getPropValue(String prop) {
		String propValue = null;
		try {
			propValue = PropertiesUtils.getDomainProps().getProperty(prop);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propValue;
	}
}
