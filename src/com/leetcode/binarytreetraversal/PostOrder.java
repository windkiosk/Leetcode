package com.leetcode.binarytreetraversal;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;
import com.leetcode.util.TreeNodePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by titan-developer on 8/16/14.
 */
public class PostOrder {

    public static void main(String[] strings) {

        TreeNode root = TreeNodeCreator.createTreeNode("1, 1, 2, 3, 4, 5, 6, #, #, 7, 8, #, #, #, #, 10, #, 9");

        TreeNodePrinter.printNode(root);

        PostOrder postOrder = new PostOrder();

        List<Integer> list = postOrder.postOrderTraversalRecursive(root);

        for (int val : list) {
            System.out.println(val);
        }

        System.out.println("------------------");

        PreOrder preOrder = new PreOrder();
        list = preOrder.preorderTraversal(root);

        for (int val : list) {
            System.out.println(val);
        }

        System.out.println("------------------");

        InOrder inOrder = new InOrder();
        list = inOrder.inOrderTraversalRecursive(root);

        for (int val : list) {
            System.out.println(val);
        }
    }

    public List<Integer> postOrderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        //postOrderRecursive(list, root);
        //postOrderIterative(list, root);
        postOrderIterative2Stack(list, root);

        return list;
    }

    private void postOrderRecursive(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderRecursive(list, root.left);
        postOrderRecursive(list, root.right);
        list.add(root.val);
    }

    private void postOrderIterative2Stack(List<Integer> list, TreeNode root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();

        stack1.push(root);

        while (!stack1.empty()) {
            TreeNode current = stack1.pop();
            if (current.left != null) {
                stack1.push(current.left);
            }

            if (current.right != null) {
                stack1.push(current.right);
            }

            stack2.push(current);
        }

        while (!stack2.empty()) {
            list.add(stack2.pop().val);
        }
    }

    private void postOrderIterative(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        Stack<TreeNodeWithType> stack = new Stack<TreeNodeWithType>();

        TreeNode current = root;

        while (current != null) {

            if (current.left != null) {
                TreeNodeWithType rootNode = new TreeNodeWithType();
                rootNode.node = current;
                rootNode.type = TreeNodeWithType.PushStackType.ROOT;
                stack.push(rootNode);

                current = current.left;
            } else if (current.right != null) {
                TreeNodeWithType rootNode = new TreeNodeWithType();
                rootNode.node = current;
                rootNode.type = TreeNodeWithType.PushStackType.RIGHT;
                stack.push(rootNode);

                current = current.right;
            } else {
                list.add(current.val);

                while (true) {
                    if (stack.empty()) {
                        return;
                    }

                    TreeNodeWithType localTempNode = stack.pop();

                    if (localTempNode.type.equals(TreeNodeWithType.PushStackType.RIGHT)) {
                        list.add(localTempNode.node.val);
                    } else {
                        if (localTempNode.node.right == null) {
                            list.add(localTempNode.node.val);
                            continue;
                        } else {
                            current = localTempNode.node.right;
                            localTempNode.type = TreeNodeWithType.PushStackType.RIGHT;
                            stack.push(localTempNode);
                            break;
                        }
                    }
                }
            }
        }
    }

    static class TreeNodeWithType {
        TreeNode node;
        PushStackType type;

        enum PushStackType {
            ROOT, RIGHT
        }
    }
}
