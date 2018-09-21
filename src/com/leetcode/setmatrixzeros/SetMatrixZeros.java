package com.leetcode.setmatrixzeros;

/**
 * Created by titan-developer on 11/7/14.
 * https://oj.leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeros {

    public static void main(String[] strings) {

        int[][] a = {
                {1, 1, 1, 0, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 1},
                {0, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 1},
        };

        for (int[] v : a) {
            for (int x : v) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }

        System.out.println("--------");

        SetMatrixZeros seter = new SetMatrixZeros();
        seter.setZeroes(a);

        for (int[] v : a) {
            for (int x : v) {
                System.out.print(x + ", ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        int rownum = matrix.length;
        if (rownum == 0)  return;
        int colnum = matrix[0].length;
        if (colnum == 0)  return;

        boolean hasZeroFirstRow = false, hasZeroFirstColumn = false;

        // Does first row have zero?
        for (int j = 0; j < colnum; ++j) {
            if (matrix[0][j] == 0) {
                hasZeroFirstRow = true;
                break;
            }
        }

        // Does first column have zero?
        for (int i = 0; i < rownum; ++i) {
            if (matrix[i][0] == 0) {
                hasZeroFirstColumn = true;
                break;
            }
        }

        // find zeroes and store the info in first row and column
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // set zeroes except the first row and column
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[0].length; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)  matrix[i][j] = 0;
            }
        }

        // set zeroes for first row and column if needed
        if (hasZeroFirstRow) {
            for (int j = 0; j < colnum; ++j) {
                matrix[0][j] = 0;
            }
        }
        if (hasZeroFirstColumn) {
            for (int i = 0; i < rownum; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}
