package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.util.DoubleRounder;
import lombok.Getter;

@Getter
public class Matrix {
    final double[][] A;
    final double [] B;
    final int size;

    public Matrix( double[][] A, double[] B, int size) throws MatrixCreateException {
        if (A.length != size) throw new MatrixCreateException("The matrix is not square or the size is incorrect.");
        if (B.length != size) throw new MatrixCreateException("The matrix is not square or the size is incorrect.");
        for (double[] a : A) {
            if (a.length != size) throw new MatrixCreateException("The matrix is not square or the size is incorrect.");
        }
        DoubleRounder.roundAForMatrix(A);
        DoubleRounder.roundBForMatrix(B);
        this.A = A;
        this.B = B;
        this.size = size;
    }
}
