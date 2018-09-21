package com.leetcode.util;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by bod on 11/20/14.
 */
public class TreeNodeCreator {

    public static void main(String[] strings) {

        TreeNode treeNode = TreeNodeCreator.createTreeNode("1, 2, 3, 4, 5, #, #, 7, 8, 9, #");
        TreeNodePrinter.printNode(treeNode);

        treeNode = createTreeNode("1, #, 2, 3");
        TreeNodePrinter.printNode(treeNode);
    }

    //1,#,2,3
    public static TreeNode createTreeNode(String str) {
        if (str == null) {
            return null;
        }

        String[] values = str.split(",");

        if (values.length <= 0) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);


        int i = 1;
        while (i < values.length) {
            int count = queue.size();

            for (int m = 0; m < count; m ++) {
                TreeNode node = queue.poll();

                if (!values[i].trim().equals("#")) {
                    TreeNode tmp = new TreeNode(Integer.valueOf(values[i].trim()));
                    node.left = tmp;
                    queue.add(tmp);
                }

                if (i + 1 < values.length &&!values[i + 1].trim().equals("#")) {
                    TreeNode tmp = new TreeNode(Integer.valueOf(values[i + 1].trim()));
                    node.right = tmp;
                    queue.add(tmp);
                }

                i += 2;

                if (i >= values.length) {
                    break;
                }
            }
        }

        return root;
    }
}
