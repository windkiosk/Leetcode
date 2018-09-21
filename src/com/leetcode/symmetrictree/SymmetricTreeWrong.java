package com.leetcode.symmetrictree;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;
import com.leetcode.util.TreeNodePrinter;

import java.util.ArrayList;

/**
 * Created by titan-developer on 9/6/14.
 * https://oj.leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTreeWrong {
    ArrayList<String> nodeArr;

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("5, 4, 1, #, 1, #, 4, 2, #, 2");
        TreeNodePrinter.printNode(root);

        SymmetricTreeWrong tree = new SymmetricTreeWrong();

        System.out.println(tree.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return true;
        }
        nodeArr = new ArrayList<String>();
        inorderTraversal(root);

        // compare in-order traversal list
        int i = 0;
        int j = nodeArr.size() - 1;
        while (i < j) {
            if (!nodeArr.get(i).equals(nodeArr.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public void inorderTraversal(TreeNode n) {
        // if empty node, save as ‘#’ to occupy this place
        if (n == null) {
            nodeArr.add("#");
            return;
        }
        if (n.left == null && n.right == null) {
            nodeArr.add("" + n.val);
        } else {
            inorderTraversal(n.left);
            nodeArr.add("" + n.val);
            inorderTraversal(n.right);
        }
    }
}
