package com.leetcode.subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by titan-developer on 11/11/14.
 * https://oj.leetcode.com/problems/subsets-ii/
 */
public class Subsets2 {

    public static void main(String[] strings) {


        int[] s = {1, 2, 2};

        Subsets2 subsets = new Subsets2();
        List<List<Integer>> lists = subsets.subsetsWithDupEasy(s);

        for (List<Integer> list : lists) {
            for (int a : list) {
                System.out.print(a + ", ");
            }
            System.out.println();
        }
    }

    //https://oj.leetcode.com/discuss/14902/c-solution-and-explanation
    public List<List<Integer>> subsetsWithDupEasy(int[] S) {
        Arrays.sort(S);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        result.add(list);

        for (int i = 0; i < S.length;) {
            int count = 0; // num of elements are the same
            while (count + i < S.length && S[count + i] == S[i]) count++;
            int previousN = result.size();
            for (int k = 0; k < previousN; k++) {
                List<Integer> instance = new ArrayList<Integer>(result.get(k));
                for (int j = 0; j < count; j++) {
                    instance.add(S[i]);
                    result.add(new ArrayList<Integer>(instance));
                }
            }
            i += count;
        }
        return result;
    }

    public List<List<Integer>> subsetsWithDup(int[] S) {
        Arrays.sort(S);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        result.add(list);

        int oldval = S[0];
        int oldj = 0;
        for (int i = 0; i < S.length; i++) {
            int temp = oldj;
            if (S[i] != oldval) {
                oldval = S[i];
                temp = 0;
            }
            int j = result.size();
            oldj = j;
            while (j-- > temp) {
                //note temp here help avoid creating duplicate subsets
                ArrayList<Integer> newList = new ArrayList<Integer>(result.get(j));
                newList.add((S[i]));
                result.add(newList);
            }
        }
        return result;
    }


    public List<List<Integer>> subsets2DSP(int[] S) {
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

        int duplicateCount = 1;
        while (index + 1 < S.length && S[index + 1] == S[index]) {
            index++;
            duplicateCount++;
        }

        count = count - duplicateCount;

        for (int i = 0; i <= duplicateCount; i++) {

            for (int j = 1; j <= i; j++) {
                list.add(S[index]);
            }

            helper(S, index + 1, count, list, ret);

            for (int j = 1; j <= i; j++) {
                list.remove(list.size() - 1);
            }

        }
    }
}
