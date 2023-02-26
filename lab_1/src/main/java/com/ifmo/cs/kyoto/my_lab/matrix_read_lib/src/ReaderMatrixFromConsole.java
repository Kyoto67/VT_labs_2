package com.ifmo.cs.kyoto.my_lab.matrix_read_lib.src;

import com.ifmo.cs.kyoto.my_lab.matrix_read_lib.api.Reader;
import com.ifmo.cs.kyoto.my_lab.matrix_entity.Matrix;
import com.ifmo.cs.kyoto.my_lab.util.MatrixGenerator;
import com.ifmo.cs.kyoto.my_lab.util.MatrixGeneratorImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReaderMatrixFromConsole implements Reader {

    Scanner in = new Scanner(System.in);
    String input;
    MatrixGenerator  matrixGenerator= new MatrixGeneratorImpl();

    @Override
    public Matrix read() {
        boolean answerIsCorrect = false;
        while (!answerIsCorrect) {
            System.out.print("Enter the coefficients of the equation? (otherwise will be generated automatically) Y/N: ");
            input = in.nextLine();
            if (input.equals("Y") || input.equals("N")) {
                answerIsCorrect = true;
            }
        }
        if (input.equals("Y")) {
            while (true) {
                System.out.print("Enter the dimensionality of the matrix: ");
                try{
                    int size = in.nextInt();
                    if (size <=1 || size >20) {
                        System.out.println("Enter an integer between 2 and 20.");
                        continue;
                    }
                    double[][] A = new double[size][size];
                    double[] B = new double[size];
                    System.out.println("Enter the coefficients of matrices A and B line by line, separating them with a space:");
                    for (int i=0; i<size; i++) {
                        for (int j=0; j<size; j++) {
                            A[i][j] = in.nextDouble();
                        }
                        B[i] = in.nextDouble();
                    }
                    System.out.println("Input completed.");
                    return new Matrix(A, B, size);
                } catch (InputMismatchException exception) {
                    System.out.println("Incorrect input");
                }
            }
        } else {
            while (true) {
                System.out.print("Enter the dimensionality of the matrix: ");
                try {
                    int size = in.nextInt();
                    if (size <= 1 || size > 20) {
                        System.out.println("Enter an integer between 2 and 20.");
                        continue;
                    }
                    return matrixGenerator.generate(size);
                } catch (InputMismatchException exception) {
                    System.out.println("Incorrect input");
                }
            }
        }
    }
}
