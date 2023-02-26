package com.ifmo.cs.kyoto.my_lab.matrix_entity;

import lombok.Data;

@Data
public class Matrix {
    final double[][] A;
    final double [] B;
    final int size;
    boolean diagonal = false;
}
