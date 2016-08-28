package com.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.thoughtworks.xstream.converters.extended.ISO8601DateConverter;

public class DateConverter extends ISO8601DateConverter {

	public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	private String timezone = "+08:00";

	public DateConverter() {

	}

	public DateConverter(String timezone) {
		this.timezone = timezone;
	}

	public Object fromString(String str) {
		if (str != null && !str.equals(StringUtils.EMPTY)) {
			return super.fromString(str);
		} else {
			return null;
		}
	}

	public String toString(Object obj) {
		String formatDate = sdf.format((Date) obj);
		formatDate = formatDate + timezone;
		return formatDate;
	}
}
