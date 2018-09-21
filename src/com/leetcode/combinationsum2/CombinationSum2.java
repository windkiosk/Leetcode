package com.leetcode.combinationsum2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by titan-developer on 10/28/14.
 * https://oj.leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSum2 {

    public static void main(String[] strings) {

        int a[] = {1, 1};
        //int a[] = {10, 1, 2, 7, 6, 1, 5};

        CombinationSum2 sum = new CombinationSum2();

        ArrayList<ArrayList<Integer>> solutions = sum.combinationSum2(a, 1);

        for (ArrayList solution : solutions) {
            for (int x = 0; x < solution.size(); x++) {
                System.out.print(solution.get(x) + ", ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0)
            return res;
        Arrays.sort(num);
        helper(num, 0, target, new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(int[] num, int start, int target, ArrayList<Integer> item,
                        ArrayList<ArrayList<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        if (target < 0 || start >= num.length)
            return;
        for (int i = start; i < num.length; i++) {
            if (i > start && num[i] == num[i - 1]) continue;
            item.add(num[i]);
            helper(num, i + 1, target - num[i], item, res);
            item.remove(item.size() - 1);
        }
    }
}
