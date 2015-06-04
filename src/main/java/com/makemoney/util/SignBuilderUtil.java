package com.makemoney.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

/**
 * 签名工具类
 * 
 * @author wuxincheng
 * @date 2015年6月4日 下午2:10:51
 * @version V1.0
 */
public class SignBuilderUtil {

	/** 升序comparator */
	private static final Comparator<String> ASC_ORDER = new AscendingComparator();

	/** 降序comparator */
	private static final Comparator<String> DSC_ORDER = new DscendingComparator();

	/**
	 * <pre>
	 * 对map按指定序列(ASC or DSC)排序并拼接为字符串，例如：key1=value1&key2=value2
	 * </pre>
	 * 
	 * @param map
	 *            待签名、验签的键值对
	 * @param connector
	 *            键值连接符，若传null则使用缺省值“=”
	 * @param seperator
	 *            键值对分割符，若传null则使用缺省值“&”
	 * @param isAscending
	 *            是否为升序
	 * @return
	 */
	public static String sortingMapToStr(Map<String, String> map, String connector,
			String seperator, boolean isAscending) {
		if (connector == null) {
			connector = "=";
		}
		if (seperator == null) {
			seperator = "&";
		}

		Map<String, String> sortedMap = sortingMap(map, isAscending);
		Set<Entry<String, String>> orderedEntry = sortedMap.entrySet();
		StringBuffer sbf = new StringBuffer();
		for (Entry<String, String> entry : orderedEntry) {
			sbf.append(entry.getKey());
			sbf.append(connector);
			sbf.append(StringUtils.trimToEmpty(entry.getValue()));
			sbf.append(seperator);
		}
		sbf.deleteCharAt(sbf.length() - 1);
		return sbf.toString();
	}

	/**
	 * <pre>
	 * 生成签名字符串
	 * </pre>
	 * 
	 * @param signPrepareValues
	 *            待签名的字符串数组
	 * @return
	 */
	public static String getSignature(String[] signPrepareValues) {
		if (signPrepareValues == null || signPrepareValues.length < 1) {
			return null;
		}

		// 将字符串signatureValues数组参数进行字典排序
		Arrays.sort(signPrepareValues);
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < signPrepareValues.length; i++) {
			content.append(signPrepareValues[i]);
		}

		MessageDigest md = null;
		String signature = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
			// 将三个参数字符串拼接成一个字符串进行sha1加密
			byte[] digest = md.digest(content.toString().getBytes());
			signature = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		// 清空content
		content = null;

		return signature;
	}

	/**
	 * <pre>
	 * 验证签名
	 * </pre>
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	@Deprecated
	public static boolean checkSignature(String signature, String timestamp, String nonce,
			String token) {
		String[] arr = new String[] { token, timestamp, nonce };
		// 将token、timestamp、nonce三个参数进行字典排序
		Arrays.sort(arr);
		StringBuilder content = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			content.append(arr[i]);
		}
		MessageDigest md = null;
		String tmpStr = null;

		try {
			md = MessageDigest.getInstance("SHA-1");
			// 将三个参数字符串拼接成一个字符串进行sha1加密
			byte[] digest = md.digest(content.toString().getBytes());
			tmpStr = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		content = null;
		// 将sha1加密后的字符串可与signature对比
		return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
	}

	/**
	 * <pre>
	 * 将字节数组转换为十六进制字符串
	 * </pre>
	 * 
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}

	/**
	 * <pre>
	 * 将字节转换为十六进制字符串
	 * </pre>
	 * 
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
				'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];

		String s = new String(tempArr);
		return s;
	}

	/**
	 * <pre>
	 * 按key值对map进行排序，排序方式由isAscending决定为升序或降序
	 * </pre>
	 * 
	 * @param map
	 *            待排序map
	 * @param isAscending
	 *            是否为升序
	 * @return 已排序map
	 */
	public static Map<String, String> sortingMap(Map<String, String> map, boolean isAscending) {
		TreeMap<String, String> result = null;
		
		if (isAscending) {
			// 升序排列
			result = new TreeMap<String, String>(ASC_ORDER);
		} else {
			// 降序排列
			result = new TreeMap<String, String>(DSC_ORDER);
		}
		result.putAll(map);
		
		return result;
	}

	/**
	 * <pre>
	 * 升序比较器
	 * </pre>
	 */
	private static class AscendingComparator implements Comparator<String> {
		public int compare(String o1, String o2) {
			return String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
		}
	}

	/**
	 * <pre>
	 * 降序比较器
	 * </pre>
	 */
	private static class DscendingComparator implements Comparator<String> {
		public int compare(String o1, String o2) {
			if (String.CASE_INSENSITIVE_ORDER.compare(o1, o2) > 0) {
				return -1;
			}
			if (String.CASE_INSENSITIVE_ORDER.compare(o1, o2) < 0) {
				return 1;
			}
			return 0;
		}
	}

}
