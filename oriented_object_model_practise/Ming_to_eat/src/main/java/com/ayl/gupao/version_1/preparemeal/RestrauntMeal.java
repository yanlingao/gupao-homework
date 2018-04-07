package com.ayl.gupao.version_1.preparemeal;

import com.ayl.gupao.version_1.entity.Dish;
import com.ayl.gupao.version_1.entity.Meal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AYL    2018/4/7 17:33
 */
public class RestrauntMeal implements PrepareMealFactory{

    public Meal prepareMeal(String... dishes) {
        gototheRestraunt();
        return order(dishes);
    }

    private void gototheRestraunt(){
        System.out.println("go to the restraunt by taxi");
        System.out.println("arrivaled the restraunt.");
    }

    private Meal order(String...dishes){
        System.out.println("start to order.");
        List<Dish> dishList = new ArrayList<Dish>();
        for(String item : dishes){
            Dish dish = new Dish(item);
            dishList.add(dish);
            System.out.println( "      " + dish);
        }
        Meal meal = new Meal();
        meal.setDishes(dishList);
        return meal;
    }
}
