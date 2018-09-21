package com.leetcode.validbst;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidBinarySearchTree {

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("10, 5, 15, #, #, 6, 20");

        ValidBinarySearchTree validBinarySearchTree = new ValidBinarySearchTree();
        System.out.println(validBinarySearchTree.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        int[] array = new int[1];
        array[0] = Integer.MIN_VALUE;

        return inOrderRecursive(array, root);
    }

    private boolean inOrderRecursive(int[] array, TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isValid = inOrderRecursive(array, root.left);
        if (isValid) {
            if (root.val > array[0]) {
                array[0] = root.val;
            } else {
                return false;
            }

            isValid = inOrderRecursive(array, root.right);
        }
        return isValid;
    }


    int lastVal = Integer.MIN_VALUE;
    boolean isFirst = true;
    public boolean isValidBSTNews(TreeNode root) {
        return helper(root);
    }

    boolean helper(TreeNode root) {
        if (root == null) return true;
        boolean isValid = helper(root.left);
        if (isValid) {
            if (!isFirst && root.val <= lastVal) return false;
            lastVal = root.val;
            isFirst = false;
        }
        if (isValid) isValid = helper(root.right);
        return isValid;
    }
}
