package com.ayl.gupao.plugin;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * @author AYL    2018/4/7 0:01
 */
@Intercepts({@Signature(type=Executor.class,method = "commit", args = {boolean.class})})
public class MyPlugin2 implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("-------------------------------intercept2--------------------------------");
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        System.out.println("-------------------------------plugin2--------------------------------------");
        return Plugin.wrap(o,this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println("--------------------------------setProperties2------------------------------");
    }
}
