package com.ayl.homework.v1;

import com.ayl.homework.v1.AConfiguration;
import com.ayl.homework.v1.AExecutor;

/**
 * @author AYL    2018/4/1 22:27
 */
public class ASqlsession {
    private AConfiguration aConfiguration;
    private AExecutor aExecutor;

    public ASqlsession(AConfiguration aConfiguration, AExecutor aExecutor) {
        this.aConfiguration = aConfiguration;
        this.aExecutor = aExecutor;
    }

    //接下来定义行为

    public  <T> T getMapper(Class<T> clazz){
        return aConfiguration.getMapper(clazz,this);
    }


    public <T> T selectOne(String statement,Object parameter){
        return aExecutor.query(statement,parameter);
    }

}
