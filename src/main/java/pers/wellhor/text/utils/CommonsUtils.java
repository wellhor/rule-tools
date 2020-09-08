package pers.wellhor.text.utils;

import java.util.Collection;

/**
 * 通用工具类 减少jar包依赖
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2020/9/4 3:48 下午
 **/
public final class CommonsUtils {

    private CommonsUtils() {
    }

    public static boolean isEmpty(String chars) {
        return chars == null || chars.length() == 0;
    }

    public static boolean isNotEmpty(String chars) {
        return !isEmpty(chars);
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }


    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNotEmpty(Object[] array) {
        return !isEmpty(array);
    }

}
