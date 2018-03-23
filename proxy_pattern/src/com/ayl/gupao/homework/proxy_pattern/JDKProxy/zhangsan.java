package com.ayl.gupao.homework.proxy_pattern.JDKProxy;

/**
 * @author AYL    3/21/2018 12:39 AM
 */
public class zhangsan implements Person {
    @Override
    public void findJob() {
        System.out.println("salary should be 20k-50k");
    }

    @Override
    public void findLover() {
        System.out.println("she should be beautiful.");
    }
}
