package com.logic;

import jakarta.persistence.*;

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

        try {
            transaction.begin();
            res = entityManager.createQuery(
                            "SELECT e " +
                                    "FROM ResTableEntity e " +
                                    "WHERE e.name like :name",
                            ResTableEntity.class
                    )
                    .setParameter("name", s + "%")
                    .getResultList();

            transaction.commit();
        } finally {
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
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        List<ResTableEntity> res;
        try {
            transaction.begin();
            res = entityManager.createNamedQuery("get_res_by_price_limit_long", ResTableEntity.class)
                    .setParameter("price", s)
                    .getResultList();
//                            "SELECT e " +
//                                    "FROM ResTableEntity e " +
//                                    "WHERE e.name like :name",
//                            ResTableEntity.class
//                    )
//                    .setParameter("name",s+"%")
//                    .getResultList();

            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return res;
    }

    @Override
    public String updateResortByName(ResTableEntity res, String s) {

//        DBResortControl dbResortControlTemp = new DBResortControl();
//        for (item : dbResortControlTemp.getStartsWith(s)) {

//         (dbResortControlTemp.getStartsWith(s) != null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();

            String updateName = res.getName();
            String updateCountry = res.getCountry();
            String updateSeason = res.getSeason();
            Long updatePrice = res.getPrice();

            try {
                transaction.begin();
//            Query query = entityManager.createQuery(
//                   "UPDATE ResTableEntity SET " +
//                    "name = :" + updateName + ", " +
//                    "country = :" + updateCountry + ", " +
//                    "season = :" + updateSeason + ", " +
//                    "price = :" + updatePrice +  " " +
//                    "WHERE name = :"+ s);
//            query.setParameter(1, res.getName());
//            query.setParameter(2, res.getCountry());
//            query.setParameter(3, res.getSeason());
//            query.setParameter(4, res.getPrice());
////            query.setParameter(5, s
//            int updatedLines = query.executeUpdate();

                if (res.getId() == null) {
                    entityManager.persist(res);
                    System.out.println(res.getId());
                } else {
                    ResTableEntity existEntity = entityManager
                            .find(ResTableEntity.class, res.getId());
                    if (!existEntity.equals(res)) {
                        existEntity.setName(updateName);
                        existEntity.setCountry(updateCountry);
                        existEntity.setSeason(updateSeason);
                        existEntity.setPrice(updatePrice);
                        entityManager.persist(existEntity);
                    }
                }
                transaction.commit();
                return "Update success";

            } finally {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                entityManager.close();
                entityManagerFactory.close();
            }

        }


    @Override
    public void lowerPriceAbove1000() {

    }


}
