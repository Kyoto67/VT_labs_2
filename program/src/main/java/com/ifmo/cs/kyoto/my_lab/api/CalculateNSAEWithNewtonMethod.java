package com.ifmo.cs.kyoto.my_lab.api;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixHasNoSolutionsException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryCalculateNotDIagMatrixException;

public interface CalculateNSAEWithNewtonMethod {
    double[] calculate(double[] X, CreateMatrixForNewtoneMethod matrixCreator, double epsilon) throws MatrixCreateException, MatrixHasNoSolutionsException, TryCalculateNotDIagMatrixException;
}
