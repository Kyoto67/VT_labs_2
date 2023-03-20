package com.ifmo.cs.kyoto.my_lab.entity;

import com.ifmo.cs.kyoto.my_lab.api.SecondOrderFunction;

class SecondOrderSystem {
    SecondOrderFunction f;
    SecondOrderFunction g;
     public SecondOrderSystem(SecondOrderFunction f, SecondOrderFunction g) {
         this.f = f;
         this.g = f;
     }

     double calcApproximation(double x, double x1) {

     }

}