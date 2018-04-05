package com.ayl.homework.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class Test {
    @Getter  @Setter private Integer id;

    @Getter @Setter private Integer nums;

    @Getter @Setter private String name;


}