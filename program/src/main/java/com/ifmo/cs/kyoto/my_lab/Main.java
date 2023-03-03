package com.ifmo.cs.kyoto.my_lab;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api.GetInfo;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api.Tester;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixCreateException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.MatrixHasNoSolutionsException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryCalculateNotDIagMatrixException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.exceptions.TryResidualWithCalculateSolutionsFromOtherMatrixException;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.util.GetInfoImpl;
import com.ifmo.cs.kyoto.my_lab.labrunner.MyLab;
import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.tester.TesterImpl;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("-test")) {
            Tester tester = new TesterImpl();
            try {
                tester.run();
            } catch (MatrixCreateException | TryCalculateNotDIagMatrixException | MatrixHasNoSolutionsException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            return;
        }
        if (args.length > 0 && args[0].equals("-man")) {
            GetInfo infach = new GetInfoImpl();
            infach.printManual();
            return;
        }
        try {
            new MyLab().start(args);
        } catch (MatrixCreateException | TryCalculateNotDIagMatrixException |
                 TryResidualWithCalculateSolutionsFromOtherMatrixException e) {
            System.out.println(e.getMessage());
        }
    }
}