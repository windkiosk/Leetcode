package com.leetcode.searchrotatesortedarray;

/**
 * Created by titan-developer on 11/2/14.
 * https://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchElementInRotateSortedArray2 {

    public static void main(String[] strings) {
        int[] array = {1, 3, 1, 1, 1};
        SearchElementInRotateSortedArray2 searcher = new SearchElementInRotateSortedArray2();
        System.out.println(searcher.search(array, 3));

    }

    public boolean search(int A[], int key) {
        int L = 0;
        int N = A.length;
        int R = N - 1;

        while (L <= R) {
            if (A[L] == A[R] && A[L] != key) {
                R--;
                continue;
            }

            // Avoid overflow, same as M=(L+R)/2
            int M = L + ((R - L) / 2);
            if (A[M] == key) return M != -1;

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
        return false;
    }
}
