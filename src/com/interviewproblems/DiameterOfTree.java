package com.interviewproblems;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;
import com.leetcode.util.TreeNodePrinter;

/**
 * Created by bod on 1/24/15.
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 */
public class DiameterOfTree {

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("1, 2, 3, 4, 5, #, 6, #, #, 7, 8, #, 9, #, #, #, #, 10, 11, 12, 13");
        TreeNodePrinter.printNode(root);

        DiameterOfTree diameterOfTree = new DiameterOfTree();
        System.out.println(diameterOfTree.getDiameter(root));
    }


    int diameter = 0;
    public int getDiameter(TreeNode root) {
        getHeight(root);
        return diameter;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        if (lh + rh + 1 > diameter) diameter = lh + rh + 1;

        return Math.max(lh, rh) + 1;
    }

}
