package com.leetcode.buysellstock3;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BuySellStock3 {

    public static void main(String[] strings) {
        int[] p = {2, 1, 3, 3, 4, 8, 7};

        BuySellStock3 buySellStock = new BuySellStock3();
        System.out.println(buySellStock.maxProfit(p));
    }

    public int maxProfit(int[] prices) {
        // null check
        if (prices == null || prices.length <= 1) return 0;
        int len = prices.length;

        int[] historyProfit = new int[len];
        int[] futureProfit = new int[len];
        int valley = prices[0];
        int peak = prices[len - 1];
        int maxProfit = 0;

        // forward, calculate max profit until this time
        for (int i = 0; i < len; ++i) {
            valley = Math.min(valley, prices[i]);
            if (i > 0) {
                historyProfit[i] = Math.max(historyProfit[i - 1], prices[i] - valley);
            }
        }

        // backward, calculate max profit from now, and the sum with history
        for (int i = len - 1; i >= 0; --i) {
            peak = Math.max(peak, prices[i]);
            if (i < len - 1) {
                futureProfit[i] = Math.max(futureProfit[i + 1], peak - prices[i]);
            }
            maxProfit = Math.max(maxProfit, historyProfit[i] + futureProfit[i]);
        }
        return maxProfit;
    }
}
