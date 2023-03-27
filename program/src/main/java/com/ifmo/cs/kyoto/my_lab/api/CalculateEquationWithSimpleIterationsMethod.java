package com.ifmo.cs.kyoto.my_lab.api;

public interface CalculateEquationWithSimpleIterationsMethod {
    double[] chooseLyambdaAndX_0(SimpleFunction derivativeFunc, double a, double b);

    double calculate(SimpleFunction func, double lyambda, double x, double epsilon);
}
