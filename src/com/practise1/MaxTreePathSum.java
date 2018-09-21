package com.practise1;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;
import com.leetcode.util.TreeNodePrinter;

/**
 * Created by titan-developer on 12/9/14.
 */
public class MaxTreePathSum {
    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("1,#,2,#,3,#,4,#,5");
        TreeNodePrinter.printNode(root);

        MaxTreePathSum pathSum = new MaxTreePathSum();
        System.out.println(pathSum.maxPathSum(root));
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        checkNode(root);

        return max;
    }

    public int checkNode(TreeNode root) {
        checkMax(root);

        int upper = root.val;
        int left = 0, right = 0;
        if (root.left != null) {
            checkMax(root.left);
            left = checkNode(root.left);
        }

        if (root.right != null) {
            checkMax(root.right);
            right = checkNode(root.right);
        }

        if (right + root.val > upper) {
            upper = root.val + right;
        }

        if (left + root.val > upper) {
            upper = root.val + left;
        }

        if (upper > max) {
            max = upper;
        }

        if (root.val + right + left > max) {
            max = root.val + right + left;
        }

        return upper;
    }

    private void checkMax(TreeNode node) {
        if (node != null && node.val > max) {
            max = node.val;
        }
    }

}
