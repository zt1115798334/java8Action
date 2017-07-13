package com.devil.interfaceDefault;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by zhangtong on 2017/7/13.
 */
public class TypeInference {

    public static void main(String[] args) {
        Value<String> value = new Value<>();
        System.out.println(value.getValue("22",Value.defaultValue()));

        Optional<String> optional = Optional.ofNullable("");
        System.out.println(optional.isPresent());
    }
}
