package com.leetcode.trailingzeros;

/**
 * Created by titan-developer on 12/30/14.
 * https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 */
public class TrailingZeros {

    public int trailingZeroes(int n) {
        int result = 0;
        for (int i = 5; n / i > 0; i *= 5) {
            result += (n / i);
        }
        return result;
    }
}
