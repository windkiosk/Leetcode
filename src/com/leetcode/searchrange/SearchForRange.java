package com.leetcode.searchrange;

/**
 * Created by titan-developer on 10/29/14.
 * https://oj.leetcode.com/problems/search-for-a-range/
 */
public class SearchForRange {

    public static void main(String[] strings) {
        int a[] = {5, 7, 7, 8, 8, 10};

        SearchForRange searcher = new SearchForRange();
        int[] range = searcher.searchRange(a, 8);
        for (int i : range) {
            System.out.print(i + ", ");
        }
    }

    public int[] searchRange2(int[] A, int target) {
        int[] arr = new int[2];
        arr[0] = searchLeft(A, target);
        arr[1] = searchRight(A, target);
        return arr;
    }

    private int searchLeft(int[] A, int target) {
        int s = 0, e = A.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (A[mid] == target) {
                if (mid == 0) {
                    return mid;
                }
                if (A[mid - 1] == target) {
                    e = mid - 1;
                } else {
                    return mid;
                }
            } else if (target > A[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }
    private int searchRight(int[] A, int target) {
        int s = 0, e = A.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (A[mid] == target) {
                if (mid == A.length - 1) {
                    return mid;
                }
                if (A[mid + 1] == target) {
                    s = mid + 1;
                } else {
                    return mid;
                }
            } else if (target > A[mid]) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    //----------------------------------------------------------------

    public int[] searchRange(int[] A, int target) {
        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                if (mid == 0 || A[mid] != A[mid - 1]) {
                    ret[0] = mid;
                    ret[1] = mid;
                    left = mid;
                    break;
                } else {
                    right = mid - 1;
                }
            } else if (A[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                if (mid == A.length - 1 || A[mid] != A[mid + 1]) {
                    ret[1] = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return ret;
    }
}
