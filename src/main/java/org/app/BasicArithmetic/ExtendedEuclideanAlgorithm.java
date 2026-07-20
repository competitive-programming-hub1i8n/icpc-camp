package org.app.BasicArithmetic;

public class ExtendedEuclideanAlgorithm {
    static int gcdExtended(int a, int b, int[] x, int[] y){
        // Base Case
        if (a == 0){ // GCD is b, x is 0, y is 1
            x[0] = 0;
            y[0] = 1;
            return b;
        }

        int[] x1 = {0}, y1 = {0};
        int gcd = gcdExtended(b % a, a, x1, y1);

        // Update x and y using results of
        // recursive call
        x[0] = y1[0] - (b / a) * x1[0];
        y[0] = x1[0];
        return gcd;
    }

    static int findGCD(int a, int b) {
        int[] x = {1}, y = {1};
        return gcdExtended(a, b, x, y);
    }
}
