/**
 * 
 */
package com.common.print;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.common.constants.Constants;
import com.common.exception.PrintException;
import com.common.xStream.XStreamUtil;

/**
 * @author huanggaoren
 *
 *         打印配置工具类
 */
public class PrintConfigHelper {

	private static Logger logger = LoggerFactory
			.getLogger(PrintConfigHelper.class);

	/**
	 * 打印设置
	 */
	private static PrintConfig cfg;

	public static PrintConfig getConfig() {
		if (cfg == null) {
			reloadCfg();
		}
		return cfg;
	}

	/**
	 * 把xml转变为PrintConfig对象
	 * 
	 * @return
	 */
	private static PrintConfig reloadCfg() {
		try {
			cfg = (PrintConfig) XStreamUtil
					.xmlToObject(Constants.print.DEFAULT_PROPERTY_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error("reloadCfg", e);
		}
		return cfg;
	}

	/**
	 * 保存配置文件
	 * 
	 * @param cfg
	 * @throws IOException
	 */
	public static void saveCfg(PrintConfig cfg) throws IOException {
		File folder = new File(Constants.print.PRINT_TEMPLATE_PATH);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		FileWriter writer = new FileWriter(new File(
				Constants.print.PRINT_TEMPLATE_PATH,
				Constants.print.DEFAULT_PROPERTY_FILE), false);
		XStreamUtil.objectToXml(cfg, writer);
	}

	/**
	 * 根据LabelId获取打印模板
	 * 
	 * @param labelId
	 * @return
	 */
	public static PrintTemplate getTemplate(String labelId) {
		if (StringUtils.isEmpty(labelId)) {
			throw new PrintException("labelId不能为空");
		}
		if (cfg == null) {
			reloadCfg();
		}
		PrintTemplate temp = null;
		for (PrintTemplate template : cfg.getTemplates()) {
			if (template.getLabelId().equalsIgnoreCase(labelId)) {
				temp = template;
				break;
			}
		}
		return temp;
	}
}
