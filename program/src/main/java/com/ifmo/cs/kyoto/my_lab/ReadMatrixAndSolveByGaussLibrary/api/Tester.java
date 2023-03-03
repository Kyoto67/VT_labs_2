package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixHasNoSolutionsException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryCalculateNotDIagMatrixException;

public interface Tester {
    void run() throws MatrixCreateException, TryCalculateNotDIagMatrixException, MatrixHasNoSolutionsException;
}
