package com.leetcode.listtobst;

import com.leetcode.util.ListNode;
import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodePrinter;

/**
 * Created by titan-developer on 11/12/14.
 * https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class ListToBST {

    public static void main(String[] strings) {
        ListNode head = ListNode.createList("1->2->3->4->5->6->7->8->9");

        ListToBST listToBST = new ListToBST();

        TreeNode root = listToBST.sortedListToBST(head);

        TreeNodePrinter.printNode(root);
    }


    static ListNode h;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        h = head;
        int len = getLength(head);
        return sortedListToBST(0, len - 1);
    }

    // get list length
    public int getLength(ListNode head) {
        int len = 0;
        ListNode p = head;

        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }

    // build tree bottom-up
    public TreeNode sortedListToBST(int start, int end) {
        if (start > end)
            return null;

        // mid
        int mid = (start + end) / 2;

        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode right = sortedListToBST(mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }
}
