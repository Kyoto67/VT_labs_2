package com.kyoto.alaba3.mbeans;

import java.beans.JavaBean;
import java.lang.annotation.Annotation;

public class MyMXBean implements JavaBean {
    @Override
    public String description() {
        return null;
    }

    @Override
    public String defaultProperty() {
        return null;
    }

    @Override
    public String defaultEventSet() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
