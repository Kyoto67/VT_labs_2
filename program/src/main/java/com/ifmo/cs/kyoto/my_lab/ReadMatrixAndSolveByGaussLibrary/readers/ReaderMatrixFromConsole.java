package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.readers;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity.Matrix;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api.MatrixGenerator;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.util.MatrixGeneratorImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReaderMatrixFromConsole extends MatrixReader {

    MatrixGenerator matrixGenerator = new MatrixGeneratorImpl();

    public ReaderMatrixFromConsole() {
        this.in = new Scanner(System.in);
    }

    @Override
    public Matrix read() throws MatrixCreateException {
        System.out.print("Enter the coefficients of the equation? (otherwise will be generated automatically) Y/N: ");
        if (readYorN()) {
            while (true) {
                int size = readSize();
                double[][] A = new double[size][size];
                double[] B = new double[size];
                System.out.println("Enter the coefficients of matrices A and B line by line, separating them with a space:");
                readMatrix(A, B);
                System.out.println("Input completed.");
                return new Matrix(A, B, size);
            }
        } else {
            int size = readSize();
            return matrixGenerator.generate(size);
        }
    }

    @Override
    protected int readSize() {
        while (true) {
            System.out.print("Enter the dimensionality of the matrix: ");
            try {
                int size = in.nextInt();
                if (size <= 1 || size > 20) {
                    System.out.println("Enter an integer between 2 and 20.");
                    continue;
                }
                return size;
            } catch (InputMismatchException exception) {
                System.out.println("Incorrect input.");
            }
        }
    }

    @Override
    protected void readMatrix(double[][] A, double[] B) {
        int size = A.length;
        while (true) {
            try {
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        A[i][j] = in.nextDouble();
                    }
                    B[i] = in.nextDouble();
                }
                return;
            } catch (InputMismatchException exception) {
                System.out.println("Incorrect input, try again.");
            }
        }
    }

    private boolean readYorN() {
        while (true) {
            try {
                String input = in.nextLine();
                if (input.equals("Y")) {
                    return true;
                }
                if (input.equals("N")) {
                    return false;
                }
            } catch (Exception ignored) {
                //pass
            }
        }
    }

}
