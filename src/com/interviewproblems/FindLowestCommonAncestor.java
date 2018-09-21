package com.interviewproblems;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;
import com.leetcode.util.TreeNodePrinter;

/**
 * Created by bod on 1/24/15.
 * http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=lowestCommonAncestor
 */
public class FindLowestCommonAncestor {

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("8, 1, 9, 2, 3, 20, 10, 4, 5, 6, 7");
        TreeNodePrinter.printNode(root);

        FindLowestCommonAncestor testPractise = new FindLowestCommonAncestor();
        System.out.println(testPractise.findLCA(root, root.left.left.left, root.left.right));
    }

    public TreeNode findLCA(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) return null;
        if (root == A || root == B) return root;

        TreeNode leftLca = findLCA(root.left, A, B);
        TreeNode rightLca = findLCA(root.right, A, B);

        if (leftLca != null && rightLca != null) return root;
        return leftLca == null ? rightLca : leftLca;
    }
}
