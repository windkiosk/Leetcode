package com.leetcode.sortcolor;

/**
 * Created by titan-developer on 11/7/14.
 * https://oj.leetcode.com/problems/sort-colors/
 */
public class SortColors {

    public static void main(String[] strings) {
        //int[] a = {1, 1, 0, 2, 0, 1, 1, 0};
        int[] a = {0,2,1,2,0,0,1,2,1,1,1,0,2,1,2,1,1,1,1,2,1,0,0,0,1,2,2,0,2,1,0,0,1,2,2,1,2,1,0,0,0,0,2,0,2,1,2,1,1,1,1,0,1,2,0,0,0,0,0,0,2,1,1,0,0,1,1,0,0,0,0,1,1,2,2,0,2,1,1,1,2,0,1,1,1,0,2,1,1,2,2,0,1,0,0,1,0,2,2,1,2,1,2,0,0};
        //int[] a = {1, 0};

        SortColors sorter = new SortColors();
        sorter.sortColorsNiuB(a);

        for (int i : a) {
            System.out.print(i + ", ");
        }
    }

    public void sortColors(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        int left = 0; int right = a.length - 1;
        while (left < a.length && a[left] == 0) {
            left ++;
        }

        while (right >= 0 && a[right] == 2) {
            right --;
        }

        int current = left;
        while (current <= right) {
            if (a[current] == 0) {
                if (current == left) {
                    current ++;
                    left ++;
                } else {
                    a[current] = a[left];
                    a[left] = 0;
                    left++;
                }
            } else if (a[current] == 2){
                a[current] = a[right];
                a[right] = 2;
                right --;
            } else {
                current ++;
            }
        }
    }

    public void sortColorsNiuB(int[] A) {
        int i=-1, j=-1;

        for(int p = 0; p < A.length; p++) {

            int v = A[p];
            A[p] = 2;

            if (v == 0) {
                A[++j] = 1;
                A[++i] = 0;
            }
            else if (v == 1) {
                A[++j] = 1;
            }
        }
    }
}
