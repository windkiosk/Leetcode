package com.interviewproblems.onezerosort;

/**
 * Created by titan-developer on 12/13/14.
 */
public class OneZeroSort {

    public static void main(String[] strings) {
        int[] a = {1, -1, 3, -2, 5, -4, -5, 7};

        OneZeroSort oneZeroSort = new OneZeroSort();
        oneZeroSort.oneZeroSort(a);

        for (int v : a) System.out.print(v + ", ");
    }

    public void oneZeroSort(int[] a) {
        int negCount = helper(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i ++) {
            if (i < negCount) {
                a[i] = - Math.abs(a[i]);
            } else {
                a[i] = Math.abs(a[i]);
            }
        }
    }

    int helper(int[] a, int l, int r) {
        if (l >= r) return 0;

        int negCount = 0;
        for (int i = l; i <= r; i ++) {
            if (a[i] < 0) negCount ++;
        }

        int negIndex = l;
        int posIndex = l + negCount;
        boolean isSwitch = false;
        while (negIndex < l + negCount && posIndex <= r) {
            if (a[negIndex] > 0 && a[posIndex] < 0) {
                int tmp = a[negIndex];
                a[negIndex] = - a[posIndex];
                a[posIndex] = - tmp;
                posIndex ++;
                negIndex ++;
                isSwitch = true;
            } else {
                if (a[negIndex] < 0) negIndex++;
                if (a[posIndex] > 0) posIndex++;
            }
        }

        if (isSwitch) {
            helper(a, l, negCount - 1);
            helper(a, l + negCount, r);
        }

        return negCount;
    }
}
