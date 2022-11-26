package com.logic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        List<ResTableEntity> res = bdRC.getStartsWith("t");
        for (ResTableEntity item : res) {
            System.out.println(item.getName() + " " +
                    item.getCountry() + " " +
                    item.getSeason() + " " +
                    item.getPrice());
        }
    }

    @Test
    void getResByPriceLimit() {
        DBResortControl bdRC = new DBResortControl();
        List<ResTableEntity> res = bdRC.getResByPriceLimit(1000L);
        for (ResTableEntity item : res) {
            System.out.println(item.getName() + " " +
                    item.getCountry() + " " +
                    item.getSeason() + " " +
                    item.getPrice());
        }

    }

    @Test
    void lowerPriceAbove1000() {
    }

    @Test
    void updateResortByName() {
        DBResortControl bdRC = new DBResortControl();
        String targetName = "u";
        ResTableEntity res = new ResTableEntity("newCountry",
                "newTest",
                "newSeason",
                -1L);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        System.out.println(bdRC.updateResortByName(res,targetName));

    }
}