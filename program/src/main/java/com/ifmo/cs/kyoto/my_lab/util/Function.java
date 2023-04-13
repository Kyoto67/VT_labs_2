package com.ifmo.cs.kyoto.my_lab.util;

import com.ifmo.cs.kyoto.my_lab.api.SimpleFunction;
import lombok.Getter;

@Getter
public enum Function {

    FIRST (x -> Math.pow(x, 2)),
    SECOND(x -> Math.sin(x)/x),
    THIRD(x -> x*14 + 88),
    FOURTH(Math::sqrt);

    private SimpleFunction function;

    Function(SimpleFunction function) {
        this.function = function;
    }

}
