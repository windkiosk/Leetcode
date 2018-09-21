package com.lintcode.backpackii;

/**
 * Created by bod on 1/25/15.
 */
public class BackPackII {

    public static void main(String[] strings) {
        int[] size = {2, 3, 5, 7};
        int[] value = {1, 5, 2, 4};

        BackPackII backPackII = new BackPackII();
        System.out.println(backPackII.backPackII(10, size, value));
    }


    public int backPackII(int m, int[] wt, int V[]) {
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
                    curr[w] = Math.max(V[i - 1] + last[w - wt[i - 1]], last[w]);
                else
                    curr[w] = last[w];
            }
        }

        return curr[m];
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
}
