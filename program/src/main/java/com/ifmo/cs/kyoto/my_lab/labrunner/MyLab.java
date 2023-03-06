package com.ifmo.cs.kyoto.my_lab.labrunner;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api.MatrixCalulatorHandler;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api.Printer;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.calculator.MatrixCalculatorHandlerImpl;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity.Matrix;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api.Reader;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixHasNoSolutionsException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryCalculateNotDIagMatrixException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryResidualWithCalculateSolutionsFromOtherMatrixException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.readers.ReaderMatrixFromConsole;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.readers.ReaderMatrixFromFile;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.util.PrinterImpl;

import java.io.FileNotFoundException;

public class MyLab {
    Reader reader;
    Matrix matrix;
    MatrixCalulatorHandler matrixCalulatorHandler;
    Printer printer = new PrinterImpl();

    public void start(String[] args) throws MatrixCreateException, TryCalculateNotDIagMatrixException, TryResidualWithCalculateSolutionsFromOtherMatrixException {
        if (args.length != 0) {
            try {
                reader = new ReaderMatrixFromFile(args[0]);
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                return;
            }
        } else {
            reader = new ReaderMatrixFromConsole();
        }
            try {
                matrix = reader.read();
            } catch (Exception e) {
                System.out.println("Data corrupted: " + e.getMessage());
                return;
            }
        matrixCalulatorHandler= new MatrixCalculatorHandlerImpl(matrix);
        try {
            printer.printForTriangledMatrix(matrixCalulatorHandler.transformToTriangleForm());
            printer.printDet(matrixCalulatorHandler.calcDet());
            double[] roots = matrixCalulatorHandler.calcSolutions();
            double[] residual = matrixCalulatorHandler.calcResidual(matrix,roots);
            printer.printResidual(residual);
            printer.printRoots(roots);
        } catch (MatrixHasNoSolutionsException e) {
            System.out.println(e.getMessage());
        }
    }
}
