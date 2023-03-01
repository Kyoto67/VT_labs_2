package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity.Matrix;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixHasNoSolutionsException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryCalculateNotDIagMatrixException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryResidualWithCalculateSolutionsFromOtherMatrixException;

public interface MatrixCalulatorHandler {
    Matrix transformToDiagForm() throws MatrixCreateException;
    double calcDet() throws TryCalculateNotDIagMatrixException, MatrixHasNoSolutionsException;
    double[] calcSolutions() throws TryCalculateNotDIagMatrixException;
    double[] calcResidual(Matrix matrix, double[] solutions) throws TryResidualWithCalculateSolutionsFromOtherMatrixException;
}
