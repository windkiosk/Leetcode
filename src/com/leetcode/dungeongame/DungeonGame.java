package com.leetcode.dungeongame;

/**
 * Created by bod on 1/7/2015.
 * https://oj.leetcode.com/problems/dungeon-game/
 */
public class DungeonGame {

    public static void main(String[] strings) {

        int[][] a = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5},

        };

        DungeonGame testPractise = new DungeonGame();
        System.out.println(testPractise.calculateMinimumHP(a));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return -1;
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 1 : 1 - dungeon[m - 1][n - 1];
        for (int i = m - 1; i >= 0; i --)
            for (int j = n - 1; j >= 0; j --) {
                if (i == m - 1 && j == n - 1)
                    continue;
                else if ( i == m - 1) {
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                } else if (j == n - 1) {
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else {
                    int v = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.max(1, v - dungeon[i][j]);
                }
            }
        return dp[0][0];
    }
}
