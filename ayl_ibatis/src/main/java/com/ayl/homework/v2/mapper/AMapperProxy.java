package com.ayl.homework.v2.mapper;

import com.ayl.homework.v2.session.ASqlsession;
import com.ayl.homework.v2.annotation.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author AYL    2018/4/1 23:23
 */
public class AMapperProxy implements InvocationHandler {
    private ASqlsession aSqlsession;

    public AMapperProxy(ASqlsession aSqlsession) {
        this.aSqlsession = aSqlsession;
    }

    //最重要的是拿到sql语句
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class clazz = method.getDeclaringClass();

        if (!Object.class.equals(clazz)) {
            Select select = method.getAnnotation(Select.class);

            String sql = select.value();

            return aSqlsession.selectOne(method.getReturnType(), sql,(Integer)args[0]);
        }
        return method.invoke(this,args);
    }


}
