package com.ifmo.cs.kyoto.my_lab.LabRunner;

import com.ifmo.cs.kyoto.my_lab.api.Asker;
import com.ifmo.cs.kyoto.my_lab.api.IntegrationBySimpson;
import com.ifmo.cs.kyoto.my_lab.api.Printer;
import com.ifmo.cs.kyoto.my_lab.calculators.IntegrateBySimpsonHandler;
import com.ifmo.cs.kyoto.my_lab.util.AskerRealization;
import com.ifmo.cs.kyoto.my_lab.util.Function;
import com.ifmo.cs.kyoto.my_lab.util.PrinterRealization;

public class MyLabRunner {
    Asker asker = new AskerRealization();

    public void run() {
        Function function = asker.askWhichFunction();
        double leftBoundary;
        double rightBoundary;
        if (function == Function.FOURTH) {
            leftBoundary = asker.askLeftIntegrationBoundary(0);
            rightBoundary = asker.askRightIntegrationBoundary();
        } else {
            leftBoundary = asker.askLeftIntegrationBoundary();
            rightBoundary = asker.askRightIntegrationBoundary();
        }
        int sectionsCount = asker.askHowManySections();
        IntegrationBySimpson integrator = new IntegrateBySimpsonHandler();
        Printer printer = new PrinterRealization();
        double result = integrator.integrate(function.getFunction(), leftBoundary, rightBoundary, sectionsCount);
        printer.printIntegrationResult(result);
    }
}
