package com.devil.interfaceDefault;

/**
 * Created by zhangtong on 2017/7/13.
 */
public class Value<T> {

    public static <T> T defaultValue() {
        return null;
    }

    public T getValue(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }

}
