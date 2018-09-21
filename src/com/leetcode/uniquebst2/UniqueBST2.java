package com.leetcode.uniquebst2;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodePrinter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/12/14.
 * https://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBST2 {

    public static void main(String[] strings) {
        UniqueBST2 uniqueBST2 = new UniqueBST2();

        List<TreeNode> list = uniqueBST2.generateTrees(3);

        for (TreeNode root : list) {
            TreeNodePrinter.printNode(root);
        }
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<TreeNode>();
        result[0].add(null);

        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<TreeNode>();
            for (int j = 0; j < len; j++) {
                for (TreeNode nodeL : result[j]) {
                    for (TreeNode nodeR : result[len - j - 1]) {
                        TreeNode node = new TreeNode(j + 1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j + 1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    private TreeNode clone(TreeNode n, int offset) {
        if (n == null)
            return null;
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

    //-------------------------------------------------------------

    public List<TreeNode> generateTreesRecursive(int n) {
        List<TreeNode> ret;
        if (n == 0) {
            ret = new ArrayList<TreeNode>();
            ret.add(null);
        } else {
            ret = helper(1, n);
        }
        return ret;
    }

    List<TreeNode> helper(int from, int to) {
        List<TreeNode> ret = new ArrayList<TreeNode>();

        if (from == to) {
            TreeNode root = new TreeNode(from);
            ret.add(root);
            return ret;
        }

        for (int left = 0; left < (to - from + 1); left ++) {
            int rootVal = from + left;
            List<TreeNode> leftList = null, rightList = null;
            int right = to - from - left;
            if (left > 0) {
                leftList = helper(from, from + left - 1);
            }
            if (right > 0) {
                rightList = helper(from + left + 1, to);
            }
            if (leftList == null) {
                leftList = new ArrayList<TreeNode>();
                leftList.add(null);
            }
            if (rightList == null) {
                rightList = new ArrayList<TreeNode>();
                rightList.add(null);
            }
            collect(leftList, rootVal, rightList, ret);
        }

        return ret;
    }

    void collect(List<TreeNode> leftList, int rootVal, List<TreeNode> rightList, List<TreeNode> ret) {
        for (int i = 0; i < leftList.size(); i ++) {
            for (int j = 0; j < rightList.size(); j ++) {
                TreeNode root = new TreeNode(rootVal);
                TreeNode leftNode = leftList.get(i);
                TreeNode rightNode = rightList.get(j);
                root.left = leftNode;
                root.right = rightNode;
                ret.add(root);
            }
        }
    }
}
