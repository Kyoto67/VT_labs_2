package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity.Matrix;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;

public interface MatrixGenerator {
    Matrix generate(int size) throws MatrixCreateException;
    Matrix generate(int size, double[] roots) throws MatrixCreateException;
}
