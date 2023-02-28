package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.readers;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api.Reader;
import java.util.Scanner;

public abstract class MatrixReader implements Reader {

    protected Scanner in;

    protected abstract int readSize();
    protected abstract void readMatrix(double[][] A, double[] B);
}
