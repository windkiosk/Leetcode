package com.interviewproblems.covertarraytosorted;

/**
 * Created by bod on 11/30/2014.
 * http://tristan-interview.blogspot.com/2012/03/convert-array-into-sorted-array-with.html
 */
public class ConvertArrayToSorted {

    public static void main(String[] strings) {
        int[] arrA = {1, 2, 4, 4, 3, 5, 6};
        int[] arrB = {10, 3, 11, 12};
        int[] arrC = {9, 10, 9, 3, 3, 3, 4, 4};

        ConvertArrayToSorted convertArrayToSorted = new ConvertArrayToSorted();
        System.out.println(convertArrayToSorted.min_convert_cost(arrA));
        System.out.println(convertArrayToSorted.min_convert_cost(arrB));
        System.out.println(convertArrayToSorted.min_convert_cost(arrC));

        System.out.println(convertArrayToSorted.getNumOfOp(arrA));
        System.out.println(convertArrayToSorted.getNumOfOp(arrB));
        System.out.println(convertArrayToSorted.getNumOfOp(arrC));
    }

    //http://tristan-interview.blogspot.com/2012/03/convert-array-into-sorted-array-with.html
    public int min_convert_cost(int a[]) {
        int n = a.length;
        int[] dp = new int[n];
        int[] aggr = new int[n];

        aggr[0] = a[0];
        for (int i = 1; i < n; i++)
            aggr[i] = aggr[i - 1] + a[i];

        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                int cost_i = 0;

                if (a[i] >= a[j]) {
                    cost_i = dp[j] + aggr[i - 1] - aggr[j];
                } else {
                    cost_i += aggr[i - 1] - aggr[j];
                    while (j >= 0 && a[j] > a[i]) {
                        cost_i += a[j] - a[i];
                        j--;
                    }

                    cost_i += dp[j + 1];

                }
                if (cost_i < dp[i])
                    dp[i] = cost_i;

            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cost_i = dp[i] + aggr[n - 1] - aggr[i];
            if (cost_i < min) min = cost_i;
        }

        return min;
    }

    public int getNumOfOp(int[] arr) {

        int size = arr.length;
        int max = 0;
        for (int i = 0; i < size; i++) max = (arr[i] > max) ? arr[i] : max;
        int[][] dp = new int[size][max + 1];

        for (int j = 0; j <= max; j++) {
            if (arr[size - 1] >= j)
                dp[size - 1][j] = 0;
            else
                dp[size - 1][j] = arr[size - 1];
        }

        for (int i = size - 2; i > 0; i--) {
            for (int j = 0; j <= max; j++) {
                int minn = arr[i] + dp[i + 1][j]; //case where the element is deleted altogether

                if (j <= arr[i]) {
                    for (int k = j; k <= arr[i]; k++) {//we try decrementing to all possible values
                        minn = Math.min(minn, arr[i] - k + dp[i + 1][k]);
                    }
                }
                dp[i][j] = minn;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= arr[0]; i++)
            ans = Math.min(ans, (arr[0] - i) + dp[1][i]);

        return ans;
    }
}
