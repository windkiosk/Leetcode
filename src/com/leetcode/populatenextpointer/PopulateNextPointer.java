package com.leetcode.populatenextpointer;

/**
 * Created by titan-developer on 11/9/14.
 * works for both:
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulateNextPointer {

    public static void main(String[] strings) {
        TreeLinkNode root = new TreeLinkNode(10);

        root.left = new TreeLinkNode(5);
        root.right = new TreeLinkNode(15);

        root.right.left = new TreeLinkNode(6);
        root.right.left.left = new TreeLinkNode(7);
        root.right.right = new TreeLinkNode(20);

        PopulateNextPointer pointer = new PopulateNextPointer();
        pointer.connect(root);
    }

    //works for both
    //https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
    //https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode current = root;
        TreeLinkNode nextLevelHead = new TreeLinkNode(-1);
        TreeLinkNode nextLevelCurrent = nextLevelHead;

        while (current != null) {

            if (current.left != null) {
                nextLevelCurrent.next = current.left;
                nextLevelCurrent = current.left;
            }

            if (current.right != null) {
                nextLevelCurrent.next = current.right;
                nextLevelCurrent = current.right;
            }

            if (current.next == null) {
                current = nextLevelHead.next;
                nextLevelHead.next = null;
                nextLevelCurrent = nextLevelHead;
            } else {
                current = current.next;
            }
        }
    }

    static class TreeLinkNode {
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        int val;

        TreeLinkNode(int v) {
            this.val = v;
        }
    }
}
