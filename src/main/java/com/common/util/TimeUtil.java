/**
 * 
 */
package com.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhanghaiyang
 *
 */
public class TimeUtil {
	
	public static String formatter_type_ymd = "yyyy-MM-dd";
	
	public static String formatter_type_ymdhms = "yyyy-MM-dd hh:mm:ss";
	
	// Get current UTC time
	public static Date getCurrentDateTime() {

		Calendar calendar = Calendar.getInstance(java.util.TimeZone
				.getTimeZone("UTC"));
		// int offset = calendar.get(Calendar.ZONE_OFFSET) / 3600000
		// / + calendar.get(Calendar.DST_OFFSET) / 3600000;
		// calendar.add(Calendar.HOUR, -offset);
		return calendar.getTime();
	}
	
	/**
	 * 将Date类型数据转化为指定日期格式的String类型
	 * @param date
	 * @param formatType
	 * @return
	 */
	public static String transferDate2String(Date date,String formatType){
		String str = null;
		SimpleDateFormat sdf=new SimpleDateFormat(formatType);  
		str = sdf.format(date); 
		return str;
	}
	
	/**
	 * 将String类型的日期转化为指定格式的Date类型
	 * @param str
	 * @param formatType
	 * @return
	 */
	public static Date transferString2Date(String str,String formatType){
		Date date = null;
		SimpleDateFormat sdf1=new SimpleDateFormat(formatType);//小写的mm表示的是分钟  
		try {
			date = sdf1.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return date;
	}
}
