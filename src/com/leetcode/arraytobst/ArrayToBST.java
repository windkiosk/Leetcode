package com.leetcode.arraytobst;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodePrinter;

/**
 * Created by titan-developer on 11/12/14.
 * https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ArrayToBST {

    public static void main(String[] strings) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        ArrayToBST arrayToBST = new ArrayToBST();
        TreeNode root  = arrayToBST.sortedArrayToBST(a);
        TreeNodePrinter.printNode(root);
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }
}
