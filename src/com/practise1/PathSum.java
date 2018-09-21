package com.practise1;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;

/**
 * Created by titan-developer on 12/8/14.
 */
public class PathSum {

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("1");

        PathSum pathSum = new PathSum();
        System.out.println(pathSum.hasPathSum(root, 1));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        return helper(root, sum);
    }

    boolean helper(TreeNode root, int sum) {
        if (root == null && sum == 0) {
            return true;
        }

        if (root == null) {
            return false;
        }

        int v = sum - root.val;

        boolean isLeft = false;
        boolean isRight = false;

        if (v == 0 && root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null) {
            isLeft = helper(root.left, v);
        }

        if (!isLeft && root.right != null) {
            isRight = helper(root.right, v);
        }

        return isLeft || isRight;
    }
}
