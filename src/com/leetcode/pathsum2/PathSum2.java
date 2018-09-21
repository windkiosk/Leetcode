package com.leetcode.pathsum2;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;
import com.leetcode.util.TreeNodePrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/path-sum-ii/
 */
public class PathSum2 {

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("10, 5, 15, #, #, 6, 20, 7");
        TreeNodePrinter.printNode(root);

        PathSum2 sum2 = new PathSum2();
        outputList(sum2.pathSum(root, 38));
    }

    public static void outputList(List<List<Integer>> list) {
        for (List<Integer> intList : list) {
            for (int a : intList) {
                System.out.print(a + " , ");
            }
            System.out.println("");
        }
        System.out.println("--------------");
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        if (root == null) {
            return lists;
        }

        List<Integer> current = new ArrayList<Integer>();
        dfs(root, lists, current, sum);

        return lists;
    }

    private void dfs(TreeNode root, List<List<Integer>> lists, List<Integer> current, int sum) {
        if (root == null) {
            return;
        }

        current.add(root.val);

        if (root.left == null && root.right == null && sum == root.val) {
            List<Integer> tmpList = (List<Integer>)((ArrayList<Integer>)current).clone();
            lists.add(tmpList);
        }

        if (root.left != null) {
            dfs(root.left, lists, current, sum - root.val);
            current.remove(current.size() - 1);
        }

        if (root.right != null) {
            dfs(root.right, lists, current, sum - root.val);
            current.remove(current.size() - 1);
        }
    }
}
