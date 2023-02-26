package com.ifmo.cs.kyoto.my_lab.gauss_lib.src;

import com.ifmo.cs.kyoto.my_lab.matrix_entity.Matrix;

public class MatrixCalculator {
    private Matrix matrix;
    private double[] solution;

    MatrixCalculator(Matrix matrix) {
        this.matrix = matrix;
        this.solution = new double[matrix.getSize()];
    }

    double[] getSolution() {
        return solution;
    }

    void toDiagonalForm() {
        double[][] A = matrix.getA();
        double[] B = matrix.getB();
        int n = matrix.getSize();
        for (int i = 0; i < n; i++) {
            lineNormalization(A[i], A[i][i], B, i);
            for (int j = i + 1; j < n; j++) {
                lineSub(A[j], A[i], B, j, i, A[j][i]);
            }
        }
        matrix = new Matrix(A, B, n);
        matrix.setDiagonal(true);
    }
    void reverseAlgorithm() {
        if (matrix.isDiagonal()) {
            double[][] A = matrix.getA();
            double[] B = matrix.getB();
            for (int i = matrix.getSize() - 1; i >= 0; i--) {
                for (int j= i -1; j>=0 ; j--) {
                    lineSub(A[j], A[i], B, j, i, A[j][i]);
                }
                solution[i] = B[i]/A[i][i];
            }
            matrix = new Matrix(A, B, matrix.getSize());
        }
    }

    private void lineNormalization(double[] line, double a, double[] B, int lineIndex) {
        if (a == 0 || a == 1) return;
        for (int i = 0; i < line.length; i++) {
            line[i] /= a;
        }
        B[lineIndex] /= a;
    }

    private void lineSub(double[] line2, double[] line1, double[] B, int lineIndex2, int lineIndex1, double multiplier) {
        for (int i=0; i<line2.length; i++) {
            line2[i] -= line1[i]*multiplier;
        }
        B[lineIndex2] -= B[lineIndex1]*multiplier;
    }
}
