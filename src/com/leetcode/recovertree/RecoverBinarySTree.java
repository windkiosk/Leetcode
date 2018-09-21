package com.leetcode.recovertree;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;
import com.leetcode.util.TreeNodePrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 10/31/14.
 * https://oj.leetcode.com/problems/recover-binary-search-tree/
 */
public class RecoverBinarySTree {

    public static void main(String[] strings) {

        RecoverBinarySTree recover = new RecoverBinarySTree();

        TreeNode treeNode1 = TreeNodeCreator.createTreeNode("10, 5, 15, #, #, 6, 20, 7");
        TreeNodePrinter.printNode(treeNode1);
        recover.recoverTree(treeNode1);
        TreeNodePrinter.printNode(treeNode1);

        TreeNode treeNode2 = TreeNodeCreator.createTreeNode("0, 1");
        TreeNodePrinter.printNode(treeNode2);
        recover.recoverTree(treeNode2);
        TreeNodePrinter.printNode(treeNode2);

        TreeNode treeNode3 = TreeNodeCreator.createTreeNode("11, 7, 15, 4, #, 13, 17, 3, 5, 10, 14, #, 19, #, 6");
        TreeNodePrinter.printNode(treeNode3);
        recover.recoverTree(treeNode3);
        TreeNodePrinter.printNode(treeNode3);
    }

    //------------------------------------------------
    TreeNode first, second, last;
    public void recoverTreeNew(TreeNode root) {
        inOrder(root);
        int v1 = first.val;
        first.val = second.val;
        second.val = v1;
    }

    void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (last == null) {
            last = root;
        } else {
            if (root.val < last.val) {
                if (first == null && second == null) {
                    first = last;
                    second = root;
                } else {
                    second = root;
                }
            }
            last = root;
        }
        inOrder(root.right);
    }

    public void recoverTree(TreeNode root) {
        TreeNode[] lastNodes = new TreeNode[1];
        TreeNode[] swapNodes = new TreeNode[1];

        boolean isSwapped = recoverTraversal(root, lastNodes, swapNodes);
        if (!isSwapped) {
            int val = lastNodes[0].val;
            lastNodes[0].val = swapNodes[0].val;
            swapNodes[0].val = val;
        }

        List<TreeNode> list = new ArrayList<TreeNode>();
        middleTraversal(root, list);

        for (TreeNode node : list) {
            System.out.print(node.val + ", ");
        }
        System.out.println();
    }

    private void middleTraversal(TreeNode root, List<TreeNode> list) {
        if (root.left != null) {
            middleTraversal(root.left, list);
        }

        list.add(root);

        if (root.right != null) {
            middleTraversal(root.right, list);
        }
    }

    private boolean recoverTraversal(TreeNode root, TreeNode[] lastNodes, TreeNode[] swapNodes) {
        boolean isSwapped = false;
        if (root.left != null) {
            isSwapped = recoverTraversal(root.left, lastNodes, swapNodes);
            if (isSwapped) {
                return true;
            }
        }

        if (swapNodes[0] != null) {
            if (swapNodes[0].val <= root.val) {
                TreeNode second = lastNodes[0];

                int val = swapNodes[0].val;
                swapNodes[0].val = second.val;
                second.val = val;

                return true;
            }
        } else if (lastNodes[0] != null) {
            if (root.val < lastNodes[0].val) {
                swapNodes[0] = lastNodes[0];
            }
        }
        lastNodes[0] = root;

        if (root.right != null) {
            isSwapped = recoverTraversal(root.right, lastNodes, swapNodes);
            if (isSwapped) {
                return isSwapped;
            }
        }

        return isSwapped;
    }
}
