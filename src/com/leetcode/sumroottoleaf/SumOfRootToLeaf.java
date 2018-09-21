package com.leetcode.sumroottoleaf;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;
import com.leetcode.util.TreeNodePrinter;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumOfRootToLeaf {

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("1, 2, 3, #, #, 4, 3, 5");
        TreeNodePrinter.printNode(root);

        SumOfRootToLeaf sumOfRootToLeaf = new SumOfRootToLeaf();
        System.out.println(sumOfRootToLeaf.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        int[] count = new int[2];
        dfs(root, count);

        return count[0];
    }

    private void dfs(TreeNode root, int[] count) {
        if (root.left == null && root.right == null) {
            count[1] = (count[1] * 10) + root.val;
            count[0] += count[1];
            count[1] = (count[1] - root.val) / 10;
            return;
        }

        count[1] = (count[1] * 10) + root.val;
        if (root.left != null) {
            dfs(root.left, count);
        }

        if (root.right != null) {
            dfs(root.right, count);
        }
        count[1] = (count[1] - root.val) / 10;
    }
}
