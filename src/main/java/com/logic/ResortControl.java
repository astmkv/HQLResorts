package com.logic;

import com.ResTableEntity;

import java.util.List;

public interface ResortControl {

    // создать
    void createRes(ResTableEntity res);

    // получить все курорты, название которых начинается с указанной строки
    List<ResTableEntity> getStartsWith(String s);

    // получить все курорты, цена которых выше указанной
    List<ResTableEntity> getResByPriceLimit(Long s);

    // обноваить все курорты, название которых начинается с указанной строки
    void updateStartsWith(String s);

    // понизить цену всех курортов на 500, если она выше 1000
    void lowerPriceAbove1000();


}
