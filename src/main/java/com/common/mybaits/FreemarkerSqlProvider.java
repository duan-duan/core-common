/**
 * 
 */
package com.common.mybaits;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import com.common.constants.Constants;
import com.common.exception.MissMandatoryArgException;
import com.common.util.PropertiesUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author huanggaoren
 *
 */
public class FreemarkerSqlProvider {

	public FreemarkerSqlProvider() {
	}

	static Configuration cfg = new Configuration();

	static {
		try {
			cfg.setDirectoryForTemplateLoading(new File(PropertiesUtils.getPropValue("report_template_path")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: generatorsCore
	 * @Description: TODO 创建JAVA模板的核心算法
	 * @param @param template 模板
	 * @param @param className 类名
	 * @param @param catalog 目录
	 * @param @param entityType 类的后最
	 * @param @param type 接口或者类 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	@SuppressWarnings("unchecked")
	public String getSql(Map<String, Object> para) {
		Map<String, Object> params = (Map<String, Object>) para.get("params");
		StringWriter writer = new StringWriter();
		try {
			if (!params.containsKey(Constants.Report.REPORT_ID)) {
				throw new MissMandatoryArgException(
						"Parameters must contian with key REPORT_ID");
			}
			String reportId = (String) params.get(Constants.Report.REPORT_ID);
			Template t = cfg.getTemplate(reportId + Constants.Report.SUFFIX);// 指定模板
			t.process(params, writer);
		} catch (TemplateException | IOException e) {
			e.printStackTrace();
		}
		return writer.toString();
	}
}
