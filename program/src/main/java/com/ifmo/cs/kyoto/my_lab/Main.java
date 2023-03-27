package com.ifmo.cs.kyoto.my_lab;

import com.ifmo.cs.kyoto.my_lab.LabRunner.MyLabRunner;

public class Main {
    public static void main(String[] args) {
        try {
            new MyLabRunner().run();
        } catch (Exception e) {
            System.out.println("An error occurred during program execution:");
            System.out.println(e.getMessage());
        }
    }
}