package com.leetcode.scramblestring;

import java.util.Arrays;

/**
 * Created by titan-developer on 11/8/14.
 * https://oj.leetcode.com/problems/scramble-string/
 */
public class ScrambleString {

    public static void main(String[] strings) {
        ScrambleString scrambleString = new ScrambleString();
        System.out.println(scrambleString.isScramble("abc", "abc"));
        System.out.println(scrambleString.isScramble("great", "rgeat"));
        System.out.println(scrambleString.isScrambleDP("great", "rgeat"));
    }

    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!Arrays.equals(c1, c2)) return false;
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                return true;
        }
        return false;
    }

    public boolean isScrambleDP(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) return false;
        if (s1.length() == 0 || s1.equals(s2)) return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!Arrays.equals(c1, c2)) return false;
        boolean[][][] res = new boolean[s1.length()][s2.length()][s1.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                res[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int len = 2; len <= s1.length(); len++) {
            for (int i = 0; i < s1.length() - len + 1; i++) {
                for (int j = 0; j < s2.length() - len + 1; j++) {
                    for (int k = 1; k < len; k++) {
                        res[i][j][len] |= res[i][j][k] && res[i + k][j + k][len - k] || res[i][j + len - k][k] && res[i + k][j][len - k];
                    }
                }
            }
        }
        return res[0][0][s1.length()];
    }
}
