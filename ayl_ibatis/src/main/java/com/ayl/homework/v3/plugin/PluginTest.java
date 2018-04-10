package com.ayl.homework.v3.plugin;

import com.ayl.homework.v3.annotation.Signature;
import com.ayl.homework.v3.executor.AExecutor;

import java.util.Properties;

/**
 * @author AYL    2018/4/10 21:56
 */
@Signature(type=AExecutor.class, method = "query", args = {Class.class, String.class, Object.class})
public class PluginTest implements Interceptor{

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        System.out.println("===========hihahihahihaaaaaaa,我是妖娆的plugin，来咬我呀==============");
        return Plugin.warp(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
