package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity.Matrix;

public interface Printer {
    void printRoots(double[] roots);
    void printDet(double det);
    void printResidual(double[] residual);
    void printMatrix(Matrix matrix);
}
