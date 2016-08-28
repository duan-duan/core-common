/**
 * 
 */
package com.common.web.springmvc;

import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.google.common.collect.Maps;

/**
 * @author huanggaoren
 * 
 */
public class ReadPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	private static Map<String, Object> propertiesMap;

	public ReadPropertyPlaceholderConfigurer() {
		super();
	}

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess,Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		propertiesMap = Maps.newHashMap();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			propertiesMap.put(keyStr, value);
		}

	}

	public static Object getContextProperty(String name) {
		Object obj = propertiesMap.get(name);
		if (obj == null) {
			return name;
		}
		return obj;
	}
}
