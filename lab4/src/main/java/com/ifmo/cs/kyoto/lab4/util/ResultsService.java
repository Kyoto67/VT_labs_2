package com.ifmo.cs.kyoto.lab4.util;

import com.ifmo.cs.kyoto.lab4.entities.Result;

import java.util.Date;
import java.util.List;

public interface ResultsService {
    boolean verification(double x, double y, double r);

    boolean hitCheck(double x, double y, double r);

    void pushToBase(List<Result> results);

    Date getDatewithOffset(int offset);

    String getFormattedWorkingTime();
}