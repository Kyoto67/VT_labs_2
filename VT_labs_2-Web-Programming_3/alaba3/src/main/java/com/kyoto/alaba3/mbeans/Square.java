package com.kyoto.alaba3.mbeans;

import java.io.Serializable;

public class Square implements SquareMBean, Serializable {
    Double lastSquare = null;

    public Square() {
        lastSquare = 0.0;
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
    public Double getLastSquare() {
        return lastSquare;
    }

    @Override
    public void setLastSquare(Double lastSquare) {
        this.lastSquare = lastSquare;
    }
}
