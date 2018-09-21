package com.leetcode.rotatearray;

import java.util.Arrays;

/**
 * https://oj.leetcode.com/problems/rotate-array/
 * Created by bod on 2/25/15.
 */
public class RotateArray {
    public static void main(String[] strings) {
        RotateArray rotateArray = new RotateArray();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        rotateArray.rotate2(a, 2);
        //rotateArray.rotate(a, 10);
        System.out.println(Arrays.toString(a));
    }

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int l = nums.length;
        k %= l;
        if (k == 0) return;
        reverse(nums, 0, l - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, l - 1);
    }

    private void reverse(int[] nums, int from, int end) {
        while (from < end) {
            swap(nums, from, end);
            from++;
            end--;
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    //------------------------------------------------------

    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        int l = nums.length;
        k %= l;
        if (k == 0) return;
        int start = 0, index = 0, last = nums[0];
        for (int i = 0; i < l; i ++) {
            index = (index + k) % l;
            int tmp = nums[index];
            nums[index] = last;
            last = tmp;
            if (index == start) {
                start ++;
                index = start;
                last = nums[start];
            }
        }
    }
}
