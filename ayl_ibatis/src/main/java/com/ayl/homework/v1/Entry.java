package com.ayl.homework.v1;

import com.ayl.homework.entity.Test;

/**
 * @author AYL    2018/4/3 0:44
 */
public class Entry {
    public static void main(String[] args) {
        AConfiguration configuration = new AConfiguration();
        AExecutor executor = new SimpleExecutor();
        ASqlsession sqlsession = new ASqlsession(configuration, executor);
        TestMapper testMapper = sqlsession.getMapper(TestMapper.class);
        Test test = testMapper.selectByPrimaryKey(1);
        System.out.println("result:" + test);
    }

}
