package com.ifmo.cs.kyoto.alaba4.dto;

import lombok.Value;

import java.util.Date;

@Value
public class ResultDTO {
    double x;
    double y;
    double r;
    boolean match;
    long workingTime;
    Date currDateandTime;

    @Override
    public String toString(){
        return "{\"x\":\"" + x + "\",\"y\":\"" + y +"\",\"r\":\"" + r +
                "\",\"match\":\"" + match + "\",\"workingTime\":\"" + workingTime + "\",\"currentDateandTime\":\"" + currDateandTime + "\"}";
    }
}
