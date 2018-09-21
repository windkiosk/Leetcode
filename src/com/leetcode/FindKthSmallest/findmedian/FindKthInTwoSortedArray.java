package com.leetcode.FindKthSmallest.findmedian;

/**
 * Created by titan-developer on 12/2/14.
 */
public class FindKthInTwoSortedArray {

    static final int MIN = Integer.MIN_VALUE;
    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] strings) {
//        int[] a = {1, 2, 4, 6, 7, 8, 9};
//        int[] b = {3, 5, 9, 10, 11, 12};

        int[] a = {1, 2, };
        int[] b = {3, 5, 9, 10, 11, 12};

        FindKthInTwoSortedArray findKthInTwoSortedArray = new FindKthInTwoSortedArray();
        System.out.println(findKthInTwoSortedArray.kthSmallestDirectSearch(a, b, 5));
        System.out.println(findKthInTwoSortedArray.findKthIterative(a, b, 5));
    }

    //-----------------------------------------------------------------------------
    //http://leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html

    public int kthSmallest(int[] A, int[] B, int k) {
        if (A == null || B == null || k > A.length + B.length)
            throw new IllegalArgumentException();
        return kthSmallest(A, 0, A.length, B, 0, B.length, k);
    }

    public int findKthIterative(int[] A, int[] B, int k) {
        if (A == null || B == null || A.length == 0 || B.length == 0 || k > A.length + B.length || k <= 0)
            throw new IllegalArgumentException();
        int aLow = 0, bLow = 0, aLen = A.length, bLen = B.length;

        while (aLen > 0 || bLen > 0) {
            int i = (int) ((double) ((k - 1) * aLen / (aLen + bLen)));
            int j = k - 1 - i;

            int Ai_1 = aLow + i == 0 ? Integer.MIN_VALUE : A[aLow + i - 1];
            int Ai = aLow + i == A.length ? Integer.MAX_VALUE : A[aLow + i];

            int Bj_1 = bLow + j == 0 ? Integer.MIN_VALUE : B[bLow + j - 1];
            int Bj = bLow + j == B.length ? Integer.MAX_VALUE : B[bLow + j];

            if (Bj_1 < Ai && Ai < Bj)
                return Ai;
            else if (Ai_1 < Bj && Bj < Ai)
                return Bj;

            if (Ai < Bj_1) {
                aLow = aLow + i + 1;
                aLen = aLen - i - 1;
                bLen = j;
                k = k - i - 1;
            } else {
                aLen = i;
                bLow = bLow + j + 1;
                bLen = bLen - j - 1;
            }
        }

        return Integer.MIN_VALUE;
    }

    protected int kthSmallest(int[] A, int aLow, int aLength, int[] B, int bLow, int bLength, int k) {

        assert (aLow >= 0);
        assert (bLow >= 0);
        assert (aLength >= 0);
        assert (bLength >= 0);
        assert (aLength + bLength >= k);

        int i = (int) ((double) ((k - 1) * aLength / (aLength + bLength)));
        int j = k - 1 - i;

        int Ai_1 = aLow + i == 0 ? MIN : A[aLow + i - 1];
        int Ai = aLow + i == A.length ? MAX : A[aLow + i];

        int Bj_1 = bLow + j == 0 ? MIN : B[bLow + j - 1];
        int Bj = bLow + j == B.length ? MAX : B[bLow + j];

        if (Bj_1 < Ai && Ai < Bj)
            return Ai;
        else if (Ai_1 < Bj && Bj < Ai)
            return Bj;

        assert (Ai < Bj - 1 || Bj < Ai_1);

        if (Ai < Bj_1) // exclude A[aLow .. i] and A[j..bHigh], k was replaced by k - i - 1
            return kthSmallest(A, aLow + i + 1, aLength - i - 1, B, bLow, j, k - i - 1);
        else // exclude A[i, aHigh] and B[bLow .. j], k was replaced by k - j - 1
            return kthSmallest(A, aLow, i, B, bLow + j + 1, bLength - j - 1, k - j - 1);
    }

    //-----------------------------------------------------------------------------

    protected int kthSmallestDirectSearch(int A[], int B[], int k) {
        if (A == null || B == null || (A.length == 0 && B.length == 0) || k > A.length + B.length) {
            return Integer.MIN_VALUE;
        }

        if (A.length == 0) return B[k - 1];

        if (B.length == 0) return A[k - 1];

        int v;
        int index = findKthInFirst(A, B, k);
        if (index >= 0) {
            v = A[index];
        } else {
            index = findKthInFirst(B, A, k);
            v = B[index];
        }
        return v;
    }

    private int findKthInFirst(int[] a, int[] b, int k) {
        int index = -1;

        int left = 0, right = a.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (middle > k - 1) {
                right = middle - 1;
            } else if (middle == k - 1 && a[middle] < b[0]) {
                return middle;
            } else {
                if (b[k - middle - 2] <= a[middle] && (k - middle - 1 >= b.length || a[middle] <= b[k - middle - 1])) {
                    return middle;
                } else if (a[middle] > b[k - middle - 1]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }

        return index;
    }
}
