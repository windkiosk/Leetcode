package com.interviewproblems.dropballgame;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/**
 * Created by titan-developer on 12/10/14.
 */
public class DropBallGame {
    int row, column, k;
    int[][] matrix;
    int[] sizeArray;

    public static void main(String[] strings) {
        DropBallGame dropBallGame = new DropBallGame(4, 4, 7);

        System.out.println(dropBallGame.drop(2, 0));
        System.out.println(dropBallGame.drop(2, 0));
        System.out.println(dropBallGame.drop(1, 1));
        System.out.println(dropBallGame.drop(1, 1));

        System.out.println(dropBallGame.drop(1, 3));
        System.out.println(dropBallGame.drop(1, 3));

        System.out.println(dropBallGame.drop(1, 2));
        System.out.println(dropBallGame.drop(1, 2));

        /*
        2, 1, 1, 1
        2, 1, 1, 1
        */
        //just drop the one make it win
        System.out.println(dropBallGame.drop(1, 2));
    }

    DropBallGame(int row, int column, int k) {
        this.row = row;
        this.column = column;
        this.k = k;
        matrix = new int[row][column];
        sizeArray = new int[column];
    }

    /**
     * Drop one ball and return true if the player already win.
     *
     * @param id
     * @param column
     * @return
     */
    boolean drop(int id, int column) {
        int r = row - sizeArray[column] - 1;
        matrix[r][column] = id;
        boolean isWin = determine(r, column, id);
        sizeArray[column]++;
        return isWin;
    }

    /**
     * check from (i, j) pos to see if hit k
     *
     * @param i
     * @param j
     * @param id
     * @return isWin
     */
    private boolean determine(int i, int j, int id) {
        if (k <= 1) {
            return true;
        }

        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.add(i * column + j);
        HashSet<Integer> visitedPos = new HashSet<Integer>();
        visitedPos.add(i * column + j);
        int count = 1;

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int x = pos / column;
            int y = pos % column;

            if (addToQueue(x - 1, y, queue, visitedPos, id)) count++;
            if (addToQueue(x, y - 1, queue, visitedPos, id)) count++;
            if (addToQueue(x + 1, y, queue, visitedPos, id)) count++;
            if (addToQueue(x, y + 1, queue, visitedPos, id)) count++;

            if (count >= k) {
                visitedPos.clear();
                return true;
            }
        }

        visitedPos.clear();
        return false;
    }

    private boolean addToQueue(int i, int j, Queue<Integer> queue, HashSet<Integer> visitedPos, int id) {
        if (isInBox(i, j) && !visitedPos.contains(i * column + j) && matrix[i][j] == id) {
            visitedPos.add(i * column + j);
            queue.add(i * column + j);
            return true;
        }

        return false;
    }

    private boolean isInBox(int i, int j) {
        return i >= 0 && i < row && j >= 0 && j < column;
    }
}
