package com.ifmo.cs.kyoto.my_lab.util;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity.Matrix;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;
import com.ifmo.cs.kyoto.my_lab.api.CreateMatrixForNewtoneMethod;

public class MatrixCreatorFor2ndNSAE implements CreateMatrixForNewtoneMethod {
    @Override
    public Matrix create(double[] X) throws MatrixCreateException {
        double[][] A = new double[2][2];
        double[] B = new double[2];
        A[0][0] = (-1) * Math.sin(X[0]);
        A[0][1] = -1;
        A[1][0] = -1;
        A[1][1] = Math.cos(X[1]);
        B[0] = X[1] - Math.cos(X[0]);
        B[1] = X[0] - Math.sin(X[1]);
        return new Matrix(A, B, 2);
    }
}
