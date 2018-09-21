package com.leetcode.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by titan-developer on 11/7/14.
 * https://oj.leetcode.com/problems/subsets/
 */
public class Subsets {

    public static void main(String[] strings) {

        int[] s = new int[5];

        for (int i = 0; i < 5; i ++) {
            s[i] = i;
        }

        Subsets subsets = new Subsets();

        long start = System.currentTimeMillis();
        List<List<Integer>> lists = subsets.subsets(s);
        System.out.println("time : " + (System.currentTimeMillis() - start));

        for (List<Integer> list : lists) {
            for (int a : list) {
                System.out.print(a + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        int totalNumber = 1 << S.length;
        List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
        for (int i = 0; i < totalNumber; i++) {
            List<Integer> set = new LinkedList<Integer>();
            for (int j = 0; j < S.length; j++) {
                if ((i & (1 << j)) != 0) {
                    set.add(S[j]);
                }
            }
            collection.add(set);
        }
        return collection;
    }

    public List<List<Integer>> subsetsIterative(int[] S) {
        Arrays.sort(S);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        result.add(list);

        for (int i = 0; i < S.length; ++i) {
            int j = result.size();
            while (j-- > 0) {
                ArrayList<Integer> newList = new ArrayList<Integer>(result.get(j));
                newList.add((S[i]));
                result.add(newList);
            }
        }
        return result;
    }

    public List<List<Integer>> subsetsDSP(int[] S) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (S == null || S.length == 0) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }

        Arrays.sort(S);

        List<Integer> list = new ArrayList<Integer>();
        helper(S, 0, S.length, list, ret);
        return ret;
    }

    private void helper(int[] S, int index, int count, List<Integer> list, List<List<Integer>> ret) {
        if (count == 0) {
            List<Integer> newList = new ArrayList<Integer>(list);
            ret.add(newList);
            return;
        }

        count --;
        helper(S, index + 1, count, list, ret);

        list.add(S[index]);
        helper(S, index + 1, count, list, ret);
        list.remove(list.size() - 1);
    }

}
