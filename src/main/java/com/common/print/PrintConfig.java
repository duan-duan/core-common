/**
 * 
 */
package com.common.print;

import java.util.List;

import com.common.entity.BaseSerializable;

/**
 * @author huanggaoren
 *
 */
public class PrintConfig implements BaseSerializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4124399563117561414L;

	/**
	 * 模板列表
	 */
	private List<PrintTemplate> templates;

	public List<PrintTemplate> getTemplates() {
		return templates;
	}

	public void setTemplates(List<PrintTemplate> templates) {
		this.templates = templates;
	}
}
