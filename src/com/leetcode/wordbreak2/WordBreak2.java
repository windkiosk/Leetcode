package com.leetcode.wordbreak2;

import java.util.*;

/**
 * Created by titan-developer on 9/3/14.
 * https://oj.leetcode.com/problems/word-break-ii/
 */
public class WordBreak2 {


//    static String s = "catsanddog";
//    static String[] dict = {"cat", "cats", "and", "sand", "dog"};

//    static String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
//    static String[] dict = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};

    static String s = "loveadog";
    static String[] dict = {"lov", "ea", "a", "dog", "love"};

    public static void main(String[] strings) {
        WordBreak2 wordBreakSolution = new WordBreak2();

        Set<String> set = new HashSet<String>();
        for (String str : dict) {
            set.add(str);
        }

        List<String> list = wordBreakSolution.wordBreakDP2(s, set);
        if (list == null || list.size() == 0) {
            System.out.println("No solution");
        } else {
            for (String breakStr : list) {
                System.out.println(breakStr);
            }
        }

    }

    Map<String, List<String>> results = new HashMap<String, List<String>>();

    //DP2
    public List<String> wordBreakDP2(String s, Set<String> dict) {
        List<String> words = new ArrayList<String>();

        int len = s.length();
        for (int i = 1; i <= len; i++) {
            String front = s.substring(0, i);
            if (dict.contains(front)) {
                if (i == len) {
                    words.add(front);
                } else {
                    String remain = s.substring(i, len);
                    List<String> remainSet = results.containsKey(remain) ?
                            results.get(remain) : wordBreakDP2(remain, dict);
                    if (remainSet != null) {
                        for (String item : remainSet) {
                            words.add(front + " " + item);
                        }
                        results.put(remain, remainSet);
                    }

                }
            }
        }
        return words;
    }

    //DP
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();

        if (s == null || s.length() == 0 || dict == null || dict.size() == 0)
            return result;
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[len] = true;
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int i = len - 1; i >= 0; i --) {
            for (int j = i; j < len; j ++) {
                String sub = s.substring(i, j + 1);
                if (dp[j + 1] && dict.contains(sub)) {
                    dp[i] = true;

                    if (map.containsKey(i)) {
                        List<Integer> list = map.get(i);
                        list.add(j + 1);
                    } else {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(j + 1);
                        map.put(i, list);
                    }
                }
            }
        }

        if (dp[0]) {
            collect(map, 0, 0, "", result, s);
        }

        return result;
    }

    private void collect(HashMap<Integer, List<Integer>> hashMap, int lastIndex, int index, String prefix, List<String> list, String ori) {
        String temp = ori.substring(lastIndex, index);
        prefix = prefix + " " + temp;

        if (index == ori.length()) {
            list.add(prefix.trim());
            return;
        }

        List<Integer> nextNode = hashMap.get(index);
        for (int nextIndex : nextNode) {
            collect(hashMap, index, nextIndex, prefix, list, ori);
        }
    }
}
