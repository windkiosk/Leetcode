package com.leetcode.buysellstock2;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BuySellStock2 {

    public static void main(String[] strings) {
        int[] p = {2, 1, 3, 3, 4, 8, 7};

        BuySellStock2 buySellStock = new BuySellStock2();
        System.out.println(buySellStock.maxProfit(p));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        if (prices == null || prices.length <= 1) {
            return maxProfit;
        }

        int current = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > current) {
                maxProfit += prices[i] - current;
            }
            current = prices[i];
        }

        return maxProfit;
    }
}
