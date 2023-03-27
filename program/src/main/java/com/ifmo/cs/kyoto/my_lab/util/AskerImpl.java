package com.ifmo.cs.kyoto.my_lab.util;

import com.ifmo.cs.kyoto.my_lab.api.Asker;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AskerImpl implements Asker {

    Scanner in;

    public AskerImpl() {
        in = new Scanner(System.in);
    }

    private int readNumberFromRange(int begin, int end) {
        while (true) {
            try {
                int size = in.nextInt();
                if (size < begin || size > end) {
                    System.out.println("Enter an integer between " + begin + " and " + end + ".");
                    continue;
                }
                return size;
            } catch (InputMismatchException exception) {
                System.out.println("Incorrect input.");
            }
        }
    }

    @Override
    public int askEquationOrNSAE() {
        System.out.print("Enter \"1\" to solve the equation, enter \"2\" for NSAE: ");
        return readNumberFromRange(1, 2);
    }

    @Override
    public int askWhichEquation() {
        System.out.println("Choose the equation that you want to solve:");
        System.out.println("1. f(x) = sin(x)");
        System.out.println("2. f(x) = cos(x)");
        System.out.println("3. f(x) = x² - 1");
        System.out.println("4. f(x) = x³ - x + 4");
        System.out.println("5. f(n) = 2ⁿ - 1");
        return readNumberFromRange(1, 5);
    }

    @Override
    public int askWhichNSAE() {
        System.out.println("Choose the NSAE that you want to solve:");
        System.out.println("1.  x² + y² - 4 = 0");
        System.out.println("    -3x² + y = 0\n");
        System.out.println("2.  cos(x) - y = 0");
        System.out.println("    sin(y) - x = 0");
        return readNumberFromRange(1, 2);
    }
}
