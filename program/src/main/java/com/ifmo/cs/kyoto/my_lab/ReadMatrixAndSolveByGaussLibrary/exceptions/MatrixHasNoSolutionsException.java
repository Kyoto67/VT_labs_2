package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions;

public class MatrixHasNoSolutionsException extends Exception {
    public MatrixHasNoSolutionsException() {
        super("This matrix has no solutions!");
    }
}
