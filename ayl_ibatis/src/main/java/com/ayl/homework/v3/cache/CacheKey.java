package com.ayl.homework.v3.cache;

import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * @author AYL    2018/4/5 9:48
 */
@ToString
@NoArgsConstructor
public class CacheKey {
    private Map<String, Object> cache;

    public Object getCache(String sqlExecutor){
        return cache.get(sqlExecutor);
    }

    public void storeCache(String sqlExecutor,Object value){
        cache.put(sqlExecutor,value);
    }
}
