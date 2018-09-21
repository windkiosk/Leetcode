package com.leetcode.searchrotatesortedarray;

/**
 * Created by titan-developer on 9/15/14.
 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchElementInRotateSortedArray {

    public static void main(String[] strings) {
        int[] array = {6, 7, 0, 1, 2, 4, 5};
        SearchElementInRotateSortedArray searchElementInRotateSortedArray = new SearchElementInRotateSortedArray();
        System.out.println(searchElementInRotateSortedArray.search(array, 4));
        System.out.println(searchElementInRotateSortedArray.search(array, 7));


        int[] array2 = {2, 1};
        System.out.println(searchElementInRotateSortedArray.search(array2, 1));
        System.out.println(searchElementInRotateSortedArray.rotated_binary_search(array2, 2, 1));

    }

    int rotated_binary_search(int A[], int N, int key) {
        int L = 0;
        int R = N - 1;

        while (L <= R) {
            // Avoid overflow, same as M=(L+R)/2
            int M = L + ((R - L) / 2);
            if (A[M] == key) return M;

            // the bottom half is sorted
            if (A[L] <= A[M]) {
                if (A[L] <= key && key < A[M])
                    R = M - 1;
                else
                    L = M + 1;
            }
            // the upper half is sorted
            else {
                if (A[M] < key && key <= A[R])
                    L = M + 1;
                else
                    R = M - 1;
            }
        }
        return -1;
    }

    /**
     * @param array
     * @param key
     * @return index of the key
     */
    public int search(int array[], int key) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int length = array.length;

        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int pivot = (right - left) / 2 + left;

            if (array[pivot] == key) {
                return pivot;
            }

            //upper sorted array
            if (array[pivot] <= array[right]) {
                if (key > array[pivot] && key <= array[right]) {
                    left = pivot + 1;
                } else {
                    right = pivot - 1;
                }

            } else {
                if (key < array[pivot] && key >= array[left]) {
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            }

        }

        return -1;
    }
}
