package com.common.util;
 
import java.io.InputStream;
import java.text.DecimalFormat;  
import java.text.SimpleDateFormat;  
import java.util.ArrayList;  
import java.util.List;  

import org.apache.poi.hssf.usermodel.HSSFCell;  
import org.apache.poi.hssf.usermodel.HSSFDateUtil;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFCellUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
  
/** 
 * @author 马艳虎 2014-8-8 
 *  导出excel报表
 *    
 */  
public class ImportExcel {  
	
	
	/**
	 * 导出excel报表
	 * @param path 文件地址
	 * @return
	 * @throws Exception
	 */
    public static List<List<Object>> importExcel(String path,InputStream input) throws Exception {  
  
    	boolean isE2007 = false;
    	 if(path.endsWith("xlsx")) { 
             isE2007 = true;  
         }
        List<List<Object>> list = new ArrayList<List<Object>>();  
//        InputStream input = new FileInputStream(path);  //建立输入流  
//        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(path));  
        Workbook workbook  = null;  
        //根据文件格式(2003或者2007)来初始化  
        if(isE2007)  
        	workbook = new XSSFWorkbook(input);  
        else  
        	workbook = new HSSFWorkbook(input);  
        Sheet sheet = workbook.getSheetAt(0);  
        Object value = null;  
        Row row = null;  
        Cell cell = null;  
        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {  
            row = sheet.getRow(i);  
            if (row == null) {  
                continue;  
            }  
            List<Object> linked = new ArrayList<Object>();  
            for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {  
                cell = row.getCell(j);  
                if (cell == null) {  
                    continue;  
                }  
                DecimalFormat df = new DecimalFormat("0");  
                SimpleDateFormat sdf = new SimpleDateFormat(  
                        "yyyy-MM-dd HH:mm:ss");  
                DecimalFormat nf = new DecimalFormat("0.00");  
                switch (cell.getCellType()) {  
                case HSSFCell.CELL_TYPE_STRING:  
  
                    value = cell.getStringCellValue();  
                    break;  
                case HSSFCell.CELL_TYPE_NUMERIC:  
                	//如果是小数，则返回小数格式
                    if ("0.00_ ".equals(cell.getCellStyle().getDataFormatString())) {  
                        value = nf.format(cell.getNumericCellValue());  
                    } else if ("General".equals(cell.getCellStyle()  
                            .getDataFormatString())) {  
                    	//返回整数格式
                        value = df.format(cell.getNumericCellValue());  
                    } else if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    	//如果是日期,返回"yyyy-MM-dd HH:mm:ss"日期
                        value = sdf.format(HSSFDateUtil.getJavaDate(cell  
                                .getNumericCellValue()));  
                    } else if ("@".equals(cell.getCellStyle().getDataFormatString())) {  
                        value = df.format(cell.getNumericCellValue());  
                    } else {
                    	//返回数字本身
						value = cell.getNumericCellValue();
					}
                    break;  
                case HSSFCell.CELL_TYPE_BOOLEAN:  
                    value = cell.getBooleanCellValue();  
                    break;  
                case HSSFCell.CELL_TYPE_BLANK:  
                    value = "";  
                    break;  
                default:  
                    value = cell.toString();  
  
                }  
                if (value.equals("")) {  
                    value = "";  
                }  
                if (null == value) {  
                    continue;  
                }  
                linked.add(value);  
            }  
            list.add(linked);  
        }  
        return list;  
  
    }  
  
}  
