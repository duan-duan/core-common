package com.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class OpenCsvUtils {

	InputStream getJavaCsvArrayToInputStream(String[] contents, String[][] data, char separator, String encoding, boolean isHead, StringBuffer fileContent)
			throws Exception {
		CharArrayWriter caw = new CharArrayWriter();
		CSVWriter cw = new CSVWriter(caw,separator);
		if (isHead) {
			cw.writeNext(contents);
		}
		for (int i = 0; i < data.length; i++) {
			cw.writeNext(data[i]);
		}
		cw.close();
		char[] char_buff = caw.toCharArray();
		String sb = new String(char_buff);
		fileContent.append(sb);
		byte[] buff = sb.toString().getBytes(encoding);

		InputStream is = new ByteArrayInputStream(buff);
		return is;

	}

	List getJavaCsvOutputStreamToArray(OutputStream os, char separator, String encoding, boolean isHead, StringBuffer fileContent) throws Exception {
		byte[] buff = ((ByteArrayOutputStream) os).toByteArray();
		String str = new String(buff, encoding);
		char[] char_buff = str.toCharArray();
		fileContent.append(str);
		CharArrayReader car = new CharArrayReader(char_buff);
		ArrayList<String[]> csvList = new ArrayList<String[]>();
		CSVReader csvReader = null;

		csvReader = new CSVReader(car, separator);//
		if (csvReader != null) {
			if (isHead) {
				csvReader.readNext();
			}
			String[] csvRow = null;// row
			while ((csvRow = csvReader.readNext()) != null) {
//				for (int i = 0; i < csvRow.length; i++) {
//					String temp = csvRow[i];
//					System.out.print(temp+";");
//				}
				csvList.add(csvRow);
			}
		}
		csvReader.close();
		return csvList;
	}

}
