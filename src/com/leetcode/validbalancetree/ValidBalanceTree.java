package com.leetcode.validbalancetree;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;
import com.leetcode.util.TreeNodePrinter;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/balanced-binary-tree/
 */
public class ValidBalanceTree {

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("10, 5, 15, #, #, 6, 20, 7");
        TreeNodePrinter.printNode(root);

        ValidBalanceTree validBalanceTree = new ValidBalanceTree();
        System.out.println(validBalanceTree.isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        int height = getHeight(root);
        return height >= 0;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftH = getHeight(root.left);
        if (leftH < 0) {
            return -1;
        }
        int rightH = getHeight(root.right);
        if (rightH < 0) {
            return -1;
        }

        if (Math.abs(leftH - rightH) <= 1) {
            return ( leftH > rightH ? leftH : rightH ) + 1;
        } else {
            return -1;
        }
    }
}
