package com.ayl.homework.v2.result;

import com.ayl.homework.entity.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author AYL    2018/4/4 21:55
 */
public class ResultSetHandler {
    public <T> T resultSetParseToEntity(Class<T> clazz, ResultSet rs) throws Exception {
        T t = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        while (rs.next()) {
            for (int i=0; i < fields.length; i++){
                Field f = fields[i];
                Method method = clazz.getMethod("set"+ f.getName().substring(0,1).toUpperCase()
                        + f.getName().substring(1),f.getType());


                if (f.getType() == Integer.class) {
                    int t1 = rs.getInt(f.getName());
                    method.invoke(t, t1);
                } else if (f.getType() == String.class) {
                    method.invoke(t, rs.getString(f.getName()));
                }
            }
        }
        return t;
    }


}