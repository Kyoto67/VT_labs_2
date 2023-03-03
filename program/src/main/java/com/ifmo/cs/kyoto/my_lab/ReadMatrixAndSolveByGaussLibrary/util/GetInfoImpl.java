package com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.util;

import com.ifmo.cs.kyoto.my_lab.ReadMatrixAndSolveByGaussLibrary.api.GetInfo;

public class GetInfoImpl implements GetInfo {
    @Override
    public void printManual() {
        System.out.println("My program counts the roots of systems of equations from 2 to 20. To interact, enter the coefficients of the equations as a square matrix in the format:\n" +
                "<size>.\n" +
                "<a_1,1> ... <a_1,n> <b_1>\n" +
                ".\n" +
                ".\n" +
                ".\n" +
                "<a_n,1> ... <a_n,n> <b_n>\n" +
                "The input can be done either manually or from a file.\n" +
                "To read a matrix from a file, run the program by passing the relative path to the file as an argument:\n" +
                "prog.jar <filepath>\n" +
                "\n" +
                "To run the program in test mode, start it with the key \"-test\":\n" +
                "prog.jar -test\n" +
                "\n" +
                "\n" +
                "\n" +
                "-------------------------------------------------------------------" +
                "\n" +
                "\n" +
                "\n" +
                "Моя программа считает корни систем уравнения от 2 до 20. Для взаимодействия введите коэффициенты уравнений в виде квадратной матрицы в формате:\n" +
                "\t<size>\n" +
                "\t<a_1,1> ... <a_1,n> <b_1>\n" +
                "\t.\n" +
                "\t.\n" +
                "\t.\n" +
                "\t<a_n,1> ... <a_n,n> <b_n>\n" +
                "Ввод можно осуществлять как вручную, так и из файла.\n" +
                "Для чтения матрицы из файла запустите программу, передав ей в качестве аргумента относительный путь к файлу:\n" +
                "\tprog.jar <filepath>\n" +
                "\n" +
                "Для запуска программы в тестовом режиме, запустите её с ключом \"-test\":\n" +
                "\tprog.jar -test");
    }
}
