package com.leetcode.regularexpression;

/**
 * Created by titan-developer on 9/17/14.
 * https://oj.leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpression {


    /*
    Some examples:
    isMatchWrong("aa","a") → false
    isMatchWrong("aa","aa") → true
    isMatchWrong("aaa","aa") → false
    isMatchWrong("aa", "a*") → true
    isMatchWrong("aa", ".*") → true
    isMatchWrong("ab", ".*") → true
    isMatchWrong("aab", "c*a*b") → true
    */

    public static void main(String[] strings) {
        RegularExpression regularExpression = new RegularExpression();

        System.out.println(regularExpression.isMatchRecursive("bbbba", ".*a*a"));
        System.out.println(regularExpression.isMatchRecursive("ab", ".*c"));
        System.out.println(regularExpression.isMatchRecursive("aaa", "ab*a*c*a"));
        System.out.println(regularExpression.isMatchRecursive("aaa", "a*a"));
        System.out.println(regularExpression.isMatchRecursive("aa", "a"));
        System.out.println(regularExpression.isMatchRecursive("aa", "aa"));
        System.out.println(regularExpression.isMatchRecursive("aaa", "aa"));
        System.out.println(regularExpression.isMatchRecursive("aa", "a*"));
        System.out.println(regularExpression.isMatchRecursive("aa", ".*"));
        System.out.println(regularExpression.isMatchRecursive("ab", ".*"));
        System.out.println(regularExpression.isMatchRecursive("aab", "c*a*b"));


        System.out.println(regularExpression.isMatchDP("bbbba", ".*a*a"));
        System.out.println(regularExpression.isMatchDP("ab", ".*c"));
        System.out.println(regularExpression.isMatchDP("aaa", "ab*a*c*a"));
        System.out.println(regularExpression.isMatchDP("aaa", "a*a"));
        System.out.println(regularExpression.isMatchDP("aa", "a"));
        System.out.println(regularExpression.isMatchDP("aa", "aa"));
        System.out.println(regularExpression.isMatchDP("aaa", "aa"));
        System.out.println(regularExpression.isMatchDP("aa", "a*"));
        System.out.println(regularExpression.isMatchDP("aa", ".*"));
        System.out.println(regularExpression.isMatchDP("ab", ".*"));
        System.out.println(regularExpression.isMatchDP("aab", "c*a*b"));


        System.out.println(regularExpression.isMatchWrong("bbbba", ".*a*a"));
        System.out.println(regularExpression.isMatchWrong("ab", ".*c"));
        System.out.println(regularExpression.isMatchWrong("aaa", "ab*a*c*a"));
        System.out.println(regularExpression.isMatchWrong("aaa", "a*a"));
        System.out.println(regularExpression.isMatchWrong("aa", "a"));
        System.out.println(regularExpression.isMatchWrong("aa", "aa"));
        System.out.println(regularExpression.isMatchWrong("aaa", "aa"));
        System.out.println(regularExpression.isMatchWrong("aa", "a*"));
        System.out.println(regularExpression.isMatchWrong("aa", ".*"));
        System.out.println(regularExpression.isMatchWrong("ab", ".*"));
        System.out.println(regularExpression.isMatchWrong("aab", "c*a*b"));
    }

    //------------------------------------------------------------


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
            OPT[0][j] = (p.charAt(j - 1) == '*') && (j - 2 >= 0) && OPT[0][j - 2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                OPT[i][j] = ((OPT[i - 1][j - 1]) && equals(s, p, i - 1, j - 1))
                        || ((OPT[i - 1][j] || OPT[i][j - 1])
                        && (p.charAt(j - 1) == '*')
                        && equals(s, p, i - 1, j - 2))
                        || ((p.charAt(j - 1) == '*') && (j - 2 >= 0) && OPT[i][j - 2]);
            }
        }

        return OPT[m][n];
    }

    private boolean equals(String s, String p, int si, int pi) {
        return (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.');
    }

    //------------------------------------------------------------

    private boolean matchFirst(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }

        if (s.length() > 0 && p.length() > 0) {
            return s.substring(0, 1).equals(p.substring(0, 1)) || p.substring(0, 1).equals(".");
        }

        return false;
    }

    public boolean isMatchRecursive(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        if (s.length() == 0 && p.length() == 0) {
            return true;
        }

        if (p.length() > 1 && p.substring(1, 2).equals("*")) {
            if (isMatchRecursive(s, p.substring(2))) {
                return true;
            } else {
                while (matchFirst(s, p)) {
                    s = s.substring(1);
                    if (isMatchRecursive(s, p.substring(2))) {
                        return true;
                    }
                }
            }
        } else {
            if (s.length() == 0 || p.length() == 0) {
                return false;
            }

            if (matchFirst(s, p)) {
                return isMatchRecursive(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }

        return false;
    }

    //------------------------------------------------------------


    public boolean isMatch(String s, String p) {
        if (p == null || s == null || (s.length() > 0 && p.length() == 0)) {
            return false;
        }

        return match(s, p, 0, 0);
    }

    private boolean match(String s, String p, int l, int r) {
        if (l == s.length() && r == p.length()) {
            return true;
        }

        if (r < p.length() - 1 && p.charAt(r + 1) == '*') {
            if (match(s, p, l, r + 2)) {
                return true;
            } else {
                int index = l;
                while (isMatchFirst(s, p, index, r)) {
                    if(match(s, p, index + 1, r + 2))
                        return true;
                    index++;
                }
            }
        } else {
            if (isMatchFirst(s, p, l, r)) {
                return match(s, p, l + 1, r + 1);
            }
        }

        return false;
    }

    private boolean isMatchFirst(String s, String p, int l, int r) {
        return l < s.length() && r < p.length() && (s.charAt(l) == p.charAt(r) || p.charAt(r) == '.');
    }

    //------------------------------------------------------------

    public boolean isMatchWrong(String s, String p) {
        if (s == null || p == null || s.trim().length() == 0 || p.trim().length() == 0) {
            return false;
        }

        int index_p = 0;
        int index_s = 0;

        int spareCount = 0;
        String spareStr = "";

        while (index_p < p.length()) {
            String p_str = p.substring(index_p, index_p + 1);
            index_p++;
            boolean isWild = false;

            if (index_p < p.length()) {
                String wild = p.substring(index_p, index_p + 1);
                if (wild.equals("*")) {
                    isWild = true;
                    index_p++;
                }
            }

            if (index_s == s.length()) {
                if (isWild) {
                    continue;
                } else {
                    if (spareStr.equals(p_str) && spareCount > 0) {
                        spareCount--;
                    } else {
                        return false;
                    }
                }
            } else {
                String ss = s.substring(index_s, index_s + 1);
                if (p_str.equals(".") || p_str.equals(ss)) {
                    if (isWild) {
                        spareStr = ss;
                        spareCount++;
                        index_s++;
                        if (index_s >= s.length())
                            break;

                        ss = s.substring(index_s, index_s + 1);
                        while (p_str.equals(".") || p_str.equals(ss)) {
                            index_s++;

                            if (ss.equals(spareStr)) {
                                spareCount++;
                            } else {
                                spareStr = ss;
                                spareCount = 1;
                            }

                            if (index_s >= s.length()) {
                                break;
                            }
                            ss = s.substring(index_s, index_s + 1);
                        }
                    } else {
                        spareCount = 0;
                        spareStr = "";
                        index_s++;
                    }
                } else if (isWild) {
                    //index_p ++;
                } else {
                    return false;
                }
            }
        }

        if (index_p == p.length() && index_s == s.length()) {
            return true;
        }

        return false;
    }
}
