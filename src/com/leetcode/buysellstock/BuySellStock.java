package com.leetcode.buysellstock;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BuySellStock {

    public static void main(String[] strings) {
        int[] p = {2, 1, 3, 3, 4, 8, 7};

        BuySellStock buySellStock = new BuySellStock();
        System.out.println(buySellStock.maxProfit(p));
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        if (prices == null || prices.length <= 1) {
            return maxProfit;
        }

        int min = prices[0], max = prices[0];

        for (int i = 1; i < prices.length; i ++) {
            if (prices[i] > max) {
                max = prices[i];
                if (max - min > maxProfit) {
                    maxProfit = max - min;
                }
            } else if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            }
        }

        return maxProfit;
    }
}
