package com.practise1;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;
import com.leetcode.util.TreeNodePrinter;

import java.util.*;

/**
 * Created by titan-developer on 12/29/14.
 */
public class TestPractise {

    public static void main(String[] strings) {

        char[][] a = {
                {'0', '0', '0'},
                {'0', '0', '0'},
                {'0', '0', '0'},

        };


        char[][] b = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'},
        };

        int a0[] = {3, 4};
        int b0[] = {};

        int a1[] = {1, 3, 5, 7, 9};
        int b1[] = {6, 8, 10, 12, 14};

        int a2[] = {1, 1};
        int b2[] = {1, 1};

        int a3[] = {};
        int b3[] = {1, 2, 3, 4, 5};

        int[][] A = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5},
        };

        TestPractise practise = new TestPractise();
        System.out.println(practise.backpack(11, new int[]{2, 3, 5, 7}));
    }

    private static void outputTree(List<TreeNode> treeNodes) {
        for (TreeNode root : treeNodes) {
            TreeNodePrinter.printNode(root);
            System.out.println("------------------");
        }
    }

    public static <E> void outputList(List<E> list) {
        for (E elem : list) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }

    public int backpack(int m, int[] A) {
        int len = A.length;
        int[][] dp = new int[len + 1][m + 1];

        for (int i = 1; i <= len; i ++) {
            for (int j = 1; j <= m; j ++) {
                int v = A[i - 1];
                if (v > j){
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v] + v);
                }
            }
        }

        return dp[len][m];
    }
}


