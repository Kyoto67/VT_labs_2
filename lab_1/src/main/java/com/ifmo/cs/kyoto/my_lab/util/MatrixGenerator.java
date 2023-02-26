package com.ifmo.cs.kyoto.my_lab.util;

import com.ifmo.cs.kyoto.my_lab.matrix_entity.Matrix;

public interface MatrixGenerator {
    Matrix generate(int size);
    Matrix generate(int size, boolean testMode);
}
