package com.leetcode.util;

import java.util.Vector;

/**
 * Created by bod on 9/4/14.
 */
public class MultipleTreeNode {
    Vector<MultipleTreeNode> children;
    int value;

    public MultipleTreeNode(int value) {
        this.value = value;
        children = new Vector<MultipleTreeNode>();
    }

    public Vector<MultipleTreeNode> getChildren() {
        return children;
    }

    public void addChild(MultipleTreeNode node) {
        children.add(node);
    }

    public int getValue() {
        return value;
    }
}
