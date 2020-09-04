package pers.wellhor.text.utils;

/**
 * 通用工具类 减少jar包依赖
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/9/4 3:48 下午
 **/
public final class CommonsUtils {

    private CommonsUtils() {}

    public static boolean isEmpty(String chars) {
        if(chars == null && chars.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotEmpty(String chars) {
        return !isEmpty(chars);
    }

}
