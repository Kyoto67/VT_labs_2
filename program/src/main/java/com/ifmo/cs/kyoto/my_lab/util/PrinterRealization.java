package com.ifmo.cs.kyoto.my_lab.util;

import com.ifmo.cs.kyoto.my_lab.api.Printer;

public class PrinterRealization implements Printer {

    @Override
    public void printIntegrationResult(double x) {
        System.out.println("Result of integration: " + x);
    }

}