package com.ayl.gupao.version_1;

import com.ayl.gupao.version_1.entity.Meal;
import com.ayl.gupao.version_1.entity.MoodEnum;
import com.ayl.gupao.version_1.preparemeal.CookMeal;
import com.ayl.gupao.version_1.preparemeal.PrepareMealFactory;
import com.ayl.gupao.version_1.preparemeal.RestrauntMeal;
import com.ayl.gupao.version_1.preparemeal.TakeOutMeal;
import lombok.*;


/**
 * @author AYL    2018/4/7 19:22
 */
@ToString
@RequiredArgsConstructor
public class Person {
    @NonNull
    @Getter @Setter private String name;
    @Getter @Setter private MoodEnum mood;

    PrepareMealFactory prepareMeal = null;
    Meal meal = null;
    public void eat(String...dishes){
        switch (this.mood){
            case GLAD:
                prepareMeal = new RestrauntMeal();
                break;
            case NORMAL:
                prepareMeal = new TakeOutMeal();
                break;
            case SAD:
                prepareMeal = new CookMeal();
        }

        meal = prepareMeal.prepareMeal(dishes);
        System.out.println("please start to enjoying your meal.");
    }
}
