#include <iostream>
#include <matplot/matplot.h>
#include <cmath>
#include <bitset>
#include <vector>

namespace mp = matplot;

double a,b;

size_t approximate_linear_least_squares(const std::vector<double> &x_axis, const std::vector<double> &y_axis,
                                        std::vector<double> &P, std::vector<double> &x_new) {
    size_t n = x_axis.size();
    double sx = 0;
    double sxx = 0;
    double sy = 0;
    double sxy = 0;
    for (int i = 0; i < n; i++) {
        sx += x_axis.at(i);
        sxx += x_axis.at(i) * x_axis.at(i);
        sy += y_axis.at(i);
        sxy += x_axis.at(i) * y_axis.at(i);
    }
    a = (sxy * n - sx * sy) / (sxx * n - sx * sx);
    b = (sy - sx * a) / n;
    double worst_el = 0;
    size_t iter = 0;
    for (int i = 0; i < x_new.size(); i++) {
        double p = a * x_new[i] + b;
        P.push_back(p);
        if (i % 10 == 0) {
            double epsilon = std::abs(p - y_axis.at(i / 10));
            if (epsilon > worst_el) {
                iter = i;
                worst_el = epsilon;
            }
        }
    }
    return iter;
}


auto main() -> int {
    mp::hold(true);


//    std::vector<double> _x = {0, 0.5, 1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5, 5, 5.5, 6, 6.5, 7};
    std::vector<double> _x = {0, 0.5, 1, 1.5, 2, 2.5, 3};
    std::vector<double> _y(_x.size());
    for (size_t i = 0; i < _x.size(); i++) {
        _y[i] = _x[i] * _x[i] + std::rand() / RAND_MAX - 0.5;
    }
    std::vector<double> x_new = _x;
//    for (int i = 1; i < _x.size(); i++) {
//        double k = (_x[i] - _x[i - 1]) / 10;
//        for (size_t j = 0; j < 10; j++) {
//            x_new.push_back(_x[i - 1] + (k * j));
//        }
//    }
    std::vector<double> P;


    size_t iter = approximate_linear_least_squares(_x, _y, P, x_new);

    std::vector<double> _P = P;
    std::vector<double> _x_new = x_new;

    auto iterator_x = _x_new.begin();
    auto iterator_P = _P.begin();
    for (size_t i = 0; i < iter; i++) {
        iterator_x++;
        iterator_P++;
    }
    _x_new.erase(iterator_x);
    _P.erase(iterator_P);

    std::vector<double> P_new;
    std::vector<double> x_new_new = _x_new;

    approximate_linear_least_squares(_x_new, _P, P_new, x_new_new);

    auto scattered = mp::scatter(_x, _y, 10);
    scattered->marker_face(true);

    auto scattered_approx = mp::scatter(x_new, P, 10);
    scattered_approx->marker_face(true);

    std::cout << "a: " << a << " , b: " << b << std::endl;

    mp::show();

    auto scattered_approx_second = mp::scatter(x_new_new, P_new, 10);
    scattered_approx_second->marker_face(true);

    mp::show();

    std::cout << "a: " << a << " , b: " << b << std::endl;

//    mp::plot(_x, _y, "-");
    mp::plot(x_new, P, "-");
    mp::plot(x_new_new, P_new, "-");

    mp::show();


    return 0;
}
