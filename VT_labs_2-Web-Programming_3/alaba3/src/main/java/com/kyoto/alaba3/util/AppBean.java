package com.kyoto.alaba3.util;

import com.kyoto.alaba3.mbeans.*;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
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
    private MBeanServer mbs;
    MetricsMBean metricsMBean;
    SquareMBean squareMBean;

    @EJB
    private ResultServiceRealization service;

    public AppBean(){
        this(new ArrayList<>());
    }

    public AppBean(List<Result> results) {
        this.results = results;
        this.service = new ResultServiceRealization();
        this.mbs = ManagementFactory.getPlatformMBeanServer();
        this.metricsMBean = new MetricsMBeanImpl();
        this.squareMBean = new SquareMBeanImpl();
        ObjectName metricsName = null;
        ObjectName squareName = null;
        try {
            metricsName = new ObjectName("AppBean:name=metricsMBean");
            squareName = new ObjectName("AppBean:name=squareMBean");
            mbs.registerMBean(metricsMBean,metricsName);
            mbs.registerMBean(squareMBean,squareName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void submit(){
        if ( service.verification(x, y, r) ) {
            boolean hitCheck = service.hitCheck(x, y, r);
            String workingTime = service.getFormattedWorkingTime();
            Date date = service.getDatewithOffset(timeOffset);
            Result result = new Result(results.size() +1 , x, y, r, hitCheck, workingTime, date);
            resultMBeansHandle(result);
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

    private void resultMBeansHandle(Result result) {
        metricsMBean.hitsInc();
        if (result.isMatch()) {
            metricsMBean.clearMissedStreak();
        } else {
            metricsMBean.missedAndStreakInc();
        }
        double currSquare = squareMBean.calculateSquare(result.getR());
    }

}


