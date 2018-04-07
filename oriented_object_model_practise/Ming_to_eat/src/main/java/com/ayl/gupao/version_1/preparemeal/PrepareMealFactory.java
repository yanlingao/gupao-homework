package com.ayl.gupao.version_1.preparemeal;

import com.ayl.gupao.version_1.entity.Meal;

/**
 * @author AYL    2018/4/7 16:12
 */
public interface PrepareMealFactory {
    Meal prepareMeal(String...dishes);
}
