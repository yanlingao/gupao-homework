package com.ayl.homework.v2.executor;

import com.ayl.homework.v2.cache.CacheKey;

import java.beans.ExceptionListener;

/**
 * @author AYL    2018/4/5 9:44
 */
public class CacheExecutor implements AExecutor{

    //TODO
    @Override
    public <T> T query(Class<T> clazz, String statement, Object parameter) throws Exception {
       return null;

    }

    //TODO
    @Override
    public <T> T query(Class<T> clazz, String statement, Object parameter, CacheKey cacheKey) throws Exception {
        return null;
    }
}
