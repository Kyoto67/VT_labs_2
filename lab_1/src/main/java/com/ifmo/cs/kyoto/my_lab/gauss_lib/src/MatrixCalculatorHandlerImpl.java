package com.ifmo.cs.kyoto.my_lab.gauss_lib.src;

import com.ifmo.cs.kyoto.my_lab.gauss_lib.api.MatrixCalulatorHandler;
import com.ifmo.cs.kyoto.my_lab.matrix_entity.Matrix;

public class MatrixCalculatorHandlerImpl implements MatrixCalulatorHandler {
    @Override
    public double[] calculate(Matrix m) {
        MatrixCalculator calc = new MatrixCalculator(m);
        calc.toDiagonalForm();
        calc.reverseAlgorithm();
        return calc.getSolution();
    }
}
