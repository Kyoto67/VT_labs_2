package com.ifmo.cs.kyoto.my_lab.calculators;

import com.ifmo.cs.kyoto.my_lab.api.IntegrationBySimpson;
import com.ifmo.cs.kyoto.my_lab.api.SimpleFunction;

public class IntegrateBySimpsonHandler implements IntegrationBySimpson {
    @Override
    public double integrate(SimpleFunction f, double a, double b, double epsilon) {
        int n=2;
        double h = IntegrationBySimpsonCalculator.calcutaleH(a, b, n);
        double[] segments = IntegrationBySimpsonCalculator.sectioning(a, n, h);
        double resOld = IntegrationBySimpsonCalculator.integration(f, segments, h);
        n*=2;
        h = IntegrationBySimpsonCalculator.calcutaleH(a, b, n);
        segments = IntegrationBySimpsonCalculator.sectioning(a, n, h);
        double resNew = IntegrationBySimpsonCalculator.integration(f, segments, h);
        while (Math.abs(resNew - resOld) > epsilon) {
            resOld = resNew;
            n*=2;
            h = IntegrationBySimpsonCalculator.calcutaleH(a, b, n);
            segments = IntegrationBySimpsonCalculator.sectioning(a, n, h);
            resNew = IntegrationBySimpsonCalculator.integration(f, segments, h);
        }
        return resNew;
    }
}
