package com.leetcode.sudokuvalidator;

/**
 * Created by titan-developer on 10/25/14.
 * https://oj.leetcode.com/problems/valid-sudoku/
 */
public class SudokuValidator {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            int[] count1 = new int[9];
            int[] count2 = new int[9];
            int[] count3 = new int[9];

            for (int j = 0; j < 9; ++j) {

                //row
                if (board[i][j] != '.') {
                    int num1 = board[i][j] - '1';
                    if (count1[num1] != 0)
                        return false;
                    else
                        count1[num1] = 1;
                }

                //column
                if (board[j][i] != '.') {
                    int num2 = board[j][i] - '1';
                    if (count2[num2] != 0)
                        return false;
                    else
                        count2[num2] = 1;
                }

                //block
                if (board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] != '.') {
                    int num3 = board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] - '1';
                    if (count3[num3] != 0)
                        return false;
                    else
                        count3[num3] = 1;
                }
            }
        }
        return true;
    }
}
