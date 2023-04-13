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
        Printer printer = new PrinterRealization();
        IntegrationBySimpson integrator = new IntegrateBySimpsonHandler();
        if (function == Function.SECOND) {
            printer.printMessageAboutDiscontinuity();
            leftBoundary = asker.askLeftIntegrationBoundary();
            rightBoundary = asker.askRightIntegrationBoundary();
        } else if (function == Function.FOURTH) {
            leftBoundary = asker.askLeftIntegrationBoundary(0);
            rightBoundary = asker.askRightIntegrationBoundary();
        } else {
            leftBoundary = asker.askLeftIntegrationBoundary();
            rightBoundary = asker.askRightIntegrationBoundary();
        }
        double epsilon = asker.askAccuracy();
        double result = integrator.integrate(function.getFunction(), leftBoundary, rightBoundary, epsilon);
        printer.printIntegrationResult(result);
    }
}
