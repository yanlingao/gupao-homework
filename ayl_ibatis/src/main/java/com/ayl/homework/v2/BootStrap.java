package com.ayl.homework.v2;

import com.ayl.homework.entity.Test;
import com.ayl.homework.v2.config.AConfiguration;
import com.ayl.homework.v2.executor.AExecutor;
import com.ayl.homework.v2.result.ResultSetHandler;
import com.ayl.homework.v2.executor.SimpleExecutor;
import com.ayl.homework.v2.session.ASqlsession;
import com.ayl.homework.v2.statement.StatementHandler;

/**
 * @author AYL    2018/4/3 0:44
 */
public class BootStrap {
    public static void main(String[] args) {
        AConfiguration configuration = new AConfiguration();

        AExecutor executor = new SimpleExecutor();

        System.out.println("hedddd");

        ASqlsession sqlsession = new ASqlsession(configuration, executor);

        TestMapper testMapper = sqlsession.getMapper(TestMapper.class);

        Test test = testMapper.selectByPrimaryKey(1);

        System.out.println("result:" + test);
    }

}
