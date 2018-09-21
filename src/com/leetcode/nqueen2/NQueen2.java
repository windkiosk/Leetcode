package com.leetcode.nqueen2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 10/28/14.
 https://oj.leetcode.com/problems/n-queens-ii/
 */
public class NQueen2 {

    public static void main(String[] strings) {

        NQueen2 nQueen2 = new NQueen2();
        System.out.println(nQueen2.totalNQueens(4));
    }

    public int totalNQueens(int n) {
        if (n == 1) {
            return 1;
        } else if (n < 4) {
            return 0;
        }

        boolean[][] board = new boolean[n][n];

        List<Integer> integers = new ArrayList<Integer>();

        scanBoard(integers, board, 0);

        return integers.size();
    }

    private boolean scanBoard(List<Integer> integers, boolean[][] board, int col) {
        int size = board.length;
        if (col >= size) {
            integers.add(0);
            return true;
        }

        boolean isSucc = false;

        //try to put on each row
        for (int i = 0; i < size; i++) {
            if (checkQueensLeftSide(board, i, col)) {
                board[i][col] = true;
                if (scanBoard(integers, board, col + 1))
                    isSucc = true;
                board[i][col] = false;
            }
        }

        return isSucc;
    }

    protected boolean checkQueensLeftSide(boolean[][] board, int row, int col) {
        int size = board.length;

        /* Check this row on left side */
        for (int i = 0; i < col; i++) {
            if (board[row][i])
                return false;
        }

        /* Check upper diagonal on left side */
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j])
                return false;
        }

        /* Check lower diagonal on left side */
        for (int i = row, j = col; j >= 0 && i < size; i++, j--) {
            if (board[i][j])
                return false;
        }

        return true;
    }
}
