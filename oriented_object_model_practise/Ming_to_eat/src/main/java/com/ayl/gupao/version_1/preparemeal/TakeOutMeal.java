package com.ayl.gupao.version_1.preparemeal;

import com.ayl.gupao.version_1.entity.Dish;
import com.ayl.gupao.version_1.entity.Meal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AYL    2018/4/7 16:14
 */
public class TakeOutMeal implements PrepareMealFactory {
    public Meal prepareMeal(String...dishNames) {
        return order(dishNames);
    }

    private  Meal order(String...dishNames){
        if(dishNames.length < 1){
            System.out.println("you have no add any dish!");
            return null;
        }
        System.out.println("your order is below:");
        List<Dish> dishList = new ArrayList<Dish>();
        for(String item : dishNames){
            System.out.println(item);
            dishList.add(new Dish(item));
        }
        System.out.println("please wait 10mins,we are preparing your meal.");

        Meal meal = new Meal();
        meal.setDishes(dishList);
        System.out.println("your meal is ok now.");
        return meal;
    }
}
