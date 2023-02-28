package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.calculator;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api.MatrixCalulatorHandler;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity.Matrix;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryCalculateNotDIagMatrixException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryResidualWithCalculateSolutionsFromOtherMatrixException;

public class MatrixCalculatorHandlerImpl implements MatrixCalulatorHandler {
    MatrixCalculator matrixCalculator;

    public MatrixCalculatorHandlerImpl(Matrix m) throws MatrixCreateException {
        matrixCalculator = new MatrixCalculator(m);
    }
    @Override
    public Matrix transformToDiagForm() throws MatrixCreateException {
        matrixCalculator.toTriangleForm();
        matrixCalculator.fromTriangleToDiag();
        return matrixCalculator.getMatrix();
    }

    @Override
    public double calcDet() throws TryCalculateNotDIagMatrixException {
        return matrixCalculator.calcDetFromDiag();
    }

    @Override
    public double[] calcSolutions() throws TryCalculateNotDIagMatrixException {
        return matrixCalculator.calculateSolutionsFromDiag();
    }

    @Override
    public double[] calcResidual(Matrix matrix, double[] solutions) throws TryResidualWithCalculateSolutionsFromOtherMatrixException {
        return matrixCalculator.calcResidualFromOrigMatrixAndSolutions(matrix, solutions);
        }
}
