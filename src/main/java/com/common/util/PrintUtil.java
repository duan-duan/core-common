/**   
 * @Title: PrintUtil.java 
 * @Package com.gome.common.util 
 * @Description: TODO 
 * @author lianzhiqiang
 * @date 2015年1月13日 上午10:48:45 
 * @version V1.0   
 */
package com.common.util;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/** 
 * @ClassName: PrintUtil 
 * @Description: 打印工具类
 * @author lianzhiqiang
 * @date 2015年1月13日 上午10:48:45 
 *  
 */
public class PrintUtil {
	
	/**
	 * @Title: print 
	 * @Description: 打印PDF到页面，调用的时候需要window.open打开新的页面
	 * @param reportName 报表名称，需要对应报表模板的名称
	 * @param parameters 报表模板对应的参数，对应模板上$P{}
	 * @param dataSource 报表模板对应的列表，对应模板上$F{}
	 * @param request	
	 * @param response
	 * @throws JRException
	 * @throws IOException
	 * @return void
	 */
	public static void print(String reportName, Map<String, Object> parameters, Collection dataSource, HttpServletRequest request, HttpServletResponse response) throws JRException, IOException{
		
		File jasperFile=null;
		byte[] bytes = null;
		
		String path = request.getSession().getServletContext()
				.getRealPath("/") + "/resource/labeltemplate/gome/" + reportName + ".jasper";
		
		jasperFile = new File(path);
        bytes = JasperRunManager.runReportToPdf(jasperFile.getPath(), parameters,
        		new JRBeanCollectionDataSource(dataSource));
        if (bytes != null && bytes.length > 0) {
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream ouputStream = response.getOutputStream();
            ouputStream.write(bytes, 0, bytes.length);
            ouputStream.flush();
            ouputStream.close();
        }
	}
}
