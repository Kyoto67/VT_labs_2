package com.ifmo.cs.kyoto.my_lab.util;

import com.ifmo.cs.kyoto.my_lab.api.Printer;

public class PrinterRealization implements Printer {

    @Override
    public void printIntegrationResult(double x) {
        System.out.println("Result of integration: " + x);
    }

    @Override
    public void printMessageAboutDiscontinuity() {
        System.out.println("In this function, the discontinuity of the first kind at x=0 is eliminated by the definition of the function at this point f(0) = 0.");
    }

}