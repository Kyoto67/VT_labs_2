package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.util;

import java.text.DecimalFormat;

public class DoubleRounder {

    private static DecimalFormat innerFormat = new DecimalFormat("#.########");
    private static DecimalFormat outputFormat = new DecimalFormat("#.#");

    public static double roundDoubleForOutputFormat(double d) {
        String s = outputFormat.format(d);
        return Double.parseDouble(s);
    }

    public static double roundDoubleForMatrix(double d) {
        String s = innerFormat.format(d);
        return Double.parseDouble(s);
    }

    public static void roundAForMatrix(double[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                A[i][j] = roundDoubleForMatrix(A[i][j]);
            }
        }
    }

    public static void roundBForMatrix(double[] B) {
        for (int i = 0; i < B.length; i++) {
            B[i] = roundDoubleForMatrix(B[i]);
        }
    }

}
