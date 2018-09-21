package com.leetcode.wildcardmatching;

/**
 * Created by titan-developer on 10/30/14.
 * https://oj.leetcode.com/problems/wildcard-matching/
 */
public class WildcardMatching {

    public static void main(String[] strings) {

        WildcardMatching wildcardMatching = new WildcardMatching();
        System.out.println(wildcardMatching.isMatch("abcba", "a*ba"));
        System.out.println(wildcardMatching.isMatch("aa", "aa"));
        System.out.println(wildcardMatching.isMatch("aaa", "aa"));
        System.out.println(wildcardMatching.isMatch("aa", "*"));
        System.out.println(wildcardMatching.isMatch("aa", "a*"));
        System.out.println(wildcardMatching.isMatch("ab", "?*"));

    }

    //https://oj.leetcode.com/discuss/10133/linear-runtime-and-constant-space-solution
    public boolean isMatch(String str, String pattern) {
        int s = 0, p = 0, match = 0, starIdx = -1;
        while (s < str.length()) {
            // advancing both pointers
            if (p < pattern.length() && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*') {
                starIdx = p;
                match = s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1) {
                p = starIdx + 1;
                match++;
                s = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
    }

    public boolean isMatchDP(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int m = s.length();
        int n = p.length();

        boolean[][] OPT = new boolean[m + 1][n + 1];
        OPT[0][0] = true;

        for (int i = 1; i <= m; i++) {
            OPT[i][0] = false;
        }
        for (int j = 1; j <= n; j++) {
            OPT[0][j] = (p.charAt(j - 1) == '*') && OPT[0][j - 1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                OPT[i][j] = ((OPT[i - 1][j - 1]) && equals(s, p, i - 1, j - 1))
                        || ((p.charAt(j - 1) == '*') && (OPT[i - 1][j] || OPT[i][j - 1] || hasMatch(OPT, i, j - 1)));
            }
        }

        return OPT[m][n];
    }

    private boolean hasMatch(boolean[][] OPT, int i, int j) {
        if (i < 0 || j < 0)
            return false;

        for (int m = 0; m <= j; m++) {
            if (OPT[i][m]) {
                return true;
            }
        }

        return false;
    }

    private boolean equals(String s, String p, int si, int pi) {
        return (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '?');
    }
}
