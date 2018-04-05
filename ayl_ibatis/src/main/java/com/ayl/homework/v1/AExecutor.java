package com.ayl.homework.v1;

/**
 * @author AYL    2018/4/1 22:29
 */
public interface AExecutor {
    public <T> T query(String statement, Object parameter);
}
