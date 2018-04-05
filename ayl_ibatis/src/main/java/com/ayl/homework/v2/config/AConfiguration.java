package com.ayl.homework.v2.config;

import com.ayl.homework.v2.mapper.AMapperProxy;
import com.ayl.homework.v2.session.ASqlsession;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author AYL    2018/4/1 22:29
 */
public class AConfiguration {
    public <T> T getMapper(Class<T> clazz, ASqlsession sqlsession) {
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new AMapperProxy(sqlsession));
    }
}
