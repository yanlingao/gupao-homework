package com.ayl.gupao.homework.proxy_pattern.custom;

import java.lang.reflect.Method;

/**
 * @author AYL    3/21/2018 12:11 AM
 */
public interface MyInvocationHandler {
    Object invoke(Object proxy, Method method,Object[] args) throws Throwable;
}
