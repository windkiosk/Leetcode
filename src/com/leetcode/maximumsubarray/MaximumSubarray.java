package com.leetcode.maximumsubarray;

/**
 * Created by bod on 1/24/15.
 * https://oj.leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) return 0;

        int ret = Integer.MIN_VALUE, curr = 0;
        for (int v : A) {
            if (curr <= 0)
                curr = v;
            else
                curr += v;

            if (curr > ret) ret = curr;
        }
        return ret;
    }
}
