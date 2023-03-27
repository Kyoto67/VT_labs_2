package com.ifmo.cs.kyoto.my_lab.api;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity.Matrix;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;

public interface CreateMatrixForNewtoneMethod {
    Matrix create(double[] X) throws MatrixCreateException;
}
