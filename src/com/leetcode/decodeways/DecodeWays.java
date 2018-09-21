package com.leetcode.decodeways;

/**
 * Created by titan-developer on 11/11/14.
 * https://oj.leetcode.com/problems/decode-ways/
 */
public class DecodeWays {

    public static void main(String[] strings) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("12532910"));
        System.out.println(decodeWays.numDecodings("230"));
        System.out.println(decodeWays.numDecodings("12512378"));
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int[] dp = new int[s.length() + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            char pre = s.charAt(i - 2);

            if (c == '0') {
                if (pre == '0') {
                    return 0;
                } else {
                    int v = (pre - '0') * 10 + (c - '0');
                    if (v <= 26) {
                        dp[i] = dp[i - 2];
                    } else {
                        return 0;
                    }
                }
            } else if (pre != '0') {
                int v = (pre - '0') * 10 + (c - '0');
                if (v <= 26) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[s.length()];
    }
}
