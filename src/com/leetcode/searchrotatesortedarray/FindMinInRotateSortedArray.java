package com.leetcode.searchrotatesortedarray;

/**
 * Created by titan-developer on 10/20/14.
 * <p/>
 * Below solution works both for :
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinInRotateSortedArray {

    public static void main(String[] strings) {
        int array[] = {1, 1, 1, 1, 1, 1, 1, 0, 0, 1};

        FindMinInRotateSortedArray findMin = new FindMinInRotateSortedArray();

        System.out.println(findMin.findMin(array));
    }

    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }

        int l = 0, r = num.length - 1;

        while (num[l] == num[r] && l < r) {
            l ++;
        }

        if (l == r || num[l] < num[r]) {
            return num[l];
        }

        while (l <= r) {
            int m = l + (r - l) / 2;

            if (m > 0 && num[m - 1] > num[m]) {
                return num[m];
            }

            if (num[m] > num[m + 1]) {
                return num[m + 1];
            }

            if (num[m] <= num[r]) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}
