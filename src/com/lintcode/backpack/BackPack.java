package com.lintcode.backpack;

/**
 * Created by bod on 1/24/15.
 * http://lintcode.com/problem/backpack
 */
public class BackPack {

    public static void main(String[] strings) {
        int[] a = {81,112,609,341,164,601,97,709,944,828,627,730,460,523,643,901,602,508,401,442,738,443,555,
                471,97,644,184,964,418,492,920,897,99,711,916,178,189,202,72,692,86,716,588,297,512,605,209,
                100,107,938,246,251,921,767,825,133,465,224,807,455,179,436,201,842,325,694,132,891,973,107,
                284,203,272,538,137,248,329,234,175,108,745,708,453,101,823,937,639,485,524,660,873,367,153,
                191,756,162,50,267,166,996,552,675,383,615,985,339,868,393,178,932};
        BackPack backPack = new BackPack();
        System.out.println(backPack.backPack(80000, a));
    }

    public int backPack(int m, int[] wt) {
        int i, w, n = wt.length;
        int[] last = new int[m + 1];
        int[] curr = new int[m + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            int[] tmp = curr;
            curr = last;
            last = tmp;
            for (w = 0; w <= m; w++) {
                if (i == 0 || w == 0)
                    curr[w] = 0;
                else if (wt[i - 1] <= w)
                    curr[w] = Math.max(wt[i - 1] + last[w - wt[i - 1]], last[w]);
                else
                    curr[w] = last[w];
            }
        }

        return curr[m];
    }

    // Returns the maximum value that can be put in a knapsack of capacity W
    int knapSack(int W, int wt[], int n) {
        int i, w;
        int[][] K = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(wt[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

    // Returns the maximum value that can be put in a knapsack of capacity W
    int knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int[][] K = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

    //---------------------------------------------------
    // Returns the maximum value that can be put in a knapsack of capacity W
    int knapSackRecursive(int W, int wt[], int n) {
        System.out.println("W : " + W + " , n : " + n);
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n - 1] > W)
            return knapSackRecursive(W, wt, n - 1);

            // Return the maximum of two cases: (1) nth item included (2) not included
        else
            return Math.max(wt[n - 1] + knapSackRecursive(W - wt[n - 1], wt, n - 1),
                    knapSackRecursive(W, wt, n - 1)
            );
    }

    // Returns the maximum value that can be put in a knapsack of capacity W
    int knapSackRecursive(int W, int wt[], int val[], int n) {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n - 1] > W)
            return knapSackRecursive(W, wt, val, n - 1);

            // Return the maximum of two cases: (1) nth item included (2) not included
        else
            return Math.max(val[n - 1] + knapSackRecursive(W - wt[n - 1], wt, val, n - 1),
                    knapSackRecursive(W, wt, val, n - 1)
            );
    }
}
