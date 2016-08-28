package com.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class CsvUtils {
	static OpenCsvUtils csvUtil=new OpenCsvUtils();
	public static InputStream getArrayToInputStream(String[] contents, String[][] data, char separator, String encoding, boolean isHead,StringBuffer fileContent) throws Exception {

		return csvUtil.getJavaCsvArrayToInputStream(contents, data, separator, encoding, isHead,fileContent);

	}

	public static List getOutPutStreamToList(OutputStream os, char separator, String encoding, boolean isHead,StringBuffer fileContent) throws Exception {
		return csvUtil.getJavaCsvOutputStreamToArray(os, separator, encoding, isHead,fileContent);

	}
}
