package com.leetcode.powimpl;

/**
 * Created by titan-developer on 11/3/14.
 * https://oj.leetcode.com/problems/powx-n/
 */
public class Pow {

    public static void main(String[] strings) {
        Pow pow = new Pow();
        System.out.println(pow.pow(2.0d, - 2));
        pow.power(2, 7);
    }

    public double pow(double x, int m) {
        double temp = x;
        if (m == 0)
            return 1;
        temp = pow(x, m / 2);
        if (m % 2 == 0)
            return temp * temp;
        else {
            if (m > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }

    double power(double x, int n) {
        double result = 1;
        while(n > 0) {
            if((n & 1) > 0)
                result *= x;
            x *= x;
            n >>= 1;
        }
        return result;
    }

}
