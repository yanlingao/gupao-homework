package com.ayl.homework.v1;

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

    static class TestMapperXml{
        public static String nameSpace = "com.ayl.homework.v1.TestMapper";
        public static Map<String,String> sqlStatementMap = new HashMap<>();
        static {//静态代码块。在jvm加载类的时候自动执行。并且仅执行一次。
            sqlStatementMap.put("selectByPrimaryKey", "select * from test where id = %d");
        }
    }
}
