package com.ayl.homework.v3.session;

import com.ayl.homework.v3.cache.CacheKey;
import com.ayl.homework.v3.config.AConfiguration;
import com.ayl.homework.v3.executor.AExecutor;

/**
 * @author AYL    2018/4/1 22:27
 */
public class ASqlsession {
    private AConfiguration aConfiguration;
    private AExecutor aExecutor;
    private CacheKey cacheKey;

    public ASqlsession(AConfiguration aConfiguration, AExecutor aExecutor) {
        this.aConfiguration = aConfiguration;
        this.aExecutor = aExecutor;
        cacheKey = new CacheKey();
    }

    //接下来定义行为

    public  <T> T getMapper(Class<T> clazz){
        return aConfiguration.getMapper(clazz,this);
    }


    public <T> T selectOne(Class<T> clazz, String statement, Object parameter) throws Exception {
        return aExecutor.query(clazz, statement, parameter);
    }

}
