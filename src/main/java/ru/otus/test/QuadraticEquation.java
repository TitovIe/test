package ru.otus.test;

import java.util.Arrays;

import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public double[] solve(double a, double b, double c, double e) {
        checkArguments(a, b, c);
        if (Math.abs(a) < e)
            throw new IllegalArgumentException("a doesn't equal 0");
        double D = b * b - 4 * a * c;
        if (!(D < 0)) {
            if (D < e) {
                double root = -b / (2 * a);
                return new double[]{root, root};
            } else {
                double root1 = -b + sqrt(D) / (2 * a), root2 = -b - sqrt(D) / (2 * a);
                return new double[]{root1, root2};
            }
        }
        return new double[0];
    }

    private void checkArguments(double... arguments) {
        Arrays.stream(arguments).forEach(argument -> {
            if (Double.isNaN(argument) || Double.isInfinite(argument))
                throw new IllegalArgumentException("Аргумент не может быть Nan или Infinity");
        });
    }
}
