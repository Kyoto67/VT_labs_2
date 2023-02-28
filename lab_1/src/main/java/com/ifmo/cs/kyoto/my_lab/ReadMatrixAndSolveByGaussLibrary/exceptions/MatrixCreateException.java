package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity.Matrix;

public class MatrixCreateException extends Exception{
    public MatrixCreateException(String message) {
        super(message);
    }
}
