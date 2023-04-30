package com.kyoto.alaba3.util;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Singleton
@LocalBean
public class ResultDao {
    private EntityManagerFactory resultFactory;
//    private EntityManagerFactory dateFactory;

    @PostConstruct
    public void init() {
        resultFactory = Persistence.createEntityManagerFactory("result");
//        dateFactory = Persistence.createEntityManagerFactory("date");
    }

    public void uploadNewEntityToBase( Result result ) {
        EntityManager entityManager = resultFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(result);
        entityManager.persist(result.getCurrentDateandTime());
        entityManager.getTransaction().commit();

//        entityManager = dateFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.getTransaction().commit();
    }

}
