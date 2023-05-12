#include <iostream>
#include <matplot/matplot.h>
#include <cmath>
#include <vector>

namespace mp = matplot;

double a, b;

int random(int low, int high) {
    int rand = std::rand();
    return low + rand % (high - low + 1);
}

size_t approximate_linear_least_squares(const std::vector<double> &x_axis, const std::vector<double> &y_axis,
                                        std::vector<double> &F, std::vector<double> &x_new) {
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
        double f = a * x_new[i] + b;
        F.push_back(f);
        double epsilon = std::abs(f - y_axis.at(i));
        double p = epsilon/y_axis.at(i);
        if (p > worst_el) {
            iter = i;
            worst_el = p;
        }
    }
    return iter;
}


auto main() -> int {
    mp::hold(true);

//    std::vector<double> _x = {0, 0.5, 1, 1.5, 2, 2.5, 3, 3.5, 4, 4.5, 5, 5.5, 6, 6.5, 7};
    std::vector<double> _x = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1, 1.1, 1.2, 1.3, 1.4, 1.5};
    std::vector<double> _y(_x.size());
    for (size_t i = 0; i < _x.size(); i++) {
        double noise = ((double) (random(1, 1000) - 500)) / 1000;
        _y[i] = _x[i] * _x[i] + noise;
    }
    std::vector<double> x_new = _x;
    std::vector<double> F;


    size_t iter = approximate_linear_least_squares(_x, _y, F, x_new);

    std::vector<double> _F = F;
    std::vector<double> _x_new = x_new;

    auto iterator_x = _x.begin();
    auto iterator_F = _y.begin();
    for (size_t i = 0; i < iter; i++) {
        iterator_x++;
        iterator_F++;
    }
    _x.erase(iterator_x);
    _y.erase(iterator_F);

    std::vector<double> F_new;
    std::vector<double> x_new_new = _x;

    approximate_linear_least_squares(_x, _y, F_new, x_new_new);

    auto scattered = mp::scatter(_x, _y, 10);
    scattered->marker_face(true);

    auto scattered_approx = mp::scatter(x_new, F, 10);
    scattered_approx->marker_face(true);

    std::cout << "a: " << a << " , b: " << b << std::endl;

    mp::show();

    auto scattered_approx_second = mp::scatter(x_new_new, F_new, 10);
    scattered_approx_second->marker_face(true);

    mp::show();

    std::cout << "a: " << a << " , b: " << b << std::endl;

    mp::plot(x_new, F, "-");
    mp::plot(x_new_new, F_new, "-");

    mp::show();


    return 0;
}
