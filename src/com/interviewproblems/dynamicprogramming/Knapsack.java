package com.interviewproblems.dynamicprogramming;

/**
 * Created by bod on 8/23/14.
 */
public class Knapsack {
    static int[][] diamonds = new int[][]{
            {2, 10},
            {3, 7},
            {4, 1},
            {5, 4},
            {8, 2},
            {6, 8},
            {1, 3},
            {5, 6},
            {9, 8},
    };


    public static void main(String[] strings) {
        Knapsack knapsack = new Knapsack();
        int value = knapsack.backPackSolution(diamonds, 7);
        System.out.println(value);
    }

    public int backPackSolution(int[][] diamonds, int packSize) {
        if (packSize == 0 || diamonds == null || diamonds.length == 0) {
            return 0;
        }

        int[][] m = new int[diamonds.length + 1][packSize + 1];

        for (int j = 0; j <= packSize; j++) {
            m[0][j] = 0;
        }

        for (int i = 1; i < m.length; i++) {
            for (int j = 0; j <= packSize; j++) {
                if (diamonds[i - 1][0] < j) {
                    m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - diamonds[i - 1][0]] + diamonds[i - 1][1]);
                } else {
                    m[i][j] = m[i - 1][j];
                }
            }
        }

        return m[diamonds.length][packSize];
    }
}
