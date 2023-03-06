package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.util;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api.Printer;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.entity.Matrix;

public class PrinterImpl implements Printer {
    @Override
    public void printRoots(double[] roots) {
    System.out.print("Answer: ");
        for (int i=0; i<roots.length; i++) {
            System.out.print("x" + (i+1) + " = " + roots[i] + "\n\t\t");
        }
    }

    @Override
    public void printDet(double det) {
        System.out.println("Determinant: " + det + "\n");
    }

    @Override
    public void printResidual(double[] residual) {
        System.out.println("Residual: ");
        for ( int i=0; i< residual.length; i++) {
            System.out.println("\t\tr"+(i+1)+" = " + residual[i]);
        }
        System.out.println();
    }

    @Override
    public void printMatrix(Matrix matrix) {
        System.out.println("Matrix:");
        double[][] A = matrix.getA();
        double[] B = matrix.getB();
        for (int i=0; i<matrix.getSize(); i++) {
            System.out.print("\t\t");
            for (int j=0; j< matrix.getSize(); j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println("| " + B[i]);
        }
        System.out.println();
    }

    @Override
    public void printForTriangledMatrix(Matrix matrix) {
        System.out.println("Triangled matrix:");
        double[][] A = matrix.getA();
        double[] B = matrix.getB();
        for (int i=0; i<matrix.getSize(); i++) {
            System.out.print("\t\t");
            for (int j=0; j< matrix.getSize(); j++) {
                System.out.print(DoubleRounder.roundDoubleForOutputFormat(A[i][j]) + " ");
            }
            System.out.println("| " + DoubleRounder.roundDoubleForOutputFormat(B[i]));
        }
        System.out.println();
    }

    @Override
    public void printSolutionCheck(Matrix matrix, double[] roots) {
        System.out.println("Check my solutions: ");
        for (int i=0; i<matrix.getSize(); i++) {
            double b=0;
            for (int j=0; j<matrix.getSize(); j++) {
                b+=matrix.getA()[i][j]*roots[j];
            }
            System.out.print("My b: " + b + " == Original b: " + matrix.getB()[i] + " ? ");
            System.out.println(b==matrix.getB()[i]);
        }
        System.out.println();
    }
}
