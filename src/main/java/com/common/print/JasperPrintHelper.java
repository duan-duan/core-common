/**
 * 
 */
package com.common.print;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.common.util.LogTracking;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author huanggaoren
 *
 */
public class JasperPrintHelper {

	private Map<String, Object> getParameter() {
		Map<String, Object> paras = new HashMap<String, Object>();
		return paras;
	}

	private Collection<?> getCollection() {
		return null;
	}

	public JasperPrint getJasperPrint(String jasperFilePath) {
		JasperPrint jrprint = null;
		try {
			jrprint = JasperFillManager.fillReport(jasperFilePath,
					getParameter(), new JRBeanCollectionDataSource(
							getCollection()));
		} catch (JRException e) {
			LogTracking.errorLog(this, "getJasperPrint", e);
		}
		return jrprint;
	}
}
