package com.logic;

import java.util.List;

public interface ResortControl {

    // создать
    void createRes(ResTableEntity res);

    // получить все курорты, название которых начинается с указанной строки
    List<ResTableEntity> getStartsWith(String s);

    // получить все курорты, цена которых ниже указанной
    List<ResTableEntity> getResByPriceLimit(Long s);

    // обновить все курорты, название которых начинается с указанной строки
    String updateResortByName(ResTableEntity res, String s);

    // понизить цену всех курортов на 500, если она выше 1000
    void lowerPriceAbove1000();


}
