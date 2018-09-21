package com.leetcode.singlenumber;

/**
 *
 * https://oj.leetcode.com/problems/single-number/
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p/>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    public int singleNumber(int[] A) {

        if (A == null || A.length < 1) {
            return 0;
        }

        int single = A[0];
        for (int i = 1; i < A.length; i++) {
            single ^= A[i];

        }
        return single;
    }
}