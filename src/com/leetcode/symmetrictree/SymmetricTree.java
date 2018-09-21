package com.leetcode.symmetrictree;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;

import java.util.Stack;

/**
 * Created by bod on 9/7/14.
 * https://oj.leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("1, 2, 2, 3, 5, 4, 3");
        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        else return areSymSubtrees(root.left, root.right);
    }

    public boolean areSymSubtrees(TreeNode left, TreeNode right) {
        if (left == null || right == null) return ((left == null) && (right == null));
        return left.val == right.val && areSymSubtrees(left.left, right.right) && areSymSubtrees(left.right, right.left);
    }

    public boolean isSymmetricIterative(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (root == null) return true;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root.left);
        s2.push(root.right);
        while (!s1.empty() && !s2.empty()) {
            TreeNode n1 = s1.pop();
            TreeNode n2 = s2.pop();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.val != n2.val) return false;
            s1.push(n1.left);
            s2.push(n2.right);
            s1.push(n1.right);
            s2.push(n2.left);
        }
        return true;
    }
}
