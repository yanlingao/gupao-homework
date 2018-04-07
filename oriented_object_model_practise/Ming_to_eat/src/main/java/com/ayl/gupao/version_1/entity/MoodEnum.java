package com.ayl.gupao.version_1.entity;

/**
 * @author AYL    2018/4/7 19:33
 */
public enum MoodEnum {
    GLAD(1),
    NORMAL(2),
    SAD(3);

    private int code;

    MoodEnum(int code) {
        this.code = code;
    }
}
