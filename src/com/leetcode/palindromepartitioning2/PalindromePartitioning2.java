package com.leetcode.palindromepartitioning2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 10/25/14.
 * https://oj.leetcode.com/problems/palindrome-partitioning-ii/
 */
public class PalindromePartitioning2 {

    public static void main(String[] strings) {

        //String s = "ababababababababababababcbabababababababababababa";
        String s = "xaabaac";

        PalindromePartitioning2 partitioning2 = new PalindromePartitioning2();

        System.out.println(partitioning2.minCut(s));
    }

    public int minCut(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        boolean m[][] = new boolean[n][n];
        int d[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            d[i] = n - i - 1;
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || m[i + 1][j - 1])) {
                    m[i][j] = true;
                    if (j == n - 1)
                        d[i] = 0;
                    else if (d[j + 1] + 1 < d[i])
                        d[i] = d[j + 1] + 1;
                }
            }
        }
        return d[0];
    }
}
