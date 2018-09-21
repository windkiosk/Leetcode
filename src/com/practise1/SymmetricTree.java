package com.practise1;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;

/**
 * Created by titan-developer on 12/8/14.
 */
public class SymmetricTree {

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("1, 2, 2, 3, 5, 4, 3");
        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetricTree(root));
    }

    public boolean isSymmetricTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root.left, root.right);
    }

    boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else {
            return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
        }
    }

}
