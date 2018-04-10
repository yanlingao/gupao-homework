package com.ayl.homework.v3.plugin;

import com.ayl.homework.v3.annotation.Signature;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author AYL    2018/4/10 21:54
 */
public class Plugin implements InvocationHandler {
    private Object target;//被代理目标类
    private Interceptor interceptor;
    private Map<Class<?>, Method> signatureMap;

    public Plugin(Object target, Interceptor interceptor, Map<Class<?>, Method> signatureMap) {
        this.target = target;
        this.interceptor = interceptor;
        this.signatureMap = signatureMap;
    }

    //目标：得到代理类
    public static Object warp(Object target, Interceptor interceptor){
        Map<Class<?>, Method> signatureMap = getSignatureMap(target, interceptor);
        if (signatureMap.size() > 0){
            return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),
                    new Plugin(target, interceptor, signatureMap));
        }
        return target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }

    private static Map<Class<?>, Method> getSignatureMap(Object target, Interceptor interceptor){
        Map<Class<?>, Method> signatureMap = new HashMap<>();
        Signature signature = (Signature) interceptor.getClass().getAnnotation(Signature.class);
        if (signature.type() == target.getClass()){
            try {
                signatureMap.put(target.getClass(), target.getClass().getMethod(signature.method(),signature.args()));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return signatureMap;
    }
}
