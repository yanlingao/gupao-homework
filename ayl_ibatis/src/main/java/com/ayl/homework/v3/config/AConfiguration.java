package com.ayl.homework.v3.config;

import com.ayl.homework.v3.session.ASqlsession;
import com.ayl.homework.v3.mapper.AMapperProxy;

import java.lang.reflect.Proxy;

/**
 * @author AYL    2018/4/1 22:29
 */
public class AConfiguration {
    public <T> T getMapper(Class<T> clazz, ASqlsession sqlsession) {
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},new AMapperProxy(sqlsession));
    }
}
