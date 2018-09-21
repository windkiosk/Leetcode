package com.leetcode.palindromepartitioning1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by titan-developer on 10/25/14.
 * https://oj.leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning1 {

    public static void main(String[] strings) {

        String s = "xaabaa";
        //String s = "x";

        PalindromePartitioning1 partitioning1 = new PalindromePartitioning1();

        List<List<String>> result = partitioning1.partition(s);

        for (List<String> list : result) {
            System.out.println(list);
        }
    }

    //-------------------------- cool solution ----------------------------------

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());

        boolean[][] pair = new boolean[len][len];
        for (int i = 0; i < s.length(); i++) {
            result[i + 1] = new ArrayList<List<String>>();
            char c = s.charAt(i);
            for (int j = 0; j <= i; j++) {
                if (j == i)
                    pair[j][i] = true;
                else {
                    if (s.charAt(j) != c)
                        continue;
                    if (j == i - 1)
                        pair[j][i] = true;
                    else
                        pair[j][i] = pair[j + 1][i - 1];
                }
                if (pair[j][i]) {
                    String str = s.substring(j, i + 1);
                    for (List<String> r : result[j]) {
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        result[i + 1].add(ri);
                    }
                }
            }
        }

        return result[len];
    }

    //------------------------------------------------------------

    public List<List<String>> partition_2(String s) {

        List<List<String>> result = new LinkedList<List<String>>();

        int n = s.length();
        if (n < 2) {
            List<String> r1 = new ArrayList<String>();
            r1.add(s);
            result.add(r1);
            return result;
        }

        int start = 0;
        int end = 0;

        boolean[][] M = new boolean[n][n]; // all initialized to false, by default
        M[n - 1][n - 1] = true;
        for (int i = 0; i < n - 1; ++i) {
            M[i][i] = true;
            M[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));

            if (M[i][i + 1]) {
                start = i;
                end = i + 1;
            }
        }

        for (int step = 2; step < n; ++step) {
            for (int i = 0; i <= n - 1 - step; ++i) {
                M[i][i + step] = M[i + 1][i + step - 1] && s.charAt(i) == s.charAt(i + step);
                if (M[i][i + step]) {
                    start = i;
                    end = i + step;
                }
            }
        }

        List<List<Integer>> intResult = searchPartition(M, 0);

        for (List<Integer> list : intResult) {
            System.out.println(list);
            List<String> strList = new ArrayList<String>();

            int lastIndex = 0;
            for (int i : list) {
                String tmp = s.substring(lastIndex, i + 1);
                lastIndex = i + 1;
                strList.add(tmp);
            }

            result.add(strList);
        }

        return result;
    }

    private List<List<Integer>> searchPartition(boolean[][] m, int level) {
        System.out.println("searching level : " + level);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (level >= m.length) {
            return result;
        }

        for (int i = level; i < m[level].length; i++) {
            if (m[level][i]) {
                if (i == m[level].length - 1) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    result.add(list);
                } else {
                    List<List<Integer>> subResult = searchPartition(m, i + 1);
                    for (List<Integer> list : subResult) {
                        if (list.get(list.size() - 1) == m[level].length - 1) {
                            list.add(0, i);
                        }
                        result.add(list);
                    }
                }
            }
        }

        return result;
    }
}
