package cn.org.chris.newlife.utils;

/**
 * 字符串操作类
 */
public class StringUtil extends org.springframework.util.StringUtils {
    /**
     * 判断字符是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return (str == null || "".equals(str));
    }

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return (str != null && !"".equals(str));
    }

    /**
     * 判断字符数组中是否存在空值
     *
     * @param strs
     * @return
     */
    public static boolean hasEmpty(String... strs) {
        if (strs == null || strs.length == 0) {
            return true;
        }
        for (String str : strs) {
            if (isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符串数组中的值是否全部为空
     *
     * @param strs
     * @return
     */
    public static boolean isAllEmpty(String... strs) {
        if (strs == null || strs.length == 0) {
            return true;
        }
        for (String str : strs) {
            if (!isEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 手机号中间4位替换成星号
     *
     * @param mobile
     * @return
     */
    public static String encodeMobile(String mobile) {
        if (StringUtil.isEmpty(mobile) || mobile.length() != 11) {
            return "";
        }
        return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

}
