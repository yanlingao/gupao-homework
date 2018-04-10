package com.ayl.homework.v3.executor;

import com.ayl.homework.v3.cache.CacheKey;

/**
 * @author AYL    2018/4/1 22:29
 */
public interface AExecutor {
    <T> T query(Class<T> clazz, String statement, Object parameter) throws Exception;
    <T> T query(Class<T> clazz, String statement, Object parameter, CacheKey cacheKey) throws Exception;
}
