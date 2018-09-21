package com.leetcode.surroundregion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by titan-developer on 11/12/14.
 * https://oj.leetcode.com/problems/surrounded-regions/
 */
public class SurroundRegion {

    class Point
    {
        int row;
        int col;

        public Point(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }

    public void solve(char[][] board)
    {
        if (board.length < 3 || board[0].length < 3)
        {
            return;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        // check first row
        for (int col = 0; col < board[0].length; col++)
        {
            if (board[0][col] == 'O')
            {
                exploreBoard(board, visited, 0, col);
            }
        }

        // check last row
        for (int col = 0; col < board[0].length; col++)
        {
            if (board[board.length-1][col] == 'O')
            {
                exploreBoard(board, visited, board.length-1, col);
            }
        }

        // check first col
        for (int row = 0; row < board.length; row++)
        {
            if (board[row][0] == 'O')
            {
                exploreBoard(board, visited, row, 0);
            }
        }

        // check last col
        for (int row = 0; row < board.length; row++)
        {
            if (board[row][board[0].length-1] == 'O')
            {
                exploreBoard(board, visited, row, board[0].length-1);
            }
        }

        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                if (visited[row][col] == false && board[row][col] == 'O')
                {
                    board[row][col] = 'X';
                }
            }
        }
    }

    public void exploreBoard(char[][] board, boolean[][] visited, int row, int col)
    {
        LinkedList<Point> queue = new LinkedList<Point>();
        queue.addLast(new Point(row, col));

        while (!queue.isEmpty())
        {
            Point p = queue.removeFirst();
            // four directions

            if (visited[p.row][p.col] == false)
            {
                visited[p.row][p.col] = true;

                //up
                if (p.row != 0 && board[p.row-1][p.col] == 'O' && !visited[p.row-1][p.col])
                {
                    queue.addLast(new Point(p.row-1, p.col));
                }
                //left
                if (p.col != 0 && board[p.row][p.col-1] == 'O' && !visited[p.row][p.col-1])
                {
                    queue.addLast(new Point(p.row, p.col-1));
                }
                // down
                if (p.row != board.length-1 && board[p.row+1][p.col] == 'O' && !visited[p.row+1][p.col])
                {
                    queue.addLast(new Point(p.row+1, p.col));
                }
                // right
                if (p.col != board[0].length-1 && board[p.row][p.col+1] == 'O' && !visited[p.row][p.col+1])
                {
                    queue.addLast(new Point(p.row, p.col+1));
                }
            }
        }
    }
}
