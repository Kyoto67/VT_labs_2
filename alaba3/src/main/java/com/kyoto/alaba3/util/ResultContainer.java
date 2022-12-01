package com.kyoto.alaba3.util;

import lombok.Getter;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "resultcontainer")
@SessionScoped
@Getter
@Setter
public class ResultContainer {

    private double x = 1;
    private double y = 1;
    private double r = 2;
    private double oldR = 2;
    private DataChecker checker = new DataChecker();
    private EntityManagerFactory entityManagerFactory;
    private int timeOffset;

    private List<Result> results;


    public ResultContainer(){
        this(new ArrayList<>());
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
    }

    public ResultContainer(List<Result> results) {
        this.results = results;
    }

    public void submit(){
        if( x < -5 || x > 5 || y < -5 || y > 5 || r < 2 || r > 5) return;
        Date date = new Date();
        date.setHours(date.getHours() - (timeOffset+180) / 60);
        oldR = r;
        final Result result = new Result( results.size() + 1, x, y, r, checker.hitCheckerHandle(x, y, r), "0.000" + ( (Integer) ( (int) (Math.random()*10) ) ).toString() + ".s", date);
        results.add(result);
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(result);
        entityManager.getTransaction().commit();
    }

    private String resultsToJSON(List<Result> results) {
        String[] output = {"["};
        results.forEach( (obj) -> output[0]+= obj.toString() + ", \n");
        output[0] = output[0].substring( 0, output[0].length() - 3);
        output[0] += "]";
        return output[0];
    }
}
