package com.interviewproblems.findnumberofgroupone;

import java.util.ArrayDeque;

/**
 * Created by bod on 12/4/2014.
 */
public class FindNumberOfGroupOne {

    public static void main(String[] strings) {
        int[][] matrix = {
                {1, 0, 0, 1, 0},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 0, 0, 0, 1},
        };

        FindNumberOfGroupOne finder = new FindNumberOfGroupOne();
        System.out.println(finder.findNumberOfGroup(matrix));
    }

    class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int findNumberOfGroup(int[][] matrix) {
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 1) {
                    bfs(matrix, i, j);
                    //dfs(matrix, i, j);
                    count ++;
                }
            }
        }

        return count;
    }

    private void bfs(int[][] matrix, int i, int j) {

        ArrayDeque<Pos> list = new ArrayDeque<Pos>();
        list.add(new Pos(i, j));

        while (!list.isEmpty()) {
            Pos pos = list.poll();

            i = pos.x;
            j = pos.y;

            matrix[i][j] = 0;

            if (i > 0 && matrix[i - 1][j] == 1) {
                list.add(new Pos(i - 1, j));
            }

            if (j > 0 && matrix[i][j - 1] == 1) {
                list.add(new Pos(i, j - 1));
            }

            if (i < matrix.length - 1 && matrix[i + 1][j] == 1) {
                list.add(new Pos(i + 1, j));
            }

            if (j < matrix[0].length - 1 && matrix[i][j + 1] == 1) {
                list.add(new Pos(i, j + 1));
            }
        }
    }

    private void dfs(int[][] matrix, int i, int j) {
        matrix[i][j] = 0;

        if (i > 0 && matrix[i - 1][j] == 1) {
            dfs(matrix, i - 1, j);
        }

        if (j > 0 && matrix[i][j - 1] == 1) {
            dfs(matrix, i, j - 1);
        }

        if (i < matrix.length - 1 && matrix[i + 1][j] == 1) {
            dfs(matrix, i + 1, j);
        }

        if (j < matrix[0].length - 1 && matrix[i][j + 1] == 1) {
            dfs(matrix, i, j + 1);
        }
    }
}
