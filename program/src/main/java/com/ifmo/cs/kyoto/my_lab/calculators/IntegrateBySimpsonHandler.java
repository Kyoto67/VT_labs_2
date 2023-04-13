package com.ifmo.cs.kyoto.my_lab.calculators;

import com.ifmo.cs.kyoto.my_lab.api.IntegrationBySimpson;
import com.ifmo.cs.kyoto.my_lab.api.SimpleFunction;

public class IntegrateBySimpsonHandler implements IntegrationBySimpson {
    @Override
    public double integrate(SimpleFunction f, double a, double b, int n) {
        double h = IntegrationBySimpsonCalculator.calcutaleH(a, b, n);
        double[] segments = IntegrationBySimpsonCalculator.sectioning(a, b, n, h);
        return IntegrationBySimpsonCalculator.integration(f, segments, h);
    }
}
