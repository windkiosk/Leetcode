package com.leetcode.minimumpathsum;

/**
 * Created by titan-developer on 11/5/14.
 * https://oj.leetcode.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {

    public static void main(String[] strings) {
        int[][] a = {
                {1, 2, 1, 1},
                {2, 3, 3, 1},
                {1, 2, 1, 3},
        };


        MinimumPathSum pathSum = new MinimumPathSum();

        System.out.println(pathSum.minPathSum(a));
    }

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int w = 0; w < n; w++) {
            if (w == 0) {
                dp[0][w] = grid[0][w];
            } else {
                dp[0][w] = dp[0][w - 1] + grid[0][w];
            }
        }

        for (int h = 0; h < m; h++) {
            if (h == 0) {
                dp[h][0] = grid[h][0];
            } else {
                dp[h][0] = dp[h - 1][0] + grid[h][0];
            }
        }

        for (int i = 1; i < m; ++i)
            for (int j = 1; j < n; ++j)
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        return dp[m - 1][n - 1];
    }
}
