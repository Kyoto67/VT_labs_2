package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.tester;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api.MatrixCalulatorHandler;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api.Printer;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api.Tester;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.calculator.MatrixCalculatorHandlerImpl;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity.Matrix;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api.MatrixGenerator;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixHasNoSolutionsException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryCalculateNotDIagMatrixException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.readers.ReaderMatrixFromConsole;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.util.MatrixGeneratorImpl;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.util.PrinterImpl;
import java.util.Scanner;

public class TesterImpl extends ReaderMatrixFromConsole implements Tester {


    Scanner in = new Scanner(System.in);
    MatrixGenerator matrixGenerator = new MatrixGeneratorImpl();
    Printer printerSource = new Printer() {
        @Override
        public void printRoots(double[] roots) {
            System.out.println("Source data: ");
            for (int i=0; i<roots.length; i++) {
                System.out.println("x" + (i+1) + " = " + roots[i] + ";");
            }
            System.out.println();
        }

        @Override
        public void printDet(double det) {

        }

        @Override
        public void printResidual(double[] residual) {

        }

        @Override
        public void printMatrix(Matrix matrix) {
        }

        @Override
        public void printForTriangledMatrix(Matrix matrix) {

        }

        @Override
        public void printSolutionCheck(Matrix matrix, double[] roots) {

        }
    };
    Printer printer = new PrinterImpl();

    public void run() throws MatrixCreateException, TryCalculateNotDIagMatrixException, MatrixHasNoSolutionsException {
        Matrix matrix;
        int size = readSize();
        double[] roots = new double[size];
        matrix = matrixGenerator.generate(size, roots);
        printerSource.printRoots(roots);
        MatrixCalulatorHandler calculator = new MatrixCalculatorHandlerImpl(matrix);
        long start = System.currentTimeMillis();
        calculator.transformToTriangleForm();
        roots = calculator.calcSolutions();
        printer.printSolutionCheck(matrix, roots);
        printer.printRoots(roots);
        System.out.println("Time: " + (System.currentTimeMillis() - start) + "ms");
    }
}
