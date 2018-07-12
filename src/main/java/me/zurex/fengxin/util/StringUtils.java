package me.zurex.fengxin.util;

/**
 * @author zurex
 * @date 2018/6/10
 * Make life more fun
 */
public class StringUtils {
    public static boolean isEmpty(String value){
        return null == value || value.trim().isEmpty();
    }
}
