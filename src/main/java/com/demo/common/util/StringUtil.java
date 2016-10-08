package com.demo.common.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:字符串工具类
 * @ClassName :com.cdutcm.common.util.StringUtil.java
 * @Author :lijie
 */
public class StringUtil {
	public static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**
	 * @Description: 字符串转换为整形
	 * @MethodName : parseInt
	 * @Author :lijie
	 * @param str
	 * @param def
	 * @return
	 */
	public static Integer parseInt(String str, Integer def) {
		try {
			return Integer.parseInt(str);
		} catch(NumberFormatException ex) {
			return def;
		}
	}
	/**
	 * @Description:字符串转换为Double
	 * @MethodName :parseInt
	 * @Author :lijie
	 * @param str
	 * @param def
	 * @return
	 */
	public static Double parseDouble(String str, Double def) {
		try {
			return Double.parseDouble(str);
		} catch(NumberFormatException ex) {
			return def;
		}
	}
	/**
	 * @Description:字符串转换为Long
	 * @MethodName :parseLong
	 * @Author :lijie
	 * @param str
	 * @param def
	 * @return
	 */
	public static Long parseLong(String str, Long def) {
		try {
			return Long.parseLong(str);
		} catch(NumberFormatException ex) {
			return def;
		}
	}
	/**
	 * @Description:判断字符串是否为Null或空
	 * @MethodName :isEmpty
	 * @Author :lijie
	 * @param str
	 * @return 如果为空或 null 返回 true，否则返回 false
	 */
	public static Boolean isEmpty(String str) {
		if(str == null) {
			return true;
		}
		str = str.trim();
		return "".equals(str);
	}
	/**
	 * @Description:判断字符串是否为Null或空
	 * @MethodName :isEmpty
	 * @Author :lijie
	 * @param str
	 * @return 如果为空或 null 返回 true，否则返回 false
	 */
	public static Boolean isNotEmpty(String str) {
		if(str != null) {
			str = str.trim();
			if(!"".equals(str)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 判断当前对象是否为 null
	 * @param str 需要进行判断的对象
	 * @return 如果为 null 返回 true，否则返回 false
	 */
	public static Boolean objIsEmpty(Object str) {
		return str == null;
	}
	/**
	 * 检查字符串是否为空
	 * @param str
	 * @return
	 */
	public static boolean hasText(String str) {
		return str != null && !"".equals(str);
	}
	/**
	 * 判断是否不是空集合
	 * @param list
	 * @return
	 */
	public static boolean isNotEmptyList(List<?> list) {
		return list != null && list.size() > 0;
	}
	/**
	 * @param str
	 * @return 返回模糊查询的双%
	 */
	public static String addSymbol(String str) {
		return "%" + str + "%";
	}
	/**
	 * 判断是否是空集合
	 * @param list
	 * @return
	 */
	public static boolean isEmptyList(List<?> list) {
		return list == null || list.size() <= 0;
	}
	/**
	 * 分割字符串
	 * @param str 需要分割的字符
	 * @param delimiter 按指定符号分割
	 * @return 字符串数组
	 */
	public static String[] split(String str, String delimiter) {
		int delimiterLength;
		int stringLength = str.length();
		if(delimiter == null || (delimiterLength = delimiter.length()) == 0) {
			return new String[]{str};
		}
		int count = 0, start = 0, end;
		while((end = str.indexOf(delimiter, start)) != -1) {
			count++;
			start = end + delimiterLength;
		}
		count++;
		String[] result = new String[count];
		count = 0;
		start = 0;
		while((end = str.indexOf(delimiter, start)) != -1) {
			result[count] = (str.substring(start, end));
			count++;
			start = end + delimiterLength;
		}
		end = stringLength;
		result[count] = str.substring(start, end);
		return (result);
	}
	/**
	 * 判断首字母是否是汉字
	 * @param str 需要进行判断的字符串
	 * @return true/false
	 */
	public static boolean isChineseChar(String str) {
		boolean flag = false;
		if(str != null) {
			char temp = str.charAt(0);
			flag = temp >= 0x0391 && temp <= 0xFFE5;
		}
		return flag;
	}
	/**
	 * 判断字符串中指定位置是否是汉字
	 * @param str 需要进行判断的字符串
	 * @return true/false
	 */
	public static boolean isChineseChar(String str, int index) {
		boolean flag = false;
		if(str != null) {
			if(index < str.length()) {
				char temp = str.charAt(index);
				flag = temp >= 0x0391 && temp <= 0xFFE5;
			}
		}
		return flag;
	}
	/**
	 * 判断首字母是否是英文
	 * @param str 需要进行判断的字符串
	 * @return true/false
	 */
	public static boolean isEnglishChar(String str) {
		boolean flag = false;
		if(str != null) {
			char temp = str.charAt(0);
			flag = temp >= 0x0000 && temp <= 0x00FF;
		}
		return flag;
	}
	/**
	 * 判断字符串中指定位置是否是英文
	 * @param str 需要进行判断的字符串
	 * @return true/false
	 */
	public static boolean isEnglishChar(String str, int index) {
		boolean flag = false;
		if(str != null) {
			if(index < str.length()) {
				char temp = str.charAt(index);
				flag = temp >= 0x0000 && temp <= 0x00FF;
			}
		}
		return flag;
	}
	/**
	 * @param str
	 * @return Description：将字符串转化为UTF8
	 */
	public static String encode2UTF8(String str) {
		if(isEmpty(str)) {
			return null;
		}
		try {
			return new String(str.getBytes("iso-8859-1"), "utf-8");
		} catch(UnsupportedEncodingException e) {
			return str;
		}
	}
	/**
	 * @param utfString
	 * @return Description：将Unicode编码转换为汉字
	 */
	public static String convert(String str) {
		if(isEmpty(str)) {
			return null;
		}
		Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
		Matcher matcher = pattern.matcher(str);
		char ch;
		while(matcher.find()) {
			ch = (char)Integer.parseInt(matcher.group(2), 16);
			str = str.replace(matcher.group(1), ch + "");
		}
		str = str.replaceAll("\"", "");
		return str;
	}
	/**
	 * @param date
	 * @return
	 * @Description:获取 2014-10-14 14:44:33日期格式的字符串
	 */
	public static String getyyyy_MM_dd_hh_mm_ss(Date date) {
		if(date == null) {
			return null;
		}
		return sdf1.format(date);
	}
	/**
	 * 汉字转拼音缩写
	 * @param str 要转换的汉字字符串
	 * @return String 拼音缩写
	 */
	public static String getPYString(String str) {
		String tempStr = "";
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c >= 33 && c <= 126) {
				// 字母和符号原样保留
				tempStr += String.valueOf(c);
			} else {
				// 累加拼音声母
				tempStr += getPYChar(String.valueOf(c));
			}
		}
		return tempStr;
	}
	/**
	 * 取单个字符的拼音声母
	 * @param c 要转换的单个汉字
	 * @return String 拼音声母
	 */
	public static String getPYChar(String c) {
		byte[] array = new byte[2];
		array = String.valueOf(c).getBytes();
		int i = (short)(array[0] - '\0' + 256) * 256 + ((short)(array[1] - '\0' + 256));
		if(i < 0xB0A1)
			return "*";
		if(i < 0xB0C5)
			return "A";
		if(i < 0xB2C1)
			return "B";
		if(i < 0xB4EE)
			return "C";
		if(i < 0xB6EA)
			return "D";
		if(i < 0xB7A2)
			return "E";
		if(i < 0xB8C1)
			return "F";
		if(i < 0xB9FE)
			return "G";
		if(i < 0xBBF7)
			return "H";
		if(i < 0xBFA6)
			return "J";
		if(i < 0xC0AC)
			return "K";
		if(i < 0xC2E8)
			return "L";
		if(i < 0xC4C3)
			return "M";
		if(i < 0xC5B6)
			return "N";
		if(i < 0xC5BE)
			return "O";
		if(i < 0xC6DA)
			return "P";
		if(i < 0xC8BB)
			return "Q";
		if(i < 0xC8F6)
			return "R";
		if(i < 0xCBFA)
			return "S";
		if(i < 0xCDDA)
			return "T";
		if(i < 0xCEF4)
			return "W";
		if(i < 0xD1B9)
			return "X";
		if(i < 0xD4D1)
			return "Y";
		if(i < 0xD7FA)
			return "Z";
		return "*";
	}
	
	// 过滤特殊字符  
    public static String StringFilter(String str) {
    	// 清除掉所有特殊字符  
    	String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
    	Pattern p = Pattern.compile(regEx);
    	Matcher m = p.matcher(str);
    	return m.replaceAll("").trim();
    }
}
