package com.lintcode.maxsubarrayIII;

import java.util.*;

/**
 * Created by titan-developer on 12/11/14.
 * http://lintcode.com/en/problem/maximum-subarray-iii
 */
public class MaxSubarrayIII {

    public static void main(String[] strings) {
        int[] a = {-1, 4, -2, 3, -2, 3};
        MaxSubarrayIII maxSubarrayIII = new MaxSubarrayIII();

        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int v : a) nums.add(v);

        System.out.println(maxSubarrayIII.maxSubArray(nums, 3));
    }

    public int maxSubArray(ArrayList<Integer> nums, int k) {
        int[][] maxs = new int[nums.size()][nums.size()];

        for (int i = 0; i < nums.size(); ++i) {
            int max_till = nums.get(i);
            maxs[i][i] = max_till;
            for (int j = i + 1; j < nums.size(); ++j) {
                max_till = Math.max(nums.get(j), max_till + nums.get(j));
                maxs[i][j] = Math.max(maxs[i][j - 1], max_till);
            }
        }

        int[] dp = maxs[0];
        for (int m = 1; m < k; ++m) {
            int[] pre = new int[dp.length];
            for (int i = m; i < nums.size(); ++i) {
                int max_i = Integer.MIN_VALUE;
                for (int j = m - 1; j < i; ++j) {
                    max_i = Math.max(max_i, dp[j] + maxs[j + 1][i]);
                }
                pre[i] = max_i;
            }
            dp = pre;
        }
        return dp[dp.length - 1];
    }
}
