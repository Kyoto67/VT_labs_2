package com.ifmo.cs.kyoto.my_lab.calculators;

import com.ifmo.cs.kyoto.my_lab.api.SimpleFunction;

public class IntegrationBySimpsonCalculator {
    static double integration(SimpleFunction f, double[] X, double h){
        double S = 0;
        for (int i=1; i<X.length -1; i++) {
            S += integratePart(f, X[i-1], X[i], X[i+1], h);
            i++;
        }
        return S;
    }

    static double calcutaleH(double a, double b, int n) {
        return (b-a)/n/2;
    }

    static double[] sectioning(double a, double b, int n, double h) {
        double x=a;
        double[] X = new double[n*2+1];
        for (int i=0; i<X.length; i++) {
            X[i] = x;
            x+=h;
        }
        return X;
    }

    private static double integratePart(SimpleFunction f, double z, double o, double v, double h) {
        return h/3*(f.apply(z) + f.apply(o)*4 + f.apply(v));
    }

}
