package com.ifmo.cs.kyoto.my_lab.calculators;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api.MatrixCalulatorHandler;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.calculator.MatrixCalculatorHandlerImpl;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity.Matrix;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixHasNoSolutionsException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryCalculateNotDIagMatrixException;
import com.ifmo.cs.kyoto.my_lab.api.CalculateNSAEWithNewtonMethod;
import com.ifmo.cs.kyoto.my_lab.api.CreateMatrixForNewtoneMethod;

public class CalculateNSAEWithNewtonMethodRealization implements CalculateNSAEWithNewtonMethod {
    @Override
    public double[] calculate(double[] X, CreateMatrixForNewtoneMethod matrixCreator, double epsilon) throws MatrixCreateException, MatrixHasNoSolutionsException, TryCalculateNotDIagMatrixException {
        Matrix matrix = matrixCreator.create(X);
        MatrixCalulatorHandler calculator = new MatrixCalculatorHandlerImpl(matrix);
        calculator.transformToTriangleForm();
        double[] solutions = calculator.calcSolutions();
        double[] newX = new double[solutions.length];
        for (int i = 0; i < solutions.length; i++) {
            newX[i] = X[i] + solutions[i];
        }
        boolean flag = true;
        for (int i = 0; i < newX.length; i++) {
            if (Math.abs(newX[i] - X[i]) > epsilon) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return newX;
        } else {
            return calculate(newX, matrixCreator, epsilon);
        }
    }
}
