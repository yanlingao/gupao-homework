package com.ayl.homework.v3.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * @author AYL    2018/4/10 21:57
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Signature {
    Class<?> type();

    String method();

    Class<?>[] args();
}
