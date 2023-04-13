package com.ifmo.cs.kyoto.my_lab.util;

import com.ifmo.cs.kyoto.my_lab.api.Asker;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AskerRealization implements Asker {

    Scanner in;

    public AskerRealization() {
        in = new Scanner(System.in);
    }

    private int readNumberFromRange(int begin, int end) {
        while (true) {
            try {
                int number = in.nextInt();
                if (number < begin || number > end) {
                    System.out.println("Enter an integer between " + begin + " and " + end + ".");
                    continue;
                }
                return number;
            } catch (InputMismatchException exception) {
                System.out.println("Incorrect input.");
            }
        }
    }

    private int readEvenNumber() {
        while (true) {
            try {
                int number = in.nextInt();
                if (number % 2 != 0 ) {
                    System.out.println("Enter an even integer number.");
                    continue;
                }
                return number;
            } catch (InputMismatchException exception) {
                System.out.println("Incorrect input.");
            }
        }
    }

    private double readDecimal() {
        while (true) {
            try {
                return in.nextDouble();
            } catch (InputMismatchException exception) {
                System.out.println("Incorrect input.");
            }
        }
    }

    private double readDecimalGreaterThan(double begin) {
        while (true) {
            try {
                double number = in.nextDouble();
                if (number < begin) {
                    System.out.println("The area of the function definition does not allow you to integrate the selected area. (Greater or equals than " + begin + ")");
                    continue;
                }
                return number;
            } catch (InputMismatchException exception) {
                System.out.println("Incorrect input.");
            }
        }
    }

    private double readDecimalLessThan(double end) {
        while (true) {
            try {
                double number = in.nextDouble();
                if (number > end) {
                    System.out.println("The area of the function definition does not allow you to integrate the selected area. (Less or equals than " + end + ")");
                    continue;
                }
                return number;
            } catch (InputMismatchException exception) {
                System.out.println("Incorrect input.");
            }
        }
    }

    @Override
    public double askAccuracy() {
        System.out.print("Set the accuracy of calculations: ");
        return readDecimal();
    }

    @Override
    public Function askWhichFunction() {
        Function result = null;
        System.out.println("Choose the function that you want to integrate:");
        System.out.println("1. f(x) = x²");
        System.out.println("2. f(x) = sin(x)/x");
        System.out.println("3. f(x) = 1000x - 7");
        System.out.println("4. f(x) = sqrt(x)");
        switch (readNumberFromRange(1, 4)) {
            case 1 -> {
                result = Function.FIRST;
                break;
            }
            case 2 -> {
                result = Function.SECOND;
                break;
            }
            case 3 -> {
                result = Function.THIRD;
                break;
            }
            case 4 -> {
                result = Function.FOURTH;
                break;
            }
        }
        return result;
    }

    @Override
    public double askLeftIntegrationBoundary() {
        System.out.print("Enter the left boundary of the integration: ");
        return readDecimal();
    }

    @Override
    public double askLeftIntegrationBoundary(double border) {
        System.out.print("Enter the left boundary of the integration: ");
        return readDecimalGreaterThan(border);
    }

    @Override
    public double askRightIntegrationBoundary() {
        System.out.print("Enter the right boundary of the integration: ");
        return readDecimal();
    }

    @Override
    public double askRightIntegrationBoundary(double border) {
        System.out.print("Enter the right boundary of the integration: ");
        return readDecimalLessThan(border);
    }
}
