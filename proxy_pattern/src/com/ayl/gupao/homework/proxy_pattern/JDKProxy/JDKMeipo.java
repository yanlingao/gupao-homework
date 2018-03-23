package com.ayl.gupao.homework.proxy_pattern.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author AYL    3/21/2018 12:41 AM
 */
public class JDKMeipo implements InvocationHandler {
    private Person target;

    public Object getInstance(Person target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始物色");
        method.invoke(target,args);
        System.out.println("找到了，如果同意的话就准备结婚事宜。");
        return null;
    }
}
