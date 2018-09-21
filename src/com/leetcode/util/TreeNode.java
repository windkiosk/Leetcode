package com.leetcode.util;

/**
 * Created by titan-developer on 8/16/14.
 */

/**
 * Definition for binary tree
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return val + ", L:" + (left == null ? "NULL" : left.val) + ", R:" + (right == null ? "NULL" : right.val);
    }
}

