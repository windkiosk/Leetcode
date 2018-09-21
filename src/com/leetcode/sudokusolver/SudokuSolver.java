package com.leetcode.sudokusolver;

/**
 * Created by titan-developer on 10/25/14.
 * https://oj.leetcode.com/problems/sudoku-solver/
 * <p/>
 * Solution:
 * http://www.cnblogs.com/easonliu/p/3662904.html
 */
public class SudokuSolver {

    public static void main(String[] strings) {
        String[] input =
                {
                        "..9748...",
                        "7........",
                        ".2.1.9...",
                        "..7...24.",
                        ".64.1.59.",
                        ".98...3..",
                        "...8.3.2.",
                        "........6",
                        "...2759.."
                };

        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                board[i][j] = input[i].charAt(j);
            }
        }

        SudokuSolver slover = new SudokuSolver();
        slover.solveSudoku(board);

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        scan(board, 0);
    }

    private boolean check(char[][] board, int pos) {
        int i = pos / 9;
        int j = pos % 9;

        //check row
        for (int m = 0; m < 9; m++) {
            if (m != j && board[i][m] == board[i][j]) {
                return false;
            }
        }

        //check column
        for (int m = 0; m < 9; m++) {
            if (m != i && board[m][j] == board[i][j]) {
                return false;
            }
        }

        //check block
        int left = i / 3 * 3;
        int top = j / 3 * 3;

        for (int m = left; m < left + 3; m++) {
            for (int n = top; n < top + 3; n++) {
                if ((m != i || n != j) && board[m][n] == board[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean scan(char[][] board, int pos) {
        if (pos == 81) {
            return true;
        }

        int i = pos / 9;
        int j = pos % 9;

        if (board[i][j] == '.') {
            for (int m = 0; m < 9; m++) {
                board[i][j] = (char) (m + '1');
                if (check(board, pos) && scan(board, pos + 1))
                    return true;
                board[i][j] = '.';
            }
        } else {
            return scan(board, pos + 1);
        }

        return false;
    }


}
