package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.readers;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity.Matrix;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReaderMatrixFromFile extends MatrixReader {

    private final String path = System.getProperty("user.dir");

    public ReaderMatrixFromFile(String fileName) throws FileNotFoundException {
        File file = new File(path + "/" + fileName);
        this.in = new Scanner(file);
    }

    @Override
    public Matrix read() throws MatrixCreateException {
        int size = readSize();
        double[][] A = new double[size][size];
        double[] B = new double[size];
        readMatrix(A, B);
        return new Matrix(A, B, size);
    }

    @Override
    protected int readSize() {
        return in.nextInt();
    }

    @Override
    protected void readMatrix(double[][] A, double[] B) {
        int size = A.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                A[i][j] = in.nextDouble();
            }
            B[i] = in.nextDouble();
        }
    }
}
