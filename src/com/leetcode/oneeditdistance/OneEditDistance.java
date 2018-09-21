package com.leetcode.oneeditdistance;

/**
 *
 * https://oj.leetcode.com/problems/one-edit-distance/
 *
 * Created by titan-developer on 12/9/14.
 *
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class OneEditDistance {

    public static void main(String[] strings) {
        OneEditDistance oneEditDistance = new OneEditDistance();
        System.out.println(oneEditDistance.isOneEditDistance("abcde", "bcde"));
        System.out.println(oneEditDistance.isOneEditDistance("abcde", "abxde"));
        System.out.println(oneEditDistance.isOneEditDistance("abcde", "acxde"));
    }

    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();

        if (m > n)
            return isOneEditDistance(t, s);

        if (n - m > 1)
            return false;

        int i = 0, shift = n - m;
        while (i < m && s.charAt(i) == t.charAt(i))
            i ++;

        if (i == m)
            return shift > 0; // if two string are the same (shift == 0), return false

        if (shift == 0)
            i++; // if n==m skip current char in s (modify operation in s)

        while (i < m && s.charAt(i) == t.charAt(i + shift))
            i++; // use shift to skip one char in t
        return i == m;
    }
}
