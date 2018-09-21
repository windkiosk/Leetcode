package com.leetcode.searchrotatesortedarray;

/**
 * Created by titan-developer on 9/15/14.
 * Similar to https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindXForRotateSortedArray {

    public static void main(String[] strings) {
        int[] array = {6, 7, 0, 1, 2, 4, 5};
        int[] array2 = {2, 1};
        int[] array3 = {9, 10, 11, 12, 13, 14, 1, 2, 3, 4, 5, 6, 7, 8};
        FindXForRotateSortedArray rotateSortedArray = new FindXForRotateSortedArray();
        System.out.println(rotateSortedArray.findSortedArrayRotation2(array));
        System.out.println(rotateSortedArray.findSortedArrayRotation2(array2));
        System.out.println(rotateSortedArray.findSortedArrayRotation2(array3));

        System.out.println(rotateSortedArray.findSortedArrayRotation(array, array.length));
        System.out.println(rotateSortedArray.findSortedArrayRotation(array2, array2.length));
        System.out.println(rotateSortedArray.findSortedArrayRotation(array3, array3.length));
    }

    int findSortedArrayRotation(int A[], int N) {
        int L = 0;
        int R = N - 1;

        while (A[L] > A[R]) {
            int M = L + (R - L) / 2;
            if (A[M] > A[R])
                L = M + 1;
            else
                R = M;
        }
        return L;
    }

    int findSortedArrayRotation2(int array[]) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int length = array.length;

        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int pivot = (right - left) / 2 + left;

            if (pivot > 0 && array[pivot - 1] > array[pivot]) {
                return pivot;
            }

            if (array[pivot] > array[pivot + 1]) {
                return pivot + 1;
            }

            //upper sorted array
            if (array[pivot] <= array[right]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }

        return -1;
    }
}
