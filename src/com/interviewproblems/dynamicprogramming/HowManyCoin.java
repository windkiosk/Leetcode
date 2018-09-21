package com.interviewproblems.dynamicprogramming;

/**
 * Created by titan-developer on 8/23/14.
 * Given coins with values 1, 3, and 5.
 * And the sum S is set to be 11.
 */
public class HowManyCoin {
    static int[] coinValue = new int[]{1, 3, 5};

    public static void main(String[] strings) {
        HowManyCoin howManyCoin = new HowManyCoin();

        int a = howManyCoin.findMinCoins(11);
        System.out.println("11 -----> " + a);
        int b = howManyCoin.findMinCoins(14);
        System.out.println("14 -----> " + b);
        int c = howManyCoin.findMinCoins(17);
        System.out.println("17 -----> " + c);
    }

    public int findMinCoins(int value) {
        int[] minValues = null;
        if (value > 0) {
            minValues = new int[value + 1];
            minValues[0] = 0;

            for (int i = 1; i <= value; i++) {
                minValues[i] = Integer.MAX_VALUE;
                int lastCoin = -1;
                int lastMin = -1;
                for (int m = 0; m < coinValue.length; m++) {
                    if (coinValue[m] <= i) {
                        if (minValues[i - coinValue[m]] + 1 < minValues[i]) {
                            minValues[i] = minValues[i - coinValue[m]] + 1;
                            lastCoin = coinValue[m];
                            lastMin = i - lastCoin;
                        }
                    }
                }
                System.out.println(lastMin + " , " + lastCoin);
            }
        }

        if (minValues == null) {
            return -1;
        } else {
            return minValues[value];
        }
    }
}
