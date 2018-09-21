package com.leetcode.maxtreepathsum;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;
import com.leetcode.util.TreeNodePrinter;

/**
 * Created by titan-developer on 11/12/14.
 * https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class MaxTreePathSum {

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("10, 5, 15, #, #, 6, 20, 7");
        TreeNodePrinter.printNode(root);

        MaxTreePathSum pathSum = new MaxTreePathSum();
        System.out.println(pathSum.maxPathSum(root));
    }

    int maxSum;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        maxSum = root.val;
        recNodes(root);
        return maxSum;
    }

    int recNodes(TreeNode node) {
        int numl = 0, numr = 0;
        if (node.left != null)
            numl = recNodes(node.left);
        if (node.right != null)
            numr = recNodes(node.right);

        //choose the max path, either left or right
        int value = node.val;
        checkMax(value, numl + numr);
        int sumLeft = numl > 0 ? checkMax(value, numl) : value;
        int sumRight = numr > 0 ? checkMax(value, numr) : value;

        return Math.max(sumLeft, sumRight);
    }

    int checkMax(int value, int sum) {
        if (sum > 0)
            sum += value;
        else
            sum = value;
        if (sum > maxSum)
            maxSum = sum;
        return sum;
    }


}