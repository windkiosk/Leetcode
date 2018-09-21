package com.leetcode.climbstairs;

/**
 * Created by titan-developer on 10/30/14.
 * https://oj.leetcode.com/problems/climbing-stairs/
 */
public class ClimbStairs {

    public static void main(String[] strings) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(4));
    }

    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int[] steps = new int[n + 1];
        steps[0] = 1;
        steps[1] = 1;

        for (int i = 2; i <= n; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }

        return steps[n];
    }
}
