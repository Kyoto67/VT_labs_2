package com.ifmo.cs.kyoto.my_lab;

import java.util.List;

public class Result {

    /*
     * Complete the 'approximate_linear_least_squares' function below.
     *
     * The function is expected to return a DOUBLE.
     * The function accepts following parameters:
     *  1. DOUBLE_ARRAY x_axis
     *  2. DOUBLE_ARRAY y_axis
     */

    public static double approximate_linear_least_squares(List<Double> x_axis, List<Double> y_axis) {
        int n = x_axis.size();
        double sx = 0;
        double sxx = 0;
        double sy = 0;
        double sxy = 0;
        for (int i = 0; i < n; i++) {
            sx += x_axis.get(i);
            sxx += Math.pow(x_axis.get(i), 2);
            sy += y_axis.get(i);
            sxy += x_axis.get(i) * y_axis.get(i);
        }
        double a = (sxy * n - sx * sy) / (sxx * n - Math.pow(sx, 2));
        double b = (sy - sx * a) / n;
        double S = 0;
        for (int i = 0; i < n; i++) {
            double P = a * x_axis.get(i) + b;
            double epsilon = P - y_axis.get(i);
            S += Math.pow(epsilon, 2);
        }
        return S;
    }

}
