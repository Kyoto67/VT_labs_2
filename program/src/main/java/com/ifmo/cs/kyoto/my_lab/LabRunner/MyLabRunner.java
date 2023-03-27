package com.ifmo.cs.kyoto.my_lab.LabRunner;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixHasNoSolutionsException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryCalculateNotDIagMatrixException;
import com.ifmo.cs.kyoto.my_lab.api.*;
import com.ifmo.cs.kyoto.my_lab.calculators.CalculateEquationWithChordMethodRealization;
import com.ifmo.cs.kyoto.my_lab.calculators.CalculateEquationWithSimpleIterationsMethodRealization;
import com.ifmo.cs.kyoto.my_lab.calculators.CalculateNSAEWithNewtonMethodRealization;
import com.ifmo.cs.kyoto.my_lab.util.AskerImpl;
import com.ifmo.cs.kyoto.my_lab.util.MatrixCreatorFor1stNSAE;
import com.ifmo.cs.kyoto.my_lab.util.MatrixCreatorFor2ndNSAE;
import com.ifmo.cs.kyoto.my_lab.util.PrinterImpl;

public class MyLabRunner {

    Asker asker = new AskerImpl();
    Printer printer = new PrinterImpl();

    public void run() throws MatrixHasNoSolutionsException, TryCalculateNotDIagMatrixException, MatrixCreateException {
        switch (asker.askEquationOrNSAE()) {
            case (1) -> {
                SimpleFunction function = null;
                SimpleFunction derivativeFunc = null;
                double a = 0;
                double b = 0;
                switch (asker.askWhichEquation()) {
                    case (1) -> {
                        function = new SimpleFunction() {
                            @Override
                            public double apply(double x) {
                                return Math.sin(x);
                            }
                        };
                        derivativeFunc = new SimpleFunction() {
                            @Override
                            public double apply(double x) {
                                return Math.cos(x);
                            }
                        };
                        a = -1;
                        b = 1;
                    }
                    case (2) -> {
                        function = new SimpleFunction() {
                            @Override
                            public double apply(double x) {
                                return Math.cos(x);
                            }
                        };
                        derivativeFunc = new SimpleFunction() {
                            @Override
                            public double apply(double x) {
                                return (-1) * Math.sin(x);
                            }
                        };
                        a = 0;
                        b = 2;
                    }
                    case (3) -> {
                        function = new SimpleFunction() {
                            @Override
                            public double apply(double x) {
                                return Math.pow(x, 2) - 1;
                            }
                        };
                        derivativeFunc = new SimpleFunction() {
                            @Override
                            public double apply(double x) {
                                return 2 * x;
                            }
                        };
                        a = 0;
                        b = 2;
                    }
                    case (4) -> {
                        function = new SimpleFunction() {
                            @Override
                            public double apply(double x) {
                                return Math.pow(x, 3) - x + 4;
                            }
                        };
                        derivativeFunc = new SimpleFunction() {
                            @Override
                            public double apply(double x) {
                                return 3 * Math.pow(x, 2) - 1;
                            }
                        };
                        a = -2;
                        b = 0;
                    }
                    case (5) -> {
                        function = new SimpleFunction() {
                            @Override
                            public double apply(double x) {
                                return Math.pow(2, x) - 1;
                            }
                        };
                        derivativeFunc = new SimpleFunction() {
                            @Override
                            public double apply(double x) {
                                return Math.pow(2, x) * Math.log(2);
                            }
                        };
                        a = -1;
                        b = 1;
                    }
                }
                if (function != null && derivativeFunc != null) {
                    CalculateEquationWithChordMethod chordMethod = new CalculateEquationWithChordMethodRealization();
                    CalculateEquationWithSimpleIterationsMethod simpleIterationsMethod = new CalculateEquationWithSimpleIterationsMethodRealization();
                    double[] lyambdaAndX0Simple = simpleIterationsMethod.chooseLyambdaAndX_0(derivativeFunc, a, b);
                    double solSimple = simpleIterationsMethod.calculate(function, lyambdaAndX0Simple[0], lyambdaAndX0Simple[1], 0.01);
                    double solChord = chordMethod.calculate(function, a, b, 0, 0.01, 0);
                    printer.printChordandSimpleIterationsSolutions(solChord, solSimple);
                }
            }
            case (2) -> {
                CreateMatrixForNewtoneMethod creator = null;
                switch (asker.askWhichNSAE()) {
                    case (1) -> creator = new MatrixCreatorFor1stNSAE();
                    case (2) -> creator = new MatrixCreatorFor2ndNSAE();
                }
                if (creator != null) {
                    CalculateNSAEWithNewtonMethod calc = new CalculateNSAEWithNewtonMethodRealization();
                    double[] Xes = calc.calculate(new double[]{1, 1}, creator, 0.01);
                    printer.printNSAESolutions(Xes);
                }
            }
        }
    }
}
