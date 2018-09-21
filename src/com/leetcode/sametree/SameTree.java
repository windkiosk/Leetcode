package com.leetcode.sametree;

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeNodeCreator;

import java.util.ArrayList;

/**
 * Created by bod on 9/1/14.
 * https://oj.leetcode.com/problems/same-tree/
 */
public class SameTree {

    public static void main(String[] strings) {
        TreeNode rootP = TreeNodeCreator.createTreeNode("1, 2, 3, #, 4, #, 5");
        TreeNode rootQ = TreeNodeCreator.createTreeNode("1, 2, 3, #, 4, #, 5");

        SameTree sameTree = new SameTree();
        System.out.println(sameTree.isSameTree(rootP, rootQ));
        System.out.println(sameTree.isSameTreeNonRecursive(rootP, rootQ));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }

            boolean leftCheck = isSameTree(p.left, q.left);
            boolean rightCheck = isSameTree(p.right, q.right);
            return leftCheck && rightCheck;
        }

        return false;
    }

    public boolean isSameTreeNonRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null) {
            ArrayList<TreeNode> pArray = new ArrayList<TreeNode>();
            ArrayList<TreeNode> qArray = new ArrayList<TreeNode>();
            pArray.add(p);
            qArray.add(q);
            int lastLevel = 1;
            while (true) {
                int currentLevel = 0;
                for (int i = 0; i < lastLevel; i++) {
                    TreeNode pTemp = pArray.get(0);
                    TreeNode qTemp = qArray.get(0);

                    if (pTemp.val != qTemp.val) {
                        return false;
                    }

                    if (pTemp.left == null && qTemp.left == null) {
                    } else if (pTemp.left != null && qTemp.left != null) {
                        pArray.add(pTemp.left);
                        qArray.add(qTemp.left);
                        currentLevel++;
                    } else {
                        return false;
                    }

                    if (pTemp.right == null && qTemp.right == null) {
                    } else if (pTemp.right != null && qTemp.right != null) {
                        pArray.add(pTemp.right);
                        qArray.add(qTemp.right);
                        currentLevel++;
                    } else {
                        return false;
                    }

                    pArray.remove(0);
                    qArray.remove(0);
                }

                if (pArray.size() == 0 && qArray.size() == 0) {
                    return true;
                }

                lastLevel = currentLevel;
            }
        }

        return false;
    }
}
