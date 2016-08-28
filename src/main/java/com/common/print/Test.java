package com.common.print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * @author huanggaoren
 *
 */
public class Test {

	public static void main(String[] args) {
		try {

			JasperReport jasperReport = null;

			JasperPrint jasperPrint = null;

			jasperReport = (JasperReport) JRLoader
					.loadObject("D:/report/test.jasper");

			jasperPrint = JasperFillManager.fillReport(jasperReport, getMap(),
					getDataSource());

			JasperExportManager.exportReportToHtmlFile(jasperPrint,
					"D:/report/test.html");
			JasperExportManager.exportReportToPdfFile(jasperPrint,
					"D:/report/test.pdf");
			JasperExportManager.exportReportToXmlFile(jasperPrint,
					"D:/report/test.xml", false);
		} catch (JRException e) {
			e.printStackTrace();
		}
	}

	private static Map<String, Object> getMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "用户测试报表");
		return map;
	}

	private static JRDataSource getDataSource() {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < 100; i++) {
			list.add(new Student("xiaojun", "小军" + i, true, "test@s.com"));
		}
		JRDataSource datesource = new JRBeanCollectionDataSource(list);
		return datesource;
	}
}
