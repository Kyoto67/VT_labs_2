package com.ifmo.cs.kyoto.my_lab;

import com.ifmo.cs.kyoto.my_lab.gauss_lib.src.MatrixCalculatorHandlerImpl;
import com.ifmo.cs.kyoto.my_lab.gauss_lib.api.MatrixCalulatorHandler;
import com.ifmo.cs.kyoto.my_lab.matrix_entity.Matrix;

public class Main_test {
    public static void main(String[] args) {
        double[][] A = {{6.0,-2.0,1.0},{1.0,-1.0,6.0},{2.0,3.0,-1.0}};
        double[] B = {11.0,14.0,7.0};
        int size = 3;
        Matrix testMatrix = new Matrix(A,B, size);
        MatrixCalulatorHandler handler = new MatrixCalculatorHandlerImpl();
        double[] res = handler.calculate(testMatrix);
        for (int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
        A = new double[][]{{6.0, -2.0, 1.0}, {1.0, -1.0, 6.0}, {2.0, 3.0, -1.0}};
        B = new double[]{11.0, 14.0, 7.0};
        for (int i=0; i<size; i++) {
            System.out.print(A[i][0]);
            System.out.print("*");
            System.out.print(res[0]);
            System.out.print(" + ");
            System.out.print(A[i][1]);
            System.out.print("*");
            System.out.print(res[1]);
            System.out.print(" + ");
            System.out.print(A[i][2]);
            System.out.print("*");
            System.out.print(res[2]);
            System.out.print(" = ");
            System.out.print(B[i]);
            System.out.print(" : ");
            System.out.println(Math.round(A[i][0]*res[0]+A[i][1]*res[1]+A[i][2]*res[2])==B[i]);
        }
        System.out.println(testMatrix);
    }
}