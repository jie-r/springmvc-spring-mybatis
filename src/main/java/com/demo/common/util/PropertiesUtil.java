package com.demo.common.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author lj
 * @Description 处理 properties 文件
 */
public class PropertiesUtil {
    private static ResourceBundle resource = ResourceBundle.getBundle("resource", Locale.SIMPLIFIED_CHINESE);

    /**
     * @param key
     * @return
     * @throws Exception
     * @Description: 获取Properties文件里面的值
     */
    public static String getValue(String key) throws Exception {
        String result = null;
        try {
            result = new String(resource.getString(key).getBytes("ISO-8859-1"), "GBK");
        } catch (Exception e) {
            System.out.println("获取不到的 key：" + key);
        }
        return result;
    }
}
