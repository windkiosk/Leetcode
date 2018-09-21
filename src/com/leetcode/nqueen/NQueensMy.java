package com.leetcode.nqueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Created by bod on 10/27/14.
 * https://oj.leetcode.com/problems/n-queens/
 */
public class NQueensMy {

    public static void main(String[] strings) {

        NQueensMy nQueensMy = new NQueensMy();
        List<String[]> list = nQueensMy.solveNQueens(4);

        for (String[] solution : list) {
            for (int x = 0; x < solution[0].length(); x++) {
                System.out.println(solution[x]);
            }
            System.out.println();
        }
    }

    public List<String[]> solveNQueens(int n) {
        List<String[]> solutions = new ArrayList<String[]>();

        if (n == 1) {
            String[] a = {"Q"};
            solutions.add(a);
            return solutions;
        } else if (n < 4) {
            return solutions;
        }

        boolean[][] board = new boolean[n][n];

        scanBoard(solutions, board, 0);

        return solutions;
    }

    private boolean scanBoard(List<String[]> solutions, boolean[][] board, int col) {
        int size = board.length;
        if (col >= size) {
            solutions.add(copyBoard(board));
            return true;
        }

        boolean isSucc = false;

        //try to put on each row
        for (int i = 0; i < size; i++) {
            if (checkQueensLeftSide(board, i, col)) {
                board[i][col] = true;
                if (scanBoard(solutions, board, col + 1))
                    isSucc = true;
                board[i][col] = false;
            }
        }

        return isSucc;
    }

    private String[] copyBoard(boolean[][] board) {
        int size = board.length;

        String[] solution = new String[size];

        for (int i = 0 ; i < size; i ++) {
            String row = "";
            for (int j = 0 ; j < size ; j ++) {
                if (board[i][j]) {
                    row += "Q";
                } else {
                    row += ".";
                }
            }
            solution[i] = row;
        }

        return solution;
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
