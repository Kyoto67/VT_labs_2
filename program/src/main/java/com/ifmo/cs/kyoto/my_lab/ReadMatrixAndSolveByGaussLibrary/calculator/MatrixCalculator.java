package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.calculator;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity.Matrix;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixHasNoSolutionsException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryCalculateNotDIagMatrixException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryResidualWithCalculateSolutionsFromOtherMatrixException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.util.DoubleRounder;

public class MatrixCalculator {
    private Matrix matrix;
    private boolean myMatrixIsDiagonal = false;
    private boolean myMatrixIsTriangle = false;

    MatrixCalculator(Matrix matrix) throws MatrixCreateException {
        this.matrix = new Matrix(matrix.getA(), matrix.getB(), matrix.getSize());
    }


    void toTriangleForm() throws MatrixCreateException {
        double[][] A = matrix.getA();
        double[] B = matrix.getB();
        int n = matrix.getSize();
        for (int i = 0; i < n; i++) {
            replaceLinesInMatrix(A, B, i, chooseMainEl(A, i));
            for (int j = i + 1; j < n; j++) {
                lineSub(A, B, i, j);
            }
        }
        this.matrix = new Matrix(A, B, n);
        this.myMatrixIsTriangle = true;
    }

    void fromTriangleToDiag() throws MatrixCreateException {
        double[][] A = matrix.getA();
        double[] B = matrix.getB();
        for (int i = matrix.getSize() - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                lineSub(A, B, i, j);
            }
        }
        matrix = new Matrix(A, B, matrix.getSize());
        this.myMatrixIsDiagonal = true;
    }

    double calcDetFromTriangle() throws TryCalculateNotDIagMatrixException, MatrixHasNoSolutionsException {
        if (myMatrixIsTriangle) {
            double det = 1;
            for (int i = 0; i < matrix.getSize(); i++) {
                det *= matrix.getA()[i][i];
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
            for (int i = 0; i < matrix.getSize(); i++) {
                solutions[i] = B[i] / A[i][i];
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

    private void lineSub(double[][] A, double[] B, int i, int j) {
        if (A[i][i] == 0) return;
        double m = A[j][i]/A[i][i];
        for (int k = 0; k < A.length; k++) {
            A[j][k] -= DoubleRounder.roundDoubleForMatrix(A[i][k] * m);
        }
        B[j] -= DoubleRounder.roundDoubleForMatrix(B[i] * m);
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
        for (int i = j; i < A.length; i++) {
            if (A[i][j] > maxEl) {
                maxEl = A[i][j];
                numberOfMainElLine = i;
            }
        }
        return numberOfMainElLine;
    }
}
