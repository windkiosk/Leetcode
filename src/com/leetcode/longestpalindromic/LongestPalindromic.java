package com.leetcode.longestpalindromic;

/**
 * Created by bod on 9/9/14.
 * https://oj.leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromic {

    static String testStr = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    public static void main(String[] strings) {
        LongestPalindromic palindromic = new LongestPalindromic();

        long time = System.currentTimeMillis();
        System.out.println(palindromic.longestPalindrome(testStr));
        System.out.println(System.currentTimeMillis() - time);
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;

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

        return s.substring(start, end + 1);
    }

    public String longestPalindromeFailedOne(String s) {
        if (s == null)
            return null;

        int length = s.length();
        int[][] f = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int m = 0; m < length; m++) {
                f[i][m] = -1;
            }
            f[i][i] = 2;
        }

        int start = -1;
        int maxGap = -1;

        int gap = 1;
        while (gap < length) {
            for (int i = 0; i < length; i++) {
                if (i + gap >= length) {
                    break;
                }
                if (f[i][i + gap - 1] == 2) {
                    if (s.substring(i + gap - 1, i + gap).equals(s.subSequence(i + gap, i + gap + 1))) {
                        f[i][i + gap] = 2;

                        if (gap > maxGap) {
                            maxGap = gap;
                            start = i;
                        }
                    } else {
                        f[i][i + gap] = 0;
                    }
                } else {
                    if (gap > 1) {
                        if (f[i + 1][i + gap - 1] > 0) {
                            if (s.subSequence(i, i + 1).equals(s.subSequence(i + gap, i + gap + 1))) {
                                f[i][i + gap] = 1;

                                if (gap > maxGap) {
                                    maxGap = gap;
                                    start = i;
                                }
                            }
                        } else {
                            f[i][i + gap] = 0;
                        }
                    } else {
                        f[i][i + gap] = 0;
                    }
                }
            }

            gap++;
        }

        if (maxGap > 0 && start >= 0) {
            return s.subSequence(start, start + maxGap + 1).toString();
        } else {
            return null;
        }
    }
}
