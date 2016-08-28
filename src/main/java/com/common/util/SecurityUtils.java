package com.common.util;

import org.apache.commons.lang.StringUtils;

public class SecurityUtils {

	public static String getEncryptString(String accountName, String password) {
		if (StringUtils.isBlank(accountName)) {
			accountName = StringUtils.EMPTY;
		}

		if (StringUtils.isBlank(password)) {
			password = StringUtils.EMPTY;
		}

		String origin = accountName.toUpperCase() + password;
		String sPassword = MD5Helper.getMD5Encode(origin);
		return sPassword;
	}

}
