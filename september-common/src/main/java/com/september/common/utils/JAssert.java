package com.september.common.utils;

import com.september.common.exception.H5Exception;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Objects;

public final class JAssert {

    /**
     * 如果不满足条件，抛异常
     *
     * @param expression 条件
     * @param msg        异常信息
     */
    public static void isTrue(boolean expression, String msg) {
        if (!expression) {
            justFailed(msg);
        }
    }

    /**
     * 如果是true(不是false)，抛异常
     *
     * @param expression true or false
     * @param msg        异常信息
     */
    public static void isFalse(boolean expression, String msg) {
        isTrue(!expression, msg);
    }

    /**
     * 直接抛异常
     *
     * @param msg 异常信息
     */
    public static void justFailed(String msg) {
        throw new H5Exception(msg);
    }

    public static void failed(String msg,Integer code) {
        throw new H5Exception(msg,code);
    }

    /**
     * 如果字符换是空，抛异常
     *
     * @param text 字符串内容
     * @param msg  异常信息
     */
    public static <T extends CharSequence> void notEmpty(T text, String msg) {
        if (StringUtils.isEmpty(text)) {
            justFailed(msg);
        }
    }

    /**
     * 如果集合是空，抛异常
     *
     * @param collection 集合
     * @param msg        异常信息
     */
    public static <E, T extends Collection<E>> void notEmpty(T collection, String msg) {
        if (CollectionUtils.isEmpty(collection)) {
            justFailed(msg);
        }
    }

    /**
     * 如果集合非空，抛异常
     *
     * @param collection 集合
     * @param msg        异常信息
     */
    public static <E, T extends Collection<E>> void isEmpty(T collection, String msg) {
        if (CollectionUtils.isNotEmpty(collection)) {
            justFailed(msg);
        }
    }

    /**
     * 如果对象是null，抛异常
     *
     * @param obj 对象
     * @param msg 异常信息
     */
    public static <T> void notNull(T obj, String msg) {
        if (Objects.isNull(obj)) {
            justFailed(msg);
        }
    }

    /**
     * 如果对象不是null，抛异常
     *
     * @param obj 对象
     * @param msg 异常信息
     */
    public static <T> void isNull(T obj, String msg) {
        if (Objects.nonNull(obj)) {
            justFailed(msg);
        }
    }

}
