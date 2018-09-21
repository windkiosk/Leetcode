package com.leetcode.longestcommonprefix;

/**
 * Created by titan-developer on 10/20/14.
 * https://oj.leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public static void main(String[] strings) {

        String[] strs = {"abcdedjdjkhdhjkjkg", "abcd", "abc", "abdjjdjjfjdjld"};

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strings) {
        String prefix = "";

        if (strings == null || strings.length == 0) {
            return prefix;
        } else if (strings.length == 1) {
            return strings[0];
        }

        int k = 0;
        boolean isMatch = true;
        while (isMatch) {
            if (k >= strings[0].length()) {
                break;
            }

            char c = strings[0].charAt(k);
            for (int i = 1; i < strings.length; i++) {
                if (k >= strings[i].length()) {
                    isMatch = false;
                    break;
                }

                if (c != strings[i].charAt(k)) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                k++;
            }
        }

        return strings[0].substring(0, k);
    }
}
