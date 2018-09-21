package com.interviewproblems.greatestdivisor;

/**
 * Created by bod on 8/4/14.
 */
public class GreatestCommonDivisor {

    public static void main(String[] strings) {
        GreatestCommonDivisor devisor = new GreatestCommonDivisor();
        int greatestCommonDevisor = devisor.getGreatestCommonDevisor(15, 33);
        System.out.println(greatestCommonDevisor);
    }

    public int getGreatestCommonDevisor(int m, int n) {
        if (m <= 0 || n <= 0) {
            return -1;
        }

        int r = m % n;
        while (r > 0) {
            m = n;
            n = r;
            r = m % n;
        }

        return n;
    }
}
