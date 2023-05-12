#include <iostream>
#include <matplot/matplot.h>
#include <cmath>
#include <bitset>
#include <vector>

namespace mp = matplot;

typedef double fn_t(double x, double y);

double first_function(double x, double y) {
    return std::sin(x);
}

double second_function(double x, double y) {
    return (x * y) / 2;
}

double third_function(double x, double y) {
    return y - (2 * x) / y;
}

double fourth_function(double x, double y) {
    return x + y;
}

double default_function(double x, double y) {
    return 0.0;
}

fn_t &get_function(int n) {
    switch (n) {
        case 1:
            return first_function;
        case 2:
            return second_function;
        case 3:
            return third_function;
        case 4:
            return fourth_function;
        default:
            return default_function;
    }
}

std::vector<double> X;
std::vector<double> Y;

double solveByAdams(int f, double a, double y_a, double b) {
    fn_t &func = get_function(f);
    int n = 100;
    double h = (b - a) / n;
    X.resize(n + 1);
    X[0] = a;
    for (int i = 1; i <= n; i++) {
        X[i] = X[i - 1] + h;
    }

    Y.resize(n + 1);
    Y[0] = y_a;
    for (int i = 0; i < 4; i++) {
        double k1 = h * func(X[i], Y[0]);
        double k2 = h * func(X[i] + h / 2, Y[i] + k1 / 2);
        double k3 = h * func(X[i] + h / 2, Y[i] + k2 / 2);
        double k4 = h * func(X[i] + h, Y[i] + k3);
        Y[i + 1] = Y[i] + (k1 + 2 * k2 + 2 * k3 + k4) / 6;
    }
    for (int i = 4; i < n; i++) {
        double delta_f_1 = func(X[i], Y[i]);
        double delta_f_2 = func(X[i], Y[i]) - 2 * func(X[i - 1], Y[i - 1]) + func(X[i - 2], Y[i - 2]);
        double delta_f_3 =
                func(X[i], Y[i]) - 3 * func(X[i - 1], Y[i - 1]) + 3 * func(X[i - 2], Y[i - 2]) -
                func(X[i - 3], Y[i - 3]);
        Y[i + 1] = Y[i] + h * func(X[i], Y[i]) + std::pow(h, 2) / 2 * delta_f_1 +
                   std::pow(h, 3) * 5 / 12 * delta_f_2 + std::pow(h, 4) * 3 / 8 * delta_f_3;
    }
    return Y[n];
}

auto main() -> int {
    mp::hold(true);

    double a = 5;
    double b = 10;
    double y_a = 10;
    int f = 3;

    std::cout << "Начальное условие:" << std::endl
              << "Номер функции: " << f << std::endl
              << "Левая граница: " << a << std::endl
              << "Значение функции y в точке левой границы: " << y_a << std::endl
              << "Правая граница: " << b << std::endl;

    solveByAdams(f, a, y_a, b);

    auto scattered = mp::scatter(X, Y, 10);
    scattered->marker_face(true);

    mp::plot(X, Y, "-");

    mp::show();


    return 0;
}
