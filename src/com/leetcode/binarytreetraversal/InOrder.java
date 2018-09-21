package com.leetcode.binarytreetraversal;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by titan-developer on 8/17/14.
 */
public class InOrder {


    public List<Integer> inOrderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        //inOrderRecursive(list, root);
        inOrderIterative(list, root);

        return list;
    }

    private void inOrderRecursive(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderRecursive(list, root.left);
        list.add(root.val);
        inOrderRecursive(list, root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root == null || root.left == null) {
                if (root == null) root = stack.pop();
                ret.add(root.val);
                root = root.right;
            } else {
                stack.push(root);
                root = root.left;
            }
        }

        return ret;
    }

    private void inOrderIterative(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode current = root;

        while (current != null) {

            if (current.left != null) {
                stack.push(current);
                current = current.left;
            } else if (current.right != null) {
                list.add(current.val);
                current = current.right;
            } else {
                list.add(current.val);
                if (stack.empty())
                    return;

                TreeNode localRoot = stack.pop();
                list.add(localRoot.val);
                while (localRoot.right == null) {
                    if (stack.empty()) {
                        return;
                    }

                    localRoot = stack.pop();
                    list.add(localRoot.val);
                }

                current = localRoot.right;
            }
        }
    }
}
