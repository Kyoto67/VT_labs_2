package com.ifmo.cs.kyoto.my_lab.calculators;

import com.ifmo.cs.kyoto.my_lab.api.CalculateEquationWithChordMethod;
import com.ifmo.cs.kyoto.my_lab.api.SimpleFunction;

public class CalculateEquationWithChordMethodRealization implements CalculateEquationWithChordMethod {
    @Override
    public boolean calculate(SimpleFunction func, double a, double b, double x, double epsilon, long n) {
        if (n == 0) {
            x = a - (b - a) / (func.apply(b) - func.apply(a)) * func.apply(a);
            n++;
            if (func.apply(a) * func.apply(x) < 0) {
                calculate(func, a, x, x, epsilon, n);
            } else if (func.apply(b) * func.apply(x) < 0) {
                calculate(func, x, b, x, epsilon, n);
            } else {
                return false;
            }
        } else {
            double x_i = (a * func.apply(b) - b * func.apply(a)) / (func.apply(b) - func.apply(a));
            n++;
            if ( Math.abs(x_i - x) > epsilon ) {
                x = x_i;
                if (func.apply(a) * func.apply(x) < 0) {
                    calculate(func, a, x, x, epsilon, n);
                } else if (func.apply(b) * func.apply(x) < 0){
                    calculate(func, x, b, x, epsilon, n);
                } else {
                    return false;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public double[] chooseAandB(SimpleFunction func) {
        double a = 1.0;
        double b = 1.0;
        while (!(func.apply(a) * func.apply(b) < 0)) {
            a *= 2;
            b *= 2;
        }
        return new double[]{a, b};
    }
}
