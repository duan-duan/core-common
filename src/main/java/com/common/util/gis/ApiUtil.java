package com.common.util.gis;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.common.util.PropertiesUtils;

/**
 * 地图API工具类
 *
 */
public class ApiUtil {
	public final static String DEFAULT_CHARSET = "utf-8";
	public static final String appUrl = PropertiesUtils.getPropValue("GIS_APP_URL");;
	public static final String appKey = PropertiesUtils.getPropValue("GIS_APP_KEY");;
	public static final String appSecret = PropertiesUtils.getPropValue("GIS_APP_SECRET");
	public static final int timeout   = Integer.valueOf(PropertiesUtils.getPropValue("GIS_TIME_OUT"));
	
	public static final String GIS_ERR_CALL = "01";		//调用失败
	public static final String GIS_ERR_SNO = "02";		//解析失败，未返回相应的订单号
	public static final String GIS_ERR_DNO = "03";		//解析失败，未返回相应的四级区域
	public static final String GIS_ERR_ADR = "04";		//解析失败，找不到匹配的地址
	public static final String GIS_ERR_SND = "05";      //错误的四级地址代码
	public static final String GIS_ERR_CLD = "06";      //地图解析功能关闭
	/*
	 * 组装请求参数，返回值为key1=value1&key2=value2形式
	 */
	public static String createRequestParam(Map<String, Object> map) {
		StringBuilder param = new StringBuilder();

		for (Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, Object> e = it.next();
			Object value = e.getValue();
			if (value != null) {
				try {
					value = URLEncoder.encode(value.toString(), DEFAULT_CHARSET);
				} catch (UnsupportedEncodingException ex) {
				}
				param.append("&").append(e.getKey()).append("=").append(value);
			}
		}
		return param.toString().substring(1);
	}
	
	/*
	 * 组装请求参数，返回值为key1=value1&key2=value2形式
	public static String createRequestParam(Object obj) throws Exception {
		Map<String, Object> map = BeanUtils.describe(obj);
		return createRequestParam(map);
	}
	 */
	
	/*
	 * 二行制转字符串
	 */
	public static String byte2hex(byte[] b) {

		StringBuffer hs = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs.append("0").append(stmp);
			else
				hs.append(stmp);
		}
		return hs.toString().toUpperCase();
	}

	/*
	 * 签名方法，用于生成签名。
	 * 
	 * @param params 传给服务器的参数
	 * 
	 * @param secret 分配给您的APP_SECRET
	 */
	public static String sign(Map params, String secret) {
		String result = null;
		if (params == null)
			return result;

		// 将参数按key排序
		Set<String> keys = params.keySet();
		String[] ps = new String[keys.size()];
		int i = 0;
		for (String key : keys) {
			Object value = params.get(key);
			if (value != null) {
				ps[i++] = key + value.toString();
			}
		}
		if (i == 0)
			return result;
		String[] ss = new String[i];
		System.arraycopy(ps, 0, ss, 0, i);	
		Arrays.sort(ss);
		
		// 将secret同时放在头尾，拼成字符串
		StringBuilder orgin = new StringBuilder(secret);
		for (int j = 0; j < ss.length; j++) {
			orgin.append(ss[j]);
		}
		orgin.append(secret);
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			result = byte2hex(md.digest(orgin.toString().getBytes("utf-8")));
		} catch (Exception ex) {
			throw new java.lang.RuntimeException("sign error !");
		}
		return result;
	}

	/*
	 * 得到返回的内容
	 */
	public static String getResult(String urlStr, String content) {
		URL url = null;
		HttpURLConnection connection = null;

		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setConnectTimeout(timeout);
			connection.connect();

			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			out.writeBytes(content);
			out.flush();
			out.close();

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection
					.getInputStream(), "utf-8"));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			return buffer.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return null;
	}
	
	/* 
	 * 使用jackson进行json解析
	 */
	private static ObjectMapper mapper = new ObjectMapper();
	public static ApiResult getResult(String method, Map<String, Object> map) throws JsonParseException, JsonMappingException, IOException {
		String str = getResult(appUrl, method, appKey, appSecret, "json", map);
		return mapper.readValue(str, ApiResult.class);
	}
	
	/**
	 * 得到完整的请求参数组装
	 */
	public static String createFullParam(String method, String appKey, String appSecret, String format, Map<String, Object> map) {
		map.put("app_key", appKey);
		map.put("method", method);
		map.put("format", format);
		
		// 时间戳
		map.put("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		// 生成签名
		map.remove("sign");
		String sign = ApiUtil.sign(map, appSecret);
		// 组装协议参数sign
		map.put("sign", sign);
		
		return ApiUtil.createRequestParam(map);
	}
	
	/*
	 * 得到返回的内容，自动创建sign和timestamp
	 */
	public static String getResult(String urlStr, String method, String appKey, String appSecret, String format, Map<String, Object> map) {
		String result = ApiUtil.createFullParam(method, appKey, appSecret, format, map);
		return ApiUtil.getResult(urlStr, result);
	}
	
	public static String getUri(String method, Map<String, Object> map) {
		return getUri(appUrl, method, appKey, appSecret, "json", map);
	}
	
	public static String getUri(String urlStr, String method, String appKey, String appSecret, String format, Map<String, Object> map) {
		String result = ApiUtil.createFullParam(method, appKey, appSecret, format, map);
		return urlStr + "?" + result;
	}
	
	public static Map map(final Object... datas) {
		// 参数必须为偶数个
		if (datas.length == 0 || datas.length % 2 != 0)
			return null;
		
		final Map map = new HashMap();
		for (int i = 0; i < datas.length; i += 2) {
			map.put(datas[i], datas[i+1]);
		}
		return map;
	}
}
