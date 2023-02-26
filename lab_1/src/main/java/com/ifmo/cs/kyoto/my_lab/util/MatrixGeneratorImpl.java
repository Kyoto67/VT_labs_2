package com.ifmo.cs.kyoto.my_lab.util;

import com.ifmo.cs.kyoto.my_lab.matrix_entity.Matrix;

public class MatrixGeneratorImpl implements MatrixGenerator {
    @Override
    public Matrix generate(int size) {
        double[] solutions = generateSolutions(size);
        double[][] A = new double[size][size];
        double[] B = new double[size];
        generateMatrix(A, B, solutions);
        return new Matrix(A, B, size);
    }

    @Override
    public Matrix generate(int size, boolean testMode) {
        double[] solutions = generateSolutions(size);
        System.out.println("Source data: ");
        for (int i=0; i<solutions.length; i++) {
            System.out.println("x" + (i+1) + " = " + solutions[i] + ";");
        }
        double[][] A = new double[size][size];
        double[] B = new double[size];
        generateMatrix(A, B, solutions);
        return new Matrix(A, B, size);
    }

    private double[] generateSolutions(int size) {
        double[] solutions = new double[size];
        for (int i=0; i<size; i++) {
            solutions[i] = Math.random() * 50 - 25;
        }
        return solutions;
    }

    private void generateMatrix(double[][] A, double[] B, double[] solutions) {
        int size = solutions.length;
        for (int i = 0; i < size; i++) {
            double b = 0;
            for (int j = 0; j < size; j++) {
                double a = Math.random() * 100 - 50;
                b += a * solutions[j];
                A[i][j] = a;
            }
            B[i] = b;
        }
    }
}
