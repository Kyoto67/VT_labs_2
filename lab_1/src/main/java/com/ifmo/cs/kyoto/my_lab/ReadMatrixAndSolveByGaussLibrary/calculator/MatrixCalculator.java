package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.calculator;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity.Matrix;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixHasNoSolutionsException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryCalculateNotDIagMatrixException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryResidualWithCalculateSolutionsFromOtherMatrixException;

public class MatrixCalculator {
    private Matrix matrix;
    private boolean myMatrixIsDiagonal = false;


    MatrixCalculator(Matrix matrix) throws MatrixCreateException {
        this.matrix = new Matrix(matrix.getA(), matrix.getB(), matrix.getSize());
    }


    void toTriangleForm() throws MatrixCreateException { //TODO:debug
        double[][] A = matrix.getA();
        double[] B = matrix.getB();
        int n = matrix.getSize();
        for (int i = 0; i < n; i++) {
            replaceLinesInMatrix(A, B, i, chooseMainEl(A, i));
            lineNormalization(A[i], A[i][i], B, i);
            for (int j = i + 1; j < n; j++) {
                lineSub(A[j], A[i], B, j, i, A[j][i]);
            }
        }
        this.matrix = new Matrix(A, B, n);
    }
    void fromTriangleToDiag() throws MatrixCreateException {
            double[][] A = matrix.getA();
            double[] B = matrix.getB();
            for (int i = matrix.getSize() - 1; i >= 0; i--) {
                for (int j= i -1; j>=0 ; j--) {
                    lineSub(A[j], A[i], B, j, i, A[j][i]);
                }
            }
            matrix = new Matrix(A, B, matrix.getSize());
        this.myMatrixIsDiagonal = true;
    }

    double calcDetFromDiag() throws TryCalculateNotDIagMatrixException, MatrixHasNoSolutionsException {
        if (myMatrixIsDiagonal){
            double det=1;
            for (int i=0; i< matrix.getSize(); i++) {
                det*=matrix.getA()[i][i];
            }
            if (det == 0) throw new MatrixHasNoSolutionsException();
            return det;
        } else {
            throw new TryCalculateNotDIagMatrixException();
        }
    }

    double[] calculateSolutionsFromDiag() throws TryCalculateNotDIagMatrixException {
        if (myMatrixIsDiagonal) {
            double[][] A = matrix.getA();
            double[] B = matrix.getB();
            double[] solutions = new double[matrix.getSize()];
            for (int i=0; i< matrix.getSize(); i++) {
                solutions[i] = B[i]/A[i][i];
            }
            return solutions;
        } else {
            throw new TryCalculateNotDIagMatrixException();
        }
    }

    double[] calcResidualFromOrigMatrixAndSolutions(Matrix matrix, double[] solutions) throws TryResidualWithCalculateSolutionsFromOtherMatrixException {
        if (matrix.getSize() == solutions.length) {
            double[] residual = new double[solutions.length];
            for (int i = 0; i < solutions.length; i++) {
                for (int j = 0; j < solutions.length; j++) {
                    residual[i] += matrix.getA()[i][j] * solutions[j];
                }
                residual[i] -= matrix.getB()[i];
            }
            return residual;
        } else {
            throw new TryResidualWithCalculateSolutionsFromOtherMatrixException();
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

    public Matrix getMatrix() {
        return matrix;
    }

    private void replaceLinesInMatrix(double[][] A, double[] B, int n1, int n2) {
        double b = B[n1];
        double[] a = A[n1];
        B[n1] = B[n2];
        B[n1] = b;
        A[n1] = A[n2];
        A[n2] = a;
    }

    private int chooseMainEl(double[][] A, int j) {
        int numberOfMainElLine = j;
        double maxEl = A[j][j];
        for (int i=j; i<A.length; i++) {
            if (A[i][j] > maxEl) {
                maxEl = A[i][j];
                numberOfMainElLine = i;
            }
        }
        return numberOfMainElLine;
    }
}
