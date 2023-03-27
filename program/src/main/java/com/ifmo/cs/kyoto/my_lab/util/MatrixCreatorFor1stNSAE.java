package com.ifmo.cs.kyoto.my_lab.util;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity.Matrix;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;
import com.ifmo.cs.kyoto.my_lab.api.CreateMatrixForNewtoneMethod;

public class MatrixCreatorFor1stNSAE implements CreateMatrixForNewtoneMethod {
    @Override
    public Matrix create(double[] X) throws MatrixCreateException {
        double[][] A = new double[2][2];
        A[0][0] = 2*X[0];
        A[0][1] = 2*X[1];
        A[1][0] = -6*X[0];
        A[1][1] = 1;
        double[] B = new double[2];
        B[0] = 4 - Math.pow(X[0],2) - Math.pow(X[1],2);
        B[1] = 3 * Math.pow(X[0],2) - X[1];
        return new Matrix(A, B, 2);
    }
}
