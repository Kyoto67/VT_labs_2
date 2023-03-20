package com.ifmo.cs.kyoto.my_lab.api;

public interface CalculateEquationWithChordMethod {
    boolean calculate(SimpleFunction func, double a, double b, double x, double epsilon, long n);
    double[] chooseAandB(SimpleFunction func);
}
