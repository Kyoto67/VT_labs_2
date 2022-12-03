package com.kyoto.alaba3.util;

import lombok.Getter;
import lombok.Setter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@SessionScoped
@ManagedBean(name = "appbean")
public class AppBean {

    private double x = 1;
    private double y = 1;
    private double r = 2;
    private double oldR = 2;
    private int timeOffset;
    private List<Result> results;

    @EJB
    private ResultServiceRealization service;

    public AppBean(){
        this(new ArrayList<>());
    }

    public AppBean(List<Result> results) {
        this.results = results;
        this.service = new ResultServiceRealization();
    }

    public void submit(){
        if ( service.verification(x, y, r) ) {
            boolean hitCheck = service.hitCheck(x, y, r);
            String workingTime = service.getFormattedWorkingTime();
            MyEntityDate date = service.getDatewithOffset(timeOffset);
            Result result = new Result(results.size() +1 , x, y, r, hitCheck, workingTime, date);
            result.getCurrentDateandTime().setResult(result);
            results.add(result);
            service.pushToBase(result);
        }
    }

    private String resultsToJSON(List<Result> results) {
        String[] output = {"["};
        results.forEach( (obj) -> output[0]+= obj.toString() + ", \n");
        output[0] = output[0].substring( 0, output[0].length() - 3);
        output[0] += "]";
        return output[0];
    }
}


