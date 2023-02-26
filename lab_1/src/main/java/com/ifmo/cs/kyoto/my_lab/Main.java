package com.ifmo.cs.kyoto.my_lab;

import com.ifmo.cs.kyoto.my_lab.labrunner.MyLab;
import com.ifmo.cs.kyoto.my_lab.tester.Tester;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("-test")) {
            new Tester().run();
            return;
        }
        if (args.length > 0 && args[0].equals("-man")) {
            //pass
        }
        new MyLab().start(args);
    }
}