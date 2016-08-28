/**
 * 
 */
package com.common.util;

import java.net.InetAddress;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

/**
 * @author huanggaoren
 *
 */
public class GUIDGenerator {

	private static short counter = (short) 0;

	private static final int JVM = (int) (System.currentTimeMillis() >>> 8);

	private static final int IP;
	static {
		int ipadd;
		try {
			ipadd = toInt(InetAddress.getLocalHost().getAddress());
		} catch (Exception e) {
			ipadd = 0;
		}
		IP = ipadd;
	}
	/**
	 * 获取standard UUID
	 * <p>
	 * 例如 :96d8d04d-6317-4224-8a23-a800931ec99b
	 * </p>
	 * 
	 * @return
	 */
	public static String getUUID() {
		return getUUID(false);
	}

	/**
	 * 获取 sample UUID
	 * <p>
	 * 例如:2fbd1e341d7d4c99a0132a10dfa97570
	 * </p>
	 * 
	 * @return
	 */
	public static String getSimpleUUID() {
		return getUUID(true);
	}

	/**
	 * 获得指定数目的UUID
	 * 
	 * @param number
	 *            int 需要获得的UUID数量
	 * @return String[] UUID数组
	 * 
	 *         <p>
	 *         boolean值，如果为true，就去掉-，为false为正常
	 *         </p>
	 */
	public static String[] getUUID(int number, boolean bool) {
		if (number < 1) {
			return null;
		}
		String[] ss = new String[number];
		for (int i = 0; i < number; i++) {
			ss[i] = getUUID(bool);
		}
		return ss;
	}

	/**
	 * 获取UUID
	 * 
	 * @param bool
	 *            <p>
	 *            是否去掉横杠开关
	 *            </p>
	 *            <p>
	 *            boolean值，如果为true，就去掉-，为false为正常
	 *            </p>
	 * @return
	 */
	private static String getUUID(boolean bool) {
		String uuid = null;
		if (bool) {
			uuid = UUID.randomUUID().toString();
			uuid = StringUtils.remove(uuid, '-');
		} else {
			uuid = UUID.randomUUID().toString();
		}
		return uuid;
	}
	/**
	 * 产生一个32位的UUID
	 *
	 * @return
	 */

	public static String generate() {
		return new StringBuilder(32).append(format(getIP())).append(
				format(getJVM())).append(format(getHiTime())).append(
				format(getLoTime())).append(format(getCount())).toString();

	}

	private final static short getCount() {
		synchronized (GUIDGenerator.class) {
			if (counter < 0)
				counter = 0;
			return counter++;
		}
	}

	private final static int getJVM() {
		return JVM;
	}

	/**
	 * Unique in a local network
	 */
	private final static int getIP() {
		return IP;
	}

	private final static String format(int intval) {
		String formatted = Integer.toHexString(intval);
		StringBuilder buf = new StringBuilder("00000000");
		buf.replace(8 - formatted.length(), 8, formatted);
		return buf.toString();
	}

	private final static String format(short shortval) {
		String formatted = Integer.toHexString(shortval);
		StringBuilder buf = new StringBuilder("0000");
		buf.replace(4 - formatted.length(), 4, formatted);
		return buf.toString();
	}

	/**
	 * Unique down to millisecond
	 */
	private final static short getHiTime() {
		return (short) (System.currentTimeMillis() >>> 32);
	}

	private final static int getLoTime() {
		return (int) System.currentTimeMillis();
	}

	private final static int toInt(byte[] bytes) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result = (result << 8) - Byte.MIN_VALUE + (int) bytes[i];
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(getUUID());
		System.out.println(getSimpleUUID());
		String[] a = getUUID(3, true);
		for (String str : a) {
			System.out.println(str);
		}
	}
}
