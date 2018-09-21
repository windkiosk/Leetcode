package com.leetcode.treetraversal;

import com.leetcode.util.MultipleTreeNode;

import java.util.List;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by bod on 9/4/14.
 */
public class DepthFirstSearch {

    public static void main(String[] strings) {

        DepthFirstSearch search = new DepthFirstSearch();
        Vector<MultipleTreeNode> list = new Vector<MultipleTreeNode>();
        search.dfsNonRecursive(createRoot(), list);

        for (MultipleTreeNode node : list) {
            System.out.println(node.getValue());
        }

        System.out.println("---------");

        list.clear();

        BreathFirstSearch breathFirstSearch = new BreathFirstSearch();
        breathFirstSearch.bfs(createRoot(), list);

        for (MultipleTreeNode node : list) {
            System.out.println(node.getValue());
        }
    }

    public static MultipleTreeNode createRoot() {

        MultipleTreeNode root = new MultipleTreeNode(1);
        MultipleTreeNode node2 = new MultipleTreeNode(2);
        MultipleTreeNode node3 = new MultipleTreeNode(3);
        MultipleTreeNode node4 = new MultipleTreeNode(4);
        MultipleTreeNode node5 = new MultipleTreeNode(5);
        MultipleTreeNode node6 = new MultipleTreeNode(6);
        MultipleTreeNode node7 = new MultipleTreeNode(7);
        MultipleTreeNode node8 = new MultipleTreeNode(8);
        MultipleTreeNode node9 = new MultipleTreeNode(9);
        MultipleTreeNode node10 = new MultipleTreeNode(10);
        MultipleTreeNode node11 = new MultipleTreeNode(11);
        MultipleTreeNode node12 = new MultipleTreeNode(12);

        node3.addChild(node4);
        node3.addChild(node5);

        node2.addChild(node3);
        node2.addChild(node6);

        node9.addChild(node10);
        node9.addChild(node11);

        node8.addChild(node9);
        node8.addChild(node12);

        root.addChild(node2);
        root.addChild(node7);
        root.addChild(node8);

        return root;
    }

    public void dfs(MultipleTreeNode root, Vector<MultipleTreeNode> list) {
        if (root == null || list == null) {
            return;
        }

        list.add(root);

        Vector<MultipleTreeNode> children = root.getChildren();

        for (MultipleTreeNode child : children) {
            dfs(child, list);
        }
    }

    public void dfsNonRecursive(MultipleTreeNode root, Vector<MultipleTreeNode> list) {
        if (root == null || list == null) {
            return;
        }

        Stack<MultipleTreeNode> stack = new Stack<MultipleTreeNode>();
        stack.push(root);

        while (stack.size() > 0) {
            MultipleTreeNode node = stack.pop();
            list.add(node);

            List<MultipleTreeNode> children = node.getChildren();
            if (children != null) {
                int size = children.size();
                for (int i = size - 1; i >= 0; i--) {
                    MultipleTreeNode child = children.get(i);
                    stack.push(child);
                }
            }
        }
    }
}
