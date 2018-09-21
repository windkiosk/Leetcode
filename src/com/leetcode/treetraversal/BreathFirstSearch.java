package com.leetcode.treetraversal;

import com.leetcode.util.MultipleTreeNode;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

/**
 * Created by bod on 9/4/14.
 */
public class BreathFirstSearch {

    public void bfs(MultipleTreeNode root, Vector<MultipleTreeNode> list) {
        if (root == null || list == null) {
            return;
        }

        Queue<MultipleTreeNode> queue = new ArrayDeque<MultipleTreeNode>();
        queue.add(root);

        while (queue.size() > 0) {
            MultipleTreeNode node = queue.poll();
            list.add(node);

            List<MultipleTreeNode> children = node.getChildren();
            for (MultipleTreeNode child : children) {
                queue.add(child);
            }
        }
    }
}
