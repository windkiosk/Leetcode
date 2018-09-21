package com.leetcode.flattenbinarytree;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;
import com.leetcode.util.TreeNodePrinter;

/**
 * Created by bod on 8/31/14.
 * https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTree {

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("1, 2, 5, 3, 4, #, 6");
        TreeNodePrinter.printNode(root);

        FlattenBinaryTree flattenBinaryTree = new FlattenBinaryTree();
        flattenBinaryTree.flattenIterative(root);

        TreeNodePrinter.printNode(root);
    }

    public void flattenIterative(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) pre = pre.right;
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }

    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    public TreeNode flattenTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftTail = null;
        TreeNode left = root.left;
        if (left != null) {
            leftTail = flattenTree(left);
        }

        TreeNode rightTail = null;
        TreeNode right = root.right;
        if (right != null) {
            rightTail = flattenTree(right);
        }

        if (left != null && right != null) {
            root.left = null;
            root.right = left;
            leftTail.left = null;
            leftTail.right = right;
            return rightTail;
        } else if (left == null && right == null) {
            return root;
        } else if (left == null) {
            return rightTail;
        } else {
            root.left = null;
            root.right = left;
            return leftTail;
        }

    }
}
