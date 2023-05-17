package com.kyoto.alaba3.mbeans;

import java.io.Serializable;

public class Square implements SquareMXBean, Serializable {
    double lastSquare = 0;

    public Square() {
    }

    @Override
    public double calculateSquare(double r) {
        double squareSquare = r * 0.5 * r * 1;
        double triangleSquare = (r * (r / 2)) / 2;
        double circleSquare = (Math.PI * r * r) / 4;
        double totalSquare = squareSquare + triangleSquare + circleSquare;
        lastSquare = totalSquare;
        return totalSquare;
    }

    @Override
    public double getLastSquare() {
        return lastSquare;
    }

//    @Override
//    public void setLastSquare(double lastSquare) {
//        this.lastSquare = lastSquare;
//    }
}
