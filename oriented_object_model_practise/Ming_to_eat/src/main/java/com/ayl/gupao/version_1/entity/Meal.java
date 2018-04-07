package com.ayl.gupao.version_1.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author AYL    2018/4/7 16:13
 */
@ToString
@NoArgsConstructor
public class Meal {
    @Getter @Setter
    private List<Dish> dishes;
}
