package com.leetcode.searchinsertpos;

/**
 * Created by titan-developer on 10/29/14.
 * https://oj.leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

    public static void main(String[] strings) {

        int c[] = {3, 5, 7, 9, 10};
        int b[] = {1, 3};
        int a[] = {1, 3, 5, 6};
        SearchInsertPosition searcher = new SearchInsertPosition();
        System.out.println(searcher.searchInsert(c, 8));
        System.out.println(searcher.searchInsert(b, 2));
        System.out.println(searcher.searchInsert(a, 5));
        System.out.println(searcher.searchInsert(a, 2));
        System.out.println(searcher.searchInsert(a, 7));
        System.out.println(searcher.searchInsert(a, 0));
    }

    public int searchInsert(int[] a, int target) {
        if (a == null) {
            return -1;
        } else if (a.length == 0) {
            return 0;
        }

        if (target < a[0]) {
            return 0;
        } else if (target > a[a.length - 1]) {
            return a.length;
        }

        return binarySearch(a, target);
    }

    private int binarySearch(int[] a, int target) {
        int index;

        int start = 0, end = a.length - 1;

        while (start <= end) {
            int middle = (end + start) / 2;

            if (a[middle] == target) {
                return middle;
            } else if (a[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        if (a[start] > target) {
            index = start;
        } else {
            index = start - 1;
        }

        return index;
    }
}
