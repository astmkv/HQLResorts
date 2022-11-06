package com.logic;

import com.ResTableEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBResortControlTest {

    @Test
    void createRes() {
        ResTableEntity res = new ResTableEntity();
        res.setName("testName");
        res.setCountry("testCountry");
        res.setSeason("testSeason");
        res.setPrice(1200L);
        DBResortControl bdRC = new DBResortControl();
        bdRC.createRes(res);
    }

    @Test
    void getStartsWith() {
        DBResortControl bdRC = new DBResortControl();
        bdRC.getStartsWith("n");
    }

    @Test
    void getResByPriceLimit() {
    }

    @Test
    void updateStartsWith() {
    }

    @Test
    void lowerPriceAbove1000() {
    }
}