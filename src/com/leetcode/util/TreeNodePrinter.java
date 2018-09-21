package com.leetcode.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by titan-developer on 11/12/14.
 */
public class TreeNodePrinter {

    public static void main(String[] args) {
        TreeNodePrinter.printNode(TreeNodeCreator.createTreeNode("2, 7, 5, 2, 6, 3, 6, 5, 8, 4, 5, 8, 4, 5, 8"));
        TreeNodePrinter.printNode(TreeNodeCreator.createTreeNode("2, 7, 5, 2, 6, #, 9, #, #, 5, 8, 4, #, 2"));
    }

    public static void printNode(TreeNode root) {
        int maxLevel = TreeNodePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || TreeNodePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        TreeNodePrinter.printWhitespaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            TreeNodePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                TreeNodePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    TreeNodePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    TreeNodePrinter.printWhitespaces(1);

                TreeNodePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    TreeNodePrinter.printWhitespaces(1);

                TreeNodePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(TreeNodePrinter.maxLevel(node.left), TreeNodePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
