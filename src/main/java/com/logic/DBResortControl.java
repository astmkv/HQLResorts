package com.logic;

import com.ResTableEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class DBResortControl implements ResortControl {


    @Override
    public void createRes(ResTableEntity res) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();


        // INSERT INTO res_table() VALUES('name','france','summer',500);
        try {
            transaction.begin();
//            entityManager.createQuery("INSERT INTO res_table (name,country,season,price)" +
//                    "VALUES(res.getName(), res.getCountry(), res.getSeason(), res.getPrice())", ResTableEntity.class);
            entityManager.persist(res);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Override
    public List<ResTableEntity> getStartsWith(String s) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        List<ResTableEntity> res;

        try{
            transaction.begin();
            res = entityManager.createQuery(
                            "SELECT e " +
                                    "FROM ResTableEntity e " +
                                    "WHERE e.name like :name",
                            ResTableEntity.class
                    )
                    .setParameter("name",s+"%")
                    .getResultList();
            transaction.commit();}
        finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return res;
    }

    @Override
    public List<ResTableEntity> getResByPriceLimit(Long s) {
        return null;
    }

    @Override
    public void updateStartsWith(String s) {

    }

    @Override
    public void lowerPriceAbove1000() {

    }
}
