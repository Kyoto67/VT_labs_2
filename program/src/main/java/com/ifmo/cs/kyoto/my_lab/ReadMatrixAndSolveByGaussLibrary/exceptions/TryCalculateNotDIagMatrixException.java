package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions;

public class TryCalculateNotDIagMatrixException extends Exception{
    public TryCalculateNotDIagMatrixException() {
        super("The matrix you are trying to work with is not diagonal in shape");
    }
}
