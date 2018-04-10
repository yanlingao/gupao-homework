package com.ayl.homework.v3;

import com.ayl.homework.entity.Test;
import com.ayl.homework.v3.executor.AExecutor;
import com.ayl.homework.v3.plugin.Interceptor;
import com.ayl.homework.v3.plugin.PluginTest;
import com.ayl.homework.v3.session.ASqlsession;
import com.ayl.homework.v3.config.AConfiguration;
import com.ayl.homework.v3.executor.SimpleExecutor;

/**
 * @author AYL    2018/4/3 0:44
 */
public class BootStrap {
    public static void main(String[] args) {
        AConfiguration configuration = new AConfiguration();

        Interceptor interceptor = new PluginTest();

        AExecutor executor =  (AExecutor) interceptor.plugin(new SimpleExecutor());

        System.out.println("hedddd");

        ASqlsession sqlsession = new ASqlsession(configuration, executor);

        TestMapper testMapper = sqlsession.getMapper(TestMapper.class);

        Test test = testMapper.selectByPrimaryKey(1);

        System.out.println("result:" + test);
    }

}
