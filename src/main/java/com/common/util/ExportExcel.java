package com.common.util;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.common.exception.BaseException;

/**
 * 利用开源组件POI3.0.2动态导出EXCEL文档 
 * 
 * @author mayanhu
 * @param <T>
 *            应用泛型，代表任意一个符合javabean风格的类
 *            注意这里为了简单起见，boolean型的属性xxx的get器方式为getXxx(),而不是isXxx()
 *            byte[]表jpg格式的图片数据
 */
public class ExportExcel<T> extends AbstractExcelView
{
	private String sheetName = "报表"; //工作薄名称
	private String fileName;          //文件名
	private String[] headers;         //表格属性列名数组
	private String[] fields;          //表格属性列名数组
	private Collection<T> dataset;    //需要显示的数据集合
	private String pattern;           //如果有时间数据，设定输出格式。默认为"yyy-MM-dd HH:mm:ss"
	public ExportExcel(String fileName, String[] headers,String[] fields,
			Collection<T> dataset, String pattern) {
		this.fileName = fileName;
		this.headers = headers;
		this.fields = fields;
		this.dataset = dataset;
		this.pattern = pattern;
	}

	/**
	 * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
	 * 
	 * @param fileName
	 *            文件名
	 * @param headers
	 *            表格属性列名数组
	 * @param dataset
	 *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
	 *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
	 * @param path
	 *            导出地址，可以将EXCEL文档导出到本地文件或者网络中
	 * @param pattern
	 *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd HH:mm:ss"
	 */
	@SuppressWarnings("unchecked")
	public void exportExcel(HttpServletResponse response)
	{
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(sheetName);
		// 设置表格默认列宽度为20个字节
		sheet.setDefaultColumnWidth((short) 20);
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置列名样式
		style.setFillForegroundColor(HSSFColor.WHITE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.ALIGN_CENTER);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.BLACK.index);
		font.setFontHeightInPoints((short) 10);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置内容样式
		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(HSSFColor.WHITE.index);
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		style2.setFont(font2);

		// 声明一个画图的顶级管理器
		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 定义注释的大小和位置,详见文档
//		HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
//				0, 0, 0, (short) 4, 2, (short) 6, 5));
		// 设置注释内容
//		comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));

		// 产生表格标题行
		int index = 0;
		HSSFRow row = sheet.createRow(index);
		if(null != headers && headers.length>0){
			for (short i = 0; i < headers.length; i++)
			{
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style);
				HSSFRichTextString text = new HSSFRichTextString(headers[i]);
				cell.setCellValue(text);
			}
			index++;
		}

		// 遍历集合数据，产生数据行
		Iterator<T> it = dataset.iterator();
		
		while (it.hasNext())
		{
			
			row = sheet.createRow(index);
			T t = (T) it.next();
			// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
//			Field[] fields = t.getClass().getDeclaredFields();
			
			
			for (short i = 0; i < fields.length; i++)
			{
				HSSFCell cell = row.createCell(i);
				cell.setCellStyle(style2);
//				Field field = fields[i];
//				String fieldName = field.getName();
				String fieldName = fields[i];
				String getMethodName = "get"
						+ fieldName.substring(0, 1).toUpperCase()
						+ fieldName.substring(1);
				try
				{
					Class tCls = t.getClass();
					Method getMethod = tCls.getMethod(getMethodName,
							new Class[]
							{});
					Object value = getMethod.invoke(t, new Object[]
					{});
					// 判断值的类型后进行强制类型转换
					String textValue = null;
					// if (value instanceof Integer) {
					// int intValue = (Integer) value;
					// cell.setCellValue(intValue);
					// } else if (value instanceof Float) {
					// float fValue = (Float) value;
					// textValue = new HSSFRichTextString(
					// String.valueOf(fValue));
					// cell.setCellValue(textValue);
					// } else if (value instanceof Double) {
					// double dValue = (Double) value;
					// textValue = new HSSFRichTextString(
					// String.valueOf(dValue));
					// cell.setCellValue(textValue);
					// } else if (value instanceof Long) {
					// long longValue = (Long) value;
					// cell.setCellValue(longValue);
					// }
//					if (value instanceof Boolean)
//					{
//						boolean bValue = (Boolean) value;
//						textValue = "男";
//						if (!bValue)
//						{
//							textValue = "女";
//						}
//					}
					if(null != value){
						if (value instanceof Date)
						{
							Date date = (Date) value;
							SimpleDateFormat sdf = new SimpleDateFormat(pattern);
							textValue = sdf.format(date);
						}
						else if (value instanceof byte[])
						{
							// 有图片时，设置行高为60px;
							row.setHeightInPoints(60);
							// 设置图片所在列宽度为80px,注意这里单位的一个换算
							sheet.setColumnWidth(i, (short) (35.7 * 80));
							// sheet.autoSizeColumn(i);
							byte[] bsValue = (byte[]) value;
							HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
									1023, 255, (short) 6, index, (short) 6, index);
							anchor.setAnchorType(2);
							patriarch.createPicture(anchor, workbook.addPicture(
									bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
						}
						else
						{
							// 其它数据类型都当作字符串简单处理
							textValue = value.toString();
						}
					}
					// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
					if (textValue != null)
					{
						Pattern p = Pattern.compile("^//d+(//.//d+)?$");
						Matcher matcher = p.matcher(textValue);
						if (matcher.matches())
						{
							// 是数字当作double处理
							cell.setCellValue(Double.parseDouble(textValue));
						}
						else
						{
							HSSFRichTextString richString = new HSSFRichTextString(
									textValue);
							HSSFFont font3 = workbook.createFont();
							font3.setColor(HSSFColor.BLUE.index);
							richString.applyFont(font3);
							cell.setCellValue(richString);
						}
					}
				}
				catch (SecurityException e)
				{
					e.printStackTrace();
				}
				catch (NoSuchMethodException e)
				{
					e.printStackTrace();
				}
				catch (IllegalArgumentException e)
				{
					e.printStackTrace();
				}
				catch (IllegalAccessException e)
				{
					e.printStackTrace();
				}
				catch (InvocationTargetException e)
				{
					e.printStackTrace();
				}
				finally
				{
					// 清理资源
				}
			}
			index++;
		}

	     OutputStream out = null;//创建一个输出流对象
		
		try
		{
            out = response.getOutputStream();//
            if(null ==fileName || fileName.isEmpty()){
            	Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
				String nameDate = sdf.format(date);
            	fileName = "111"+nameDate+".xls";//设置下载时客户端Excel的名称
            }

			fileName=new String(fileName.getBytes("gb2312"),"ISO_8859_1");

    		response.setContentType("application/vnd.ms-excel;charset=gb2312"); 
    		response.setHeader("Content-disposition", "attachment;filename=" + fileName); 
            response.setHeader("Pragma","No-cache");//设置头
            response.setHeader("Cache-Control","no-cache");//设置头
            response.setDateHeader("Expires", 0);//设置日期头

			workbook.write(out);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			throw new BaseException("导出Excel失败");
		}finally{
//			try {
//				out.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
	}

	@Override
	protected void buildExcelDocument(Map<String, Object> arg0,
			HSSFWorkbook arg1, HttpServletRequest arg2, HttpServletResponse response)
			throws Exception {
		exportExcel(response);
	}
}
