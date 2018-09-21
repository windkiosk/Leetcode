package com.leetcode.minimumdepthoftree;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;
import com.leetcode.util.TreeNodePrinter;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfTree {

    public static void main(String[] strings) {
        TreeNode root = TreeNodeCreator.createTreeNode("10, 5, 15, #, #, 6, 20, 7");
        TreeNodePrinter.printNode(root);

        MinimumDepthOfTree validBalanceTree = new MinimumDepthOfTree();
        System.out.println(validBalanceTree.minDepth(root));
    }

    public int minDepth(TreeNode root) {

        if( root == null ) return 0;

        if( root.left == null && root.right == null ) return 1;

        int a = minDepth( root.left );
        int b = minDepth( root.right );

        if( a > 0 && b > 0 ) return Math.min(a,b)+1;

        return a + b + 1;
    }
}
