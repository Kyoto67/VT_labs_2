package com.ifmo.cs.kyoto.my_lab.util;

import com.ifmo.cs.kyoto.my_lab.api.Printer;

public class PrinterImpl implements Printer {
    @Override
    public void printChordandSimpleIterationsSolutions(double xChord, double xSimple) {
        System.out.println("The solution obtained by the chord method: " + xChord);
        System.out.println("The solution obtained by the method of simple iterations: " + xSimple);
    }

    @Override
    public void printNSAESolutions(double[] X) {
        System.out.print("Solutions: ");
        for (int i=0; i<X.length; i++) {
            System.out.print("x" + (i+1) + " = " + X[i] + "\n           ");
        }
    }
}
