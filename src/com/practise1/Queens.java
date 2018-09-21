package com.practise1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/24/14.
 */
public class Queens {

    int count = 0;

    public static void main(String[] strings) {
        Queens queens = new Queens();
        queens.getSolution(4);
        System.out.println(queens.count);
    }

    public List<String[]> getSolution(int n) {
        List<String[]> result = new ArrayList<String[]>();

        boolean[][] matrix = new boolean[n][n];

        scanboard(matrix, 0);

        return result;
    }

    private boolean scanboard(boolean[][] matrix, int row) {
        int n = matrix.length;
        if (row >= n) {
            count ++;
            return true;
        }

        boolean isSucc = false;

        for (int i = 0; i < n; i ++) {
            if (checkQueens(matrix, row, i)) {
                matrix[row][i] = true;
                if (scanboard(matrix, row + 1)) {
                    isSucc = true;
                }
                matrix[row][i] = false;
            }
        }

        return isSucc;
    }

    private boolean checkQueens(boolean[][] matrix, int row, int col) {

        //check left of the row
        for (int i = 0; i < col; i ++) {
            if (matrix[row][i]) {
                return false;
            }
        }

        //check above elements in col
        for (int i = 0; i < row; i ++) {
            if (matrix[i][col]) {
                return false;
            }
        }

        //check diagonal left above
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i --, j --) {
            if (matrix[i][j]) {
                return false;
            }
        }

        //check diagonal right above
        for (int i = row - 1, j = col + 1; i >= 0 && j < matrix.length; i --, j ++) {
            if (matrix[i][j]) {
                return false;
            }
        }

        return true;
    }
}
