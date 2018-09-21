package com.leetcode.combinationsum;

import java.util.*;

/**
 * Created by titan-developer on 10/28/14.
 * https://oj.leetcode.com/problems/combination-sum/
 */
public class CombinationSum {

    public static void main(String[] strings) {

        int a[] = {2, 3, 5, 6, 7, 9};

        CombinationSum sum = new CombinationSum();

        ArrayList<ArrayList> solutions = sum.combinationSum(a, 12);

        for (ArrayList solution : solutions) {
            for (int x = 0; x < solution.size(); x ++) {
                System.out.print(solution.get(x) + ", ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList> result = new ArrayList<ArrayList>();
        if (candidates == null || candidates.length == 0)
            return result;

        Arrays.sort(candidates);
        if (candidates[0] > target)
            return result;

        ArrayList one = new ArrayList();
        find(candidates, 0, candidates.length, target, result, one);
        return result;
    }

    private void find(int[] candidates, int start, int end, int target, ArrayList<ArrayList> result, ArrayList one) {
        if (target == 0) {
            result.add(new ArrayList(one));
            return;
        }

        for (int i = start; i < end; i++) {
            if (target < candidates[i])
                continue;

            one.add(candidates[i]);
            target -= candidates[i];

            find(candidates, i, end, target, result, one);
            target += (Integer)one.remove(one.size() - 1);
        }
    }

    public List<List<Integer>> combinationSumDP(int[] candidates, int target) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return solutions;
        }

        //Arrays.sort(candidates);

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(candidates.length);
        for (int i = 0; i < candidates.length; i++)
            map.put(candidates[i], candidates[i]);

        List dp[] = new ArrayList[target + 1];

        for (int i = 1; i <= target; i++) {


            for (int j = i; j >= 1; j--) {
                if (map.containsKey(j) && (i == j || dp[i - j] != null)) {
                    if (i == j) {
                        if (dp[i] == null) {
                            dp[i] = new ArrayList<List<Integer>>();
                        }
                        List<List<Integer>> iSolutions = (List<List<Integer>>) dp[i];
                        List<Integer> newList = new ArrayList<Integer>();
                        newList.add(j);
                        iSolutions.add(newList);
                    } else {
                        List<List<Integer>> subSolutions = (List<List<Integer>>) dp[i - j];
                        if (dp[i] == null) {
                            dp[i] = new ArrayList<List<Integer>>();
                        }
                        List<List<Integer>> iSolutions = (List<List<Integer>>) dp[i];

                        for (List<Integer> list : subSolutions) {
                            List<Integer> newList = new LinkedList<Integer>(list);
                            newList.add(0, j);
                            iSolutions.add(newList);
                        }
                    }
                }
            }

        }

        return solutions;
    }
}
