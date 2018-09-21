package com.leetcode.trappingrainwater;

/**
 * Created by titan-developer on 10/26/14.
 * https://oj.leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {

    public static void main(String[] strings) {
        int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //int[] a = {2, 0, 2};

        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(a));
    }

    public int trap(int[] A) {
        int a = 0;
        int b = A.length - 1;
        int max = 0;
        int leftmax = 0;
        int rightmax = 0;
        while (a <= b) {
            leftmax = Math.max(leftmax, A[a]);
            rightmax = Math.max(rightmax, A[b]);
            if (leftmax < rightmax) {
                max += (leftmax - A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                a++;
            } else {
                max += (rightmax - A[b]);
                b--;
            }
        }
        return max;
    }

    public int trapTwoPassByMyself(int[] a) {
        int size = 0;

        if (a == null || a.length < 2) {
            return 0;
        }

        int maxIndex = -1;
        int lastFrame = -1;
        int base = 0;
        int span = 0;

        for (int i = 0; i < a.length; i++) {
            if (lastFrame < 0) {
                if (a[i] > 0) {
                    lastFrame = a[i];
                    maxIndex = i;
                }
            } else {
                if (a[i] >= lastFrame) {
                    size += (lastFrame * span) - base;
                    lastFrame = a[i];
                    base = 0;
                    span = 0;
                    maxIndex = i;
                } else {
                    base += a[i];
                    span++;
                }

            }
        }

        base = 0;
        span = 0;
        lastFrame = -1;

        for (int i = a.length - 1; i >= maxIndex; i--) {
            if (lastFrame < 0) {
                if (a[i] > 0) {
                    lastFrame = a[i];
                }
            } else {
                if (a[i] >= lastFrame) {
                    size += (lastFrame * span) - base;
                    lastFrame = a[i];
                    base = 0;
                    span = 0;
                } else {
                    base += a[i];
                    span++;
                }

            }
        }

        return size;
    }
}
