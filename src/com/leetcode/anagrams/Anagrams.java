package com.leetcode.anagrams;

import java.util.*;

/**
 * Created by titan-developer on 11/3/14.
 * https://oj.leetcode.com/problems/anagrams/
 */
public class Anagrams {

    public static void main(String[] strings) {
        String[] a = {"dog","cat","god","tac", "abc", "cde"};

        Anagrams anagrams = new Anagrams();
        List<String> result = anagrams.anagrams(a);

        for (String val : result) {
            System.out.print(val + ", ");
        }
    }

    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if (strs == null || strs.length < 2) {
            return result;
        }

        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (hashMap.containsKey(key)) {
                List<String> list = hashMap.get(key);
                list.add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                hashMap.put(key, list);
            }
        }

        Iterator<List<String>> iterator = hashMap.values().iterator();
        while (iterator.hasNext()) {
            List<String> list = iterator.next();
            if (list.size() >= 2) {
                result.addAll(list);
            }
        }

        return result;
    }
}
