package com.leetcode.uniquepaths2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/4/14.
 * https://oj.leetcode.com/problems/unique-paths-ii/
 */
public class UniquePaths2 {

    public static void main(String[] strings) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
        };

        UniquePaths2 uniquePaths2 = new UniquePaths2();
        System.out.println(uniquePaths2.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                if (obstacleGrid[i - 1][j - 1] != 1)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[m][n];
    }

    public int uniquePathsWithObstaclesRecursive(int[][] obstacleGrid) {
        List<List<Pos>> lists = uniquePathsList(obstacleGrid.length, obstacleGrid.length, obstacleGrid);

        for (List<Pos> list : lists) {
            for (Pos pos : list) {
                System.out.print("[" + pos.x + ", " + pos.y + "], ");
            }
            System.out.println();
        }

        return lists.size();
    }

    public List<List<Pos>> uniquePathsList(int h, int w, int[][] obstacleGrid) {
        List<List<Pos>> lists = new ArrayList<List<Pos>>();

        findPath(0, 0, h - 1, w - 1, obstacleGrid, lists, null);

        return lists;
    }

    private boolean findPath(int ori_y, int ori_x, int dest_y, int dest_x, int[][] obstacleGrid, List<List<Pos>> lists, List<Pos> list) {
        if (list == null) {
            list = new ArrayList<Pos>();
        }

        list.add(new Pos(ori_x, ori_y));

        if (ori_x == dest_x && ori_y == dest_y) {
            List<Pos> newList = new ArrayList<Pos>(list);
            lists.add(newList);
            return true;
        }

        boolean isSucc = false;
        if (ori_x < dest_x && obstacleGrid[ori_x + 1][ori_y] != 1) {
            isSucc = findPath(ori_y, ori_x + 1, dest_y, dest_x, obstacleGrid, lists, list);
            list.remove(list.size() - 1);
        }

        if (ori_y < dest_y && obstacleGrid[ori_x][ori_y + 1] != 1) {
            isSucc = findPath(ori_y + 1, ori_x, dest_y, dest_x, obstacleGrid, lists, list);
            list.remove(list.size() - 1);
        }

        return isSucc;
    }

    class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
