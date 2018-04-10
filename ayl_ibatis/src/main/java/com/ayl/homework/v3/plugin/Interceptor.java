package com.ayl.homework.v3.plugin;

import java.util.Properties;

/**
 * @author AYL    2018/4/10 22:10
 */
public interface Interceptor {

    Object intercept(Invocation invocation) throws Throwable;

    Object plugin(Object target);

    void setProperties(Properties properties);

}