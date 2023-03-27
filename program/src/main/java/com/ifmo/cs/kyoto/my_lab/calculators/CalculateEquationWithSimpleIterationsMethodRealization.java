package com.ifmo.cs.kyoto.my_lab.calculators;

import com.ifmo.cs.kyoto.my_lab.api.CalculateEquationWithSimpleIterationsMethod;
import com.ifmo.cs.kyoto.my_lab.api.SimpleFunction;

public class CalculateEquationWithSimpleIterationsMethodRealization implements CalculateEquationWithSimpleIterationsMethod {
    @Override
    public double[] chooseLyambdaAndX_0(SimpleFunction derivativeFunc, double a, double b) {
        double v1 = Math.abs(derivativeFunc.apply(a));
        double v2 = Math.abs(derivativeFunc.apply(b));
        double v = (-1) * (1 / Math.max(v1, v2));
        if (v1 > v2) return new double[]{v, a};
        else return new double[]{v, b};
    }

    @Override
    public double calculate(SimpleFunction func, double lyambda, double x, double epsilon) {
        double x_i = x + lyambda * func.apply(x);
        if (Math.abs(x_i - x) <= epsilon) {
            return x_i;
        } else {
            return calculate(func, lyambda, x_i, epsilon);
        }
    }
}
