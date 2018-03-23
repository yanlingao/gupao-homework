package com.ayl.gupao.homework.proxy_pattern.custom.customProxy;

/**
 * @author AYL    3/21/2018 12:39 AM
 */
public class zhangsan implements Person {
    @Override
    public void findJob() {
        System.out.println("salary should be 20k-50k");
    }

    @Override
    public void findLover(int age) {
        System.out.println("she should be beautiful. and age shoule be less than:" + age);
    }
}
