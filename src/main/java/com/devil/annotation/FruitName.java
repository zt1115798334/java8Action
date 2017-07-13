package com.devil.annotation;

import java.lang.annotation.*;

/**
 * Created by zhangtong on 2017/7/13.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
