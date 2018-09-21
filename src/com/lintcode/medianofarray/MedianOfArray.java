package com.lintcode.medianofarray;

/**
 * Created by bod on 1/24/15.
 * http://lintcode.com/en/problem/median/
 *
 * http://discuss.codechef.com/questions/1489/find-median-in-an-unsorted-array-without-sorting-it
 */
public class MedianOfArray {

    public static void main(String[] strings) {
        int[] a = {7, 8, 19, 10, 1, 20, 51, 13};

        MedianOfArray medianOfArray = new MedianOfArray();
        for (int i = 1; i <= a.length; i++) {
            System.out.println(medianOfArray.selection_algorithm(a, 0, a.length - 1, i));
        }
        System.out.println("Median : " + medianOfArray.median(a));
    }

    public int median(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;

        return selection_algorithm(nums, 0, nums.length - 1, (nums.length + 1) / 2);
    }

    int selection_algorithm(int[] A, int left, int right, int kth) {
        for (; ; ) {
            int pivotIndex = partitions(A, left, right);          //Select the Pivot Between Left and Right
            int len = pivotIndex - left + 1;

            if (kth == len)
                return A[pivotIndex];

            else if (kth < len)
                right = pivotIndex - 1;

            else {
                kth = kth - len;
                left = pivotIndex + 1;
            }
        }
    }

    int partitions(int[] A, int low, int high) {
        int p = low, r = high, x = A[r], i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= x) {

                i = i + 1;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, r);
        return i + 1;
    }

    void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
