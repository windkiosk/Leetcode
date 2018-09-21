package com.leetcode.search2dmatrix;

/**
 * Created by titan-developer on 11/7/14.
 * https://oj.leetcode.com/problems/search-a-2d-matrix/
 */
public class Search2DMatrix {

    public static void main(String[] strings) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };

        Search2DMatrix search = new Search2DMatrix();
        System.out.println(search.searchMatrix(matrix, 50));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean hasValue = false;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return hasValue;
        }

        int result[] = new int[1];
        boolean isFind = findRow(matrix, target, result);
        if (isFind) {
            return true;
        } else {
            if (result[0] >= 0) {
                int column = findColumn(matrix, result[0], target);
                hasValue = column >= 0;
            } else {
                return false;
            }
        }

        return hasValue;
    }

    private int findColumn(int[][] matrix, int row, int target) {
        int start = 0, end = matrix[row].length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (matrix[row][middle] == target) {
                return middle;
            } else if (matrix[row][middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return -1;
    }

    private boolean findRow(int[][] matrix, int target, int[] result) {
        int start = 0, end = matrix.length - 1;
        int l = matrix[0].length;

        while (start <= end) {
            int middle = (start + end) / 2;

            if (matrix[middle][0] == target) {
                return true;
            } else if (matrix[middle][0] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        if (start >= matrix.length)
            start = matrix.length - 1;

        if (matrix[start][0] > target) {
            if (start == 0) {
                result[0] = -1;
            } else {
                if (matrix[start - 1][l - 1] >= target)
                    result[0] = start - 1;
                else
                    result[0] = -1;
            }
        } else {
            if (matrix[start][l - 1] >= target) {
                result[0] = start;
            } else {
                result[0] = -1;
            }
        }

        return false;
    }
}
