package com.ifmo.cs.kyoto.my_lab.labrunner;

import com.ifmo.cs.kyoto.my_lab.gauss_lib.api.MatrixCalulatorHandler;
import com.ifmo.cs.kyoto.my_lab.gauss_lib.src.MatrixCalculatorHandlerImpl;
import com.ifmo.cs.kyoto.my_lab.matrix_entity.Matrix;
import com.ifmo.cs.kyoto.my_lab.matrix_read_lib.api.Reader;
import com.ifmo.cs.kyoto.my_lab.matrix_read_lib.src.ReaderMatrixFromConsole;
import com.ifmo.cs.kyoto.my_lab.matrix_read_lib.src.ReaderMatrixFromFile;

public class MyLab {
    Reader reader;
    Matrix matrix;
    MatrixCalulatorHandler matrixCalulatorHandler;

    public void start(String[] args) {
        if (args.length != 0) {
            reader = new ReaderMatrixFromFile(args[0]);
        } else {
            reader = new ReaderMatrixFromConsole();
        }
        while (matrix == null) {
            try {
                matrix = reader.read();
            } catch (Exception e) {
                System.out.println("Произошла ошибка при чтении матрицы:");
                e.printStackTrace();
                return;
            }
        }
        matrixCalulatorHandler= new MatrixCalculatorHandlerImpl();
        double[] res = matrixCalulatorHandler.calculate(matrix);
        System.out.print("Answer: ");
        for (int i=0; i<res.length; i++) {
            System.out.print("x" + i + " = " + res[i] + "\n\t\t");
        }
    }
}
