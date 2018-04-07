package com.ayl.gupao.version_1.preparemeal;

import com.ayl.gupao.version_1.entity.Dish;
import com.ayl.gupao.version_1.entity.FoodMaterial;
import com.ayl.gupao.version_1.entity.Meal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AYL    2018/4/7 16:53
 */
public class CookMeal implements PrepareMealFactory {
    public Meal prepareMeal(String... dishes) {
        return cook(buyFoodMaterial(dishes));
    }

    private Map<String,List<FoodMaterial>> buyFoodMaterial(String...dishes){
        System.out.println("go to supermarket.");
        Map<String,List<FoodMaterial>> foodMaterialMap = new HashMap<String, List<FoodMaterial>>();
        for(String item : dishes){
            System.out.println("start to select fresh materials of dish:" + item);
            List<FoodMaterial> materials = new ArrayList<FoodMaterial>();
            int mcount = (int) (Math.random() * 10);
            for(int i = 1; i < mcount; i++) {
                materials.add(new FoodMaterial(item + " materials " + i));
            }
            foodMaterialMap.put(item,materials);
        }
        System.out.println("bought all required food materials");
        System.out.println("go home.");
        return foodMaterialMap;
    }

    private Meal cook(Map<String,List<FoodMaterial>> foodMaterialMap){
        Meal meal = new Meal();
        List<Dish> dishes = new ArrayList<Dish>();
        for(Map.Entry<String,List<FoodMaterial>> entry : foodMaterialMap.entrySet()){
            System.out.println("start to cook the dish:" + entry.getKey());
            List<FoodMaterial> foodMaterials = entry.getValue();
            System.out.println("material list:");
            for(FoodMaterial item : foodMaterials){
                System.out.println(item);
            }
            Dish dish = new Dish(entry.getKey());
            dishes.add(dish);
        }
        meal.setDishes(dishes);
        System.out.println("a meal is ok now.");
        return meal;
    }
}
