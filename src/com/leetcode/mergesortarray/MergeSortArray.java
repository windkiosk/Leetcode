package com.leetcode.mergesortarray;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortArray {

    public static void main(String[] strings) {
        int a[] = {3, 5, 7, 9, 10, 0, 0 , 0 , 0};
        int b[] = {1, 2, 4, 8};

        MergeSortArray sorter = new MergeSortArray();
        sorter.merge(a, 5, b, 4);

        for (int v : a) {
            System.out.print(v + ", ");
        }
    }

    public void merge(int A[], int m, int B[], int n) {
        if (B == null || B.length == 0 || A == null || A.length == 0)
            return;

        int l = m + n;

        int left = m -1;
        int right = n - 1;

        for (int i = l - 1; i >= 0; i --) {
            if (right < 0 || (left >= 0 && A[left] > B[right])) {
                A[i] = A[left];
                left --;
            } else {
                A[i] = B[right];
                right --;
            }
        }
    }
}
