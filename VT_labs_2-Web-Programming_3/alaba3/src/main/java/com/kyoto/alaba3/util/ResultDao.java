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

    @PostConstruct
    public void init() {
        resultFactory = Persistence.createEntityManagerFactory("result");
    }

    public void uploadNewEntityToBase( Result result ) {
        EntityManager entityManager = resultFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(result);
        entityManager.persist(result.getCurrentDateandTime());
        entityManager.getTransaction().commit();
    }

}
