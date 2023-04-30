package com.kyoto.alaba3.util;

import com.kyoto.alaba3.exception.WrongValueException;

import java.util.Date;

public interface ResultService {
    boolean verification(double x, double y, double r);

    boolean hitCheck(double x, double y, double r);

    void pushToBase(Result result);

    Date getDatewithOffset(int offset);

    String getFormattedWorkingTime();
    asdadas
}