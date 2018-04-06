package com.ayl.gupao.dao;


public interface TestMapper {
    Test2 selectByPrimaryKey(int id);

    int insert(Test2 record);

    int insertSelective(Test2 record);

}