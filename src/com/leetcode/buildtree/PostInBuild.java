package com.leetcode.buildtree;

import com.leetcode.util.TreeNode;

/**
 * Created by titan-developer on 9/6/14.
 * https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class PostInBuild {

    static int[] TestpostOrder = {3, 4, 2, 1};
    static int[] TestinOrder = {1, 2, 3, 4};

    public static void main(String[] strings) {
        PostInBuild build = new PostInBuild();
        TreeNode node = build.buildTree(TestinOrder, TestpostOrder);
        System.out.println(node.val);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        int root = postorder[postorder.length - 1];
        TreeNode rootNode = new TreeNode(root);

        boolean isMatched = false;
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                isMatched = true;
                break;
            }
        }

        if (!isMatched) {
            return null;
        }

        int[] leftInOrder = null;
        int[] rightInOrder = null;
        int[] leftPostOrder = null;
        int[] rightPostOrder = null;
        if (i > 0) {
            leftInOrder = new int[i];
            System.arraycopy(inorder, 0, leftInOrder, 0, i);

            leftPostOrder = new int[i];
            System.arraycopy(postorder, 0, leftPostOrder, 0, leftPostOrder.length);
        }

        int rightLength = inorder.length - i - 1;
        if (rightLength > 0) {
            rightInOrder = new int[rightLength];
            System.arraycopy(inorder, i + 1, rightInOrder, 0, rightInOrder.length);

            rightPostOrder = new int[rightLength];
            System.arraycopy(postorder, i, rightPostOrder, 0, rightPostOrder.length);
        }

        rootNode.left = buildTree(leftInOrder, leftPostOrder);
        rootNode.right = buildTree(rightInOrder, rightPostOrder);

        return rootNode;
    }
}
