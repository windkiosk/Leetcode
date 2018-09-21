package com.leetcode.distinctsubstring;

/**
 * Created by titan-developer on 11/12/14.
 * https://oj.leetcode.com/problems/distinct-subsequences/
 */
public class DistinctSubstring {

    public static void main(String[] strings) {
        DistinctSubstring distinctSubstring = new DistinctSubstring();
        System.out.println(distinctSubstring.numDistinct("rabbbit", "rabbit"));
    }

    public int numDistinct(String S, String T) {
        int m = T.length();
        int n = S.length();
        if (m > n) return 0;    // impossible for subsequence

        int[] path = new int[m + 1];
        path[0] = 1;            // initial condition

        for (int j = 1; j <= n; j++) {
            // traversing backwards so we are using path[i-1] from last time step
            for (int i = m; i >= 1; i--) {
                path[i] = path[i] + (T.charAt(i - 1) == S.charAt(j - 1) ? path[i - 1] : 0);
            }
        }

        return path[m];
    }
}
