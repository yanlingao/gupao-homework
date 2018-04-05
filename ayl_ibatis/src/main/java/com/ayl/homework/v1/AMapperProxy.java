package com.ayl.homework.v1;

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
        if(method.getDeclaringClass().getName().equals(AConfiguration.TestMapperXml.nameSpace)) {
            String sql = AConfiguration.TestMapperXml.sqlStatementMap.get(method.getName());
            System.out.println(args.toString());

            //此行报错：java.lang.Integer cannot be cast to java.lang.String
//            System.out.println((String)args[0]);


            System.out.println(args[0].toString());
            System.out.println((Integer)args[0]);
            return aSqlsession.selectOne(sql,(Integer)args[0]);
        }
        return method.invoke(this,args);
    }


}
