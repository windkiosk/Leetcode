package com.leetcode.spiralmatrix2;

/**
 * Created by titan-developer on 11/4/14.
 * https://oj.leetcode.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrix2 {

    public static void main(String[] strings) {
        SpiralMatrix2 matrix2 = new SpiralMatrix2();

        int[][] a = matrix2.generateMatrix(6);

        for (int[] v : a) {
            for (int x : v) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        if (n < 1) {
            return new int[0][0];
        }

        int[][] matrix = new int[n][n];

        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int orientation = 0; //0 -> right, 1 -> bottom, 2 -> left, 3 -> up.

        int i = 0, j = 0;

        int count = 1;
        while (true) {
            matrix[i][j] = count++;

            int tryTimes = 0;
            while (tryTimes < 2) {
                if (orientation == 0) {
                    if (j + 1 <= right) {
                        j++;
                        break;
                    } else {
                        top++;
                        orientation++;
                        tryTimes++;
                    }
                } else if (orientation == 1) {
                    if (i + 1 <= bottom) {
                        i++;
                        break;
                    } else {
                        right--;
                        orientation++;
                        tryTimes++;
                    }
                } else if (orientation == 2) {
                    if (j - 1 >= left) {
                        j--;
                        break;
                    } else {
                        bottom--;
                        orientation++;
                        tryTimes++;
                    }
                } else {
                    if (i - 1 >= top) {
                        i--;
                        break;
                    } else {
                        left++;
                        orientation = 0;
                        tryTimes++;
                    }
                }
            }

            if (tryTimes >= 2) {
                break;
            }
        }

        return matrix;
    }
}
