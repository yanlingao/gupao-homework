package com.ayl.gupao.version_1;

import com.ayl.gupao.version_1.entity.MoodEnum;

/**
 * @author AYL    2018/4/7 19:55
 */
public class Entry {
    public static void main(String[] args) {
        Person ming = new Person("ming");
//        ming.setMood(MoodEnum.GLAD);
//        ming.eat("鱼子酱沙拉","烟三文鱼鹅肝酱","凯萨沙拉","法式洋葱汤");

//        ming.setMood(MoodEnum.NORMAL);
//        ming.eat("黄焖鸡米饭");

        ming.setMood(MoodEnum.SAD);
        ming.eat("剁椒鱼头","清炒时蔬","玉米排骨汤");

    }
}
