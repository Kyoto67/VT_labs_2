package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions;

public class TryResidualWithCalculateSolutionsFromOtherMatrixException extends Exception{
   public TryResidualWithCalculateSolutionsFromOtherMatrixException() {
       super("The solutions that you passed on are from another matrix");
   }
}
