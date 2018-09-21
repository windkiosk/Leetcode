package com.practise1;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by bod on 11/20/14.
 */
public class PreorderTravsal {

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("1, 2, 3, 4, 5, 6, 7, #, #, #, #, 8");

        PreorderTravsal preorderTravsal = new PreorderTravsal();

        List<Integer> list = preorderTravsal.preorderTraversal(root);

        for (int v : list) {
            System.out.printf(v + ", ");
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(root != null) {
            list.add(root.val);
            if (root.right != null) {
                stack.push(root);
            }
            root = root.left;
            if (root == null && !stack.isEmpty()) {
                root = stack.pop().right;
            }
        }

        return list;
    }
}
