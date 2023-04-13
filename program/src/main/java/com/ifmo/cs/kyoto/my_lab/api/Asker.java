package com.ifmo.cs.kyoto.my_lab.api;

import com.ifmo.cs.kyoto.my_lab.util.Function;

public interface Asker {
    double askAccuracy();

    Function askWhichFunction();

    double askLeftIntegrationBoundary();
    double askLeftIntegrationBoundary(double border);
    double askRightIntegrationBoundary();
    double askRightIntegrationBoundary(double border);
}
