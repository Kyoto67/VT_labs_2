package com.kyoto.alaba3.util;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Singleton
@LocalBean
public class ResultDao {
    private EntityManagerFactory entityManagerFactory;

    public ResultDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }

    public void uploadNewEntityToBase( Result result) {
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(result);
        entityManager.getTransaction().commit();
    }

}
