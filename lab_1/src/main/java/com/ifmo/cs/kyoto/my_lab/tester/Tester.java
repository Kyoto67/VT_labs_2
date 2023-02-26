package com.ifmo.cs.kyoto.my_lab.tester;

import com.ifmo.cs.kyoto.my_lab.gauss_lib.api.MatrixCalulatorHandler;
import com.ifmo.cs.kyoto.my_lab.gauss_lib.src.MatrixCalculatorHandlerImpl;
import com.ifmo.cs.kyoto.my_lab.matrix_entity.Matrix;
import com.ifmo.cs.kyoto.my_lab.util.MatrixGenerator;
import com.ifmo.cs.kyoto.my_lab.util.MatrixGeneratorImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tester {


    Scanner in = new Scanner(System.in);
    MatrixGenerator matrixGenerator = new MatrixGeneratorImpl();

    public void run() {
        Matrix matrix;
        while (true) {
            System.out.print("Enter the dimensionality of the matrix: ");
            try {
                int size = in.nextInt();
                if (size <= 1 || size > 20) {
                    System.out.println("Enter an integer between 2 and 20.");
                    continue;
                }
                matrix = matrixGenerator.generate(size, true);
                MatrixCalulatorHandler matrixCalulatorHandler= new MatrixCalculatorHandlerImpl();
                double[] res = matrixCalulatorHandler.calculate(matrix);
                System.out.print("Answer: ");
                for (int i=0; i<res.length; i++) {
                    System.out.print("x" + i + " = " + res[i] + "\n\t\t");
                }
                return;
            } catch (InputMismatchException exception) {
                System.out.println("Incorrect input");
            }
        }
    }
}
