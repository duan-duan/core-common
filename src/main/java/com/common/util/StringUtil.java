/**
 * 
 */
package com.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.common.constants.Constants;
import com.common.exception.BusinessException;

/**
 * @author huanggaoren
 * 
 */
public class StringUtil {

	// 递送状态
	public static Set<String> incetpStateSet = new HashSet<String>();

	public static Set<String> rejectIncetpStateSet = new HashSet<String>();

	/**
	 * 字符截取
	 * 
	 * @param str
	 *            字符串
	 * @param i
	 *            返回 截取的位置
	 * @return
	 */
	public static String spilt(String str, int i) {
		if (StringUtils.isNotEmpty(str)) {
			String[] strs = str.split("/");
			if (i >= 0 && i <= strs.length - 1) {
				if (strs != null && strs.length > 0) {
					return strs[i];
				}
			} else {
				return "";
			}
		}
		return str;
	}

	/**
	 * 字符截取
	 * 
	 * @param str
	 *            字符串
	 * 
	 * @param regex
	 *            截取的符合
	 * @param i
	 *            返回 截取的位置
	 * @return
	 */
	public static String spilt(String str, String regex, int i) {
		if (StringUtils.isNotEmpty(str)) {
			String[] strs = str.split(regex);
			if (i >= 0 && i <= strs.length - 1) {
				if (strs != null && strs.length > 0) {
					return strs[i];
				}
			} else {
				return "";
			}
		}
		return str;
	}

	/**
	 * 组合字符串
	 * 
	 * @param str
	 * @return
	 */
	public static String combString(String str) {
		StringBuffer sbuffer = new StringBuffer();
		char c;
		if (StringUtils.isNotEmpty(str)) {
			byte[] b = str.getBytes();
			for (int i = 0; i < b.length; i++) {
				c = (char) b[i];
				if (c != '$' && c != '{' && c != '}') {
					sbuffer.append(c);
				}
			}
			return sbuffer.toString();
		} else {
			return "";
		}
	}

	/**
	 * 处理url
	 * 
	 * url为null返回null，url为空串或以http://或https://开头，则加上http://，其他情况返回原参数。
	 * 
	 * @param url
	 * @return
	 */
	public static String handelUrl(String url) {
		if (url == null) {
			return null;
		}
		url = url.trim();
		if (url.equals("") || url.startsWith("http://")
				|| url.startsWith("https://")) {
			return url;
		} else {
			return "http://" + url.trim();
		}
	}

	/**
	 * 得到文件名称
	 *
	 * @return 文件名称
	 */
	public static String getFileName(String type) {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String mDateTime = formatter.format(c.getTime());
		String datatime = mDateTime.substring(0, 15);// 20071029_093002
		String filename = Constants.OPERATIONTYPE.getNameByCode(type) + "_"
				+ datatime + "_" + GUIDGenerator.generate()
				+ Constants.File.suffix_csv;
		return filename;
	}

	/**
	 * 分割并且去除空格
	 * 
	 * @param str
	 *            待分割字符串
	 * @param sep
	 *            分割符
	 * @param sep2
	 *            第二个分隔符
	 * @return 如果str为空，则返回null。
	 */
	public static String[] splitAndTrim(String str, String sep, String sep2) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		if (!StringUtils.isBlank(sep2)) {
			str = StringUtils.replace(str, sep2, sep);
		}
		String[] arr = StringUtils.split(str, sep);
		// trim
		for (int i = 0, len = arr.length; i < len; i++) {
			arr[i] = arr[i].trim();
		}
		return arr;
	}

	/**
	 * 文本转html
	 * 
	 * @param txt
	 * @return
	 */
	public static String txt2htm(String txt) {
		if (StringUtils.isBlank(txt)) {
			return txt;
		}
		StringBuilder sb = new StringBuilder((int) (txt.length() * 1.2));
		char c;
		boolean doub = false;
		for (int i = 0; i < txt.length(); i++) {
			c = txt.charAt(i);
			if (c == ' ') {
				if (doub) {
					sb.append(' ');
					doub = false;
				} else {
					sb.append("&nbsp;");
					doub = true;
				}
			} else {
				doub = false;
				switch (c) {
				case '&':
					sb.append("&amp;");
					break;
				case '<':
					sb.append("&lt;");
					break;
				case '>':
					sb.append("&gt;");
					break;
				case '"':
					sb.append("&quot;");
					break;
				case '\n':
					sb.append("<br/>");
					break;
				default:
					sb.append(c);
					break;
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 剪切文本。如果进行了剪切，则在文本后加上"..."
	 * 
	 * @param s
	 *            剪切对象。
	 * @param len
	 *            编码小于256的作为一个字符，大于256的作为两个字符。
	 * @return
	 */
	public static String textCut(String s, int len, String append) {
		if (s == null) {
			return null;
		}
		int slen = s.length();
		if (slen <= len) {
			return s;
		}
		// 最大计数（如果全是英文）
		int maxCount = len * 2;
		int count = 0;
		int i = 0;
		for (; count < maxCount && i < slen; i++) {
			if (s.codePointAt(i) < 256) {
				count++;
			} else {
				count += 2;
			}
		}
		if (i < slen) {
			if (count > maxCount) {
				i--;
			}
			if (!StringUtils.isBlank(append)) {
				if (s.codePointAt(i - 1) < 256) {
					i -= 2;
				} else {
					i--;
				}
				return s.substring(0, i) + append;
			} else {
				return s.substring(0, i);
			}
		} else {
			return s;
		}
	}

	/**
	 * 检查字符串中是否包含被搜索的字符串。被搜索的字符串可以使用通配符'*'。
	 * 
	 * @param str
	 * @param search
	 * @return
	 */
	public static boolean contains(String str, String search) {
		if (StringUtils.isBlank(str) || StringUtils.isBlank(search)) {
			return false;
		}
		String reg = StringUtils.replace(search, "*", ".*");
		Pattern p = Pattern.compile(reg);
		return p.matcher(str).matches();
	}

	/**
	 * URL 解码
	 * 
	 * @param str
	 * @return
	 */
	public static String decodeStr(String str) {
		return decodeStr(str, "UTF-8");
	}

	/**
	 * URL解码,自定义规则
	 * 
	 * @param str
	 * @return
	 */
	public static String decodeStr(String str, String encode) {
		if (StringUtils.isNotEmpty(str)) {
			try {
				return URLDecoder.decode(str, encode);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * URL编码
	 * 
	 * @param str
	 * @return
	 */
	public static String encodeStr(String str) {
		return encodeStr(str, "UTF-8");
	}

	/**
	 * URL编码，自定义规则
	 * 
	 * @param str
	 * @param encode
	 * @return
	 */
	public static String encodeStr(String str, String encode) {
		if (StringUtils.isNotEmpty(str)) {
			try {
				return URLEncoder.encode(str, encode);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 编码
	 * 
	 * @param str
	 * @return
	 */
	public static String getBytesToStr(String str) {
		if (StringUtils.isNotEmpty(str)) {
			try {
				return new String((str).getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 给文件更名
	 *
	 * @param oldFileName
	 * @param filename
	 * @return 更改后的文件名称
	 */
	public static String updateFileName(String oldFileName, String filename,
			String file_suffix) throws Exception {
		if (file_suffix == null || file_suffix.equals("")) {
			file_suffix = Constants.File.suffix_csv;
		}
		int ch = oldFileName.toLowerCase().lastIndexOf(
				file_suffix.toLowerCase());
		String newName = null;
		try {
			newName = oldFileName.substring(0, ch) + filename + file_suffix;
		} catch (Exception e) {
			throw new Exception("substringError-" + e.getCause()
					+ e.getMessage());
		}
		return newName;
	}

	public static String getFileSuffix(String fileName) {
		if (fileName == null || fileName.length() < 2) {
			return "";
		} else {
			int idx = fileName.lastIndexOf(".");
			String suffix = fileName.substring(idx, fileName.length());
			return suffix;
		}
	}

	public static boolean getIncetpState(String state) {
		return incetpStateSet.contains(state); // 包含时 false 不包含true

	}

	public static boolean getrejectIncetpState(String state) {
		return rejectIncetpStateSet.contains(state);
	}

//	public static void main(String[] args) {
//		String str = "mng/user";
//		System.out.println(combString(spilt(str, 0)));
//	}

	public static String nullToEmpty(String src) {
		if (src == null) {
			return StringUtils.EMPTY;
		} else {
			return src;
		}
	}

	/**
	 * 
	 * @author xuzhuo
	 * @date 2014年7月31日
	 * @description list集合拼接成字符串逗号连接
	 */
	public static String listToString(List orgs) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < orgs.size(); i++) {
			buffer.append(orgs.get(i));
			if (i != orgs.size() - 1) {
				buffer.append(",");
			}
		}
		return buffer.toString();
	}

	/**
	 * 
	 * @author xuzhuo
	 * @date 2014年8月1日
	 * @description 判断string是否是纯数字组成
	 */
	public static Boolean judgeStringIsNum(String str) {
		if (str != null && "".equals(str)) {
			Pattern pattern = Pattern.compile("[0-9]*");
			return pattern.matcher(str).matches();
		} else {
			return false;
		}

	}
	
	public static String formatStr(String value) {
		if (value == null) {
			return "";
		}
		return value;
	}
	
	/**
	 * 将整数转化成固定位数的字符串，不够的在前面添加0
	 * @param currentNum
	 * @param toStringBytes
	 * @return
	 */
	public static String intToString(long currentNum,int toStringBytes){
	   String result = "";
	   String currentStr = currentNum + "";
	   if(currentStr.length()<toStringBytes){
		   result = String.format("%0"+toStringBytes+"d", currentNum);
	   }else if(currentStr.length()==toStringBytes){
		   result = currentStr;
	   }
	   return result;
	}
	/**
	 * 逗号切割字符串
	 * @param str
	 * @return
	 */
	public static List<String> splitString(String str){
		List<String> strList = new ArrayList<String>();
		if(StringUtils.isNotEmpty(str)){
			String[] strs = str.split(",");
			strList = Arrays.asList(strs);
		} else {
			strList.add(str);
		}
		return strList;
	}
	/**
	 * 判断list中是否包含某字符串
	 * @param strList
	 * @param str
	 * @return
	 */
	public static Boolean judgeListHasStr(List<String> strList, String str){
		Boolean ret = Boolean.FALSE;
		if(strList != null && StringUtils.isNotEmpty(str)){
			int index = strList.indexOf(str);
			if(index != -1){
				ret = Boolean.TRUE;
			}
		}
		return ret;
	}
	
	/**
	 * 生成min到 Max之间的随机数
	 * @param max
	 * @param min
	 * @return
	 */
	public static int getRandomInScope(int max,int min){
		Random random = new Random();
        return (random.nextInt(max)%(max-min+1) + min);
	}
	
	/**
	 * 生成ASN号/DispatchId号等10位随机数字，不够的位补零
	 * @return
	 */
	public static String generateRandom_10(){
		String asnNum = "0000"+StringUtil.getRandomInScope(1000000, 0);
		return asnNum;
	}
	
	/**
	 * 将字符串按照指定分隔符转换成List
	 * @param str           原字符串
	 * @param separatorChar 分割符
	 * @return list
	 */
	public static List<String> splitStrToList(String str , String separatorChar) {
		if (StringUtils.isEmpty(str)) {
			throw new BusinessException("source is null.");
		}
		if (StringUtils.isEmpty(separatorChar)) {
			throw new BusinessException("separator char is null.");
		}
		List<String> result = new ArrayList<String>();
		if (StringUtils.indexOf(str, separatorChar) >= 0) {
			String[] temp = StringUtils.split(str, separatorChar);
			result = Arrays.asList(temp);
		} else {
			result.add(str);
		}
		return result;
	}
	
	/**
	 * 生成uuid
	 * @return
	 */
	public static String genUUID(){
		String uuid = UUID.randomUUID().toString();
		uuid = StringUtils.remove(uuid, '-');
		return uuid;
	}
	
}
