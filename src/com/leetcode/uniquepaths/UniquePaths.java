package com.leetcode.uniquepaths;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/4/14.
 * https://oj.leetcode.com/problems/unique-paths/
 */
public class UniquePaths {

    public static void main(String[] strings) {
        UniquePaths uniquePaths = new UniquePaths();
        List<List<Pos>> lists = uniquePaths.uniquePathsList(3, 4);

        for (List<Pos> list : lists) {
            for (Pos pos : list) {
                System.out.print("[" + pos.x + ", " + pos.y + "], ");
            }
            System.out.println();
        }

        System.out.println(uniquePaths.uniquePaths(3, 4));
        System.out.println(uniquePaths.uniquePathsFormula(3, 4));
    }

    public int uniquePathsFormula(int m, int n) {
        int N = n + m - 2;// how much steps we need to do
        int k = m - 1; // number of steps that need to go down
        double res = 1;
        // here we calculate the total possible path number
        // Combination(N, k) = Combination(N, N - k)
        for (int i = 1; i <= k; i++)
            res = res * (N - k + i) / i;
        return (int) res;
    }

    //dp
    public int uniquePaths(int m, int n) {
        int[][] P = new int[m + 1][n + 1];
        P[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            P[1][i] = 1;
        }
        for (int i = 2; i <= m; i++) {
            P[i][1] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                P[i][j] = P[i - 1][j] + P[i][j - 1];
            }
        }
        return P[m][n];
    }


    public List<List<Pos>> uniquePathsList(int h, int w) {
        List<List<Pos>> lists = new ArrayList<List<Pos>>();

        findPath(0, 0, h - 1, w - 1, lists, null);

        return lists;
    }

    private boolean findPath(int ori_y, int ori_x, int dest_y, int dest_x, List<List<Pos>> lists, List<Pos> list) {
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
        if (ori_x < dest_x) {
            isSucc = findPath(ori_x + 1, ori_y, dest_x, dest_y, lists, list);
            list.remove(list.size() - 1);
        }

        if (ori_y < dest_y) {
            isSucc = findPath(ori_x, ori_y + 1, dest_x, dest_y, lists, list);
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
