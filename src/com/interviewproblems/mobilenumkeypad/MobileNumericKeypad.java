package com.interviewproblems.mobilenumkeypad;

/**
 * Created by titan-developer on 11/29/14.
 * http://www.geeksforgeeks.org/mobile-numeric-keypad-problem/
 */
public class MobileNumericKeypad {

    public static void main(String[] strings) {
        MobileNumericKeypad mobileNumericKeypad = new MobileNumericKeypad();
        System.out.println(mobileNumericKeypad.getCount(3));
    }

    public int getCount(int n) {

        int[] dp_last = new int[10];
        int[] dp = new int[10];
        for (int i = 0; i <= 9; i ++) {
            dp_last[i] = 1;
        }

        for (int i = 2; i <= n; i ++) {
            dp[0] = dp_last[0] + dp_last[8];
            dp[1] = dp_last[1] + dp_last[2] + dp_last[4];
            dp[2] = dp_last[1] + dp_last[2] + dp_last[3] + dp_last[5];
            dp[3] = dp_last[3] + dp_last[2] + dp_last[6];
            dp[4] = dp_last[4] + dp_last[1] + dp_last[5] + dp_last[7];
            dp[5] = dp_last[5] + dp_last[2] + dp_last[4] + dp_last[6] + dp_last[8];
            dp[6] = dp_last[6] + dp_last[3] + dp_last[5] + dp_last[9];
            dp[7] = dp_last[7] + dp_last[4] + dp_last[8];
            dp[8] = dp_last[8] + dp_last[5] + dp_last[7] + dp_last[9] + dp_last[0];
            dp[9] = dp_last[9] + dp_last[8] + dp_last[6];
            System.arraycopy(dp, 0, dp_last, 0, dp.length);
        }

        int sum = 0;
        for (int i = 0; i <= 9 ; i ++) {
            sum += dp[i];
        }

        return sum;
    }
}
