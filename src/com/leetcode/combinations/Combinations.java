package com.leetcode.combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/7/14.
 * https://oj.leetcode.com/problems/combinations/
 */
public class Combinations {

    public static void main(String[] strings) {

        Combinations combinations = new Combinations();
        List<List<Integer>> lists = combinations.combine(4, 2);

        for (List<Integer> list : lists) {
            for (int a : list) {
                System.out.print(a + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combine(n, k, 1, result, new ArrayList<Integer>());
        return result;
    }

    public void combine(int n, int k , int start, List<List<Integer>> result, ArrayList<Integer> l){
        if(k == 0){
            result.add(l);
            return;
        }
        for(int i = start; i <= n; ++i){
            ArrayList<Integer> a = (ArrayList<Integer>) l.clone();
            a.add(i);
            combine(n, k - 1, i + 1, result, a);
        }
    }

    public List<List<Integer>> combineDFS(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (n < k) return ret;

        List<Integer> current = new ArrayList<Integer>();
        dfs(1, n, k, current, ret);
        return ret;
    }

    void dfs(int start, int end, int k, List<Integer> current, List<List<Integer>> ret) {
        if (k == 0) {
            List<Integer> newList = new ArrayList<Integer>(current);
            ret.add(newList);
            return;
        }

        for (int i = start; i <= end; i ++) {
            current.add(i);
            dfs(i + 1, end, k - 1, current, ret);
            current.remove(current.size() - 1);
        }
    }
}
