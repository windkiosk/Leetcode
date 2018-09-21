package com.leetcode.sqrt;

/**
 * Created by titan-developer on 11/5/14.
 * https://oj.leetcode.com/problems/sqrtx/
 */
public class SqrtImpl {

    public static void main(String[] strings) {
        SqrtImpl sqrt = new SqrtImpl();
        System.out.println(sqrt.sqrt(3));
    }

    public int sqrt(int x) {
        if (0 == x) return 0;
        int left = 1, right = x, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
