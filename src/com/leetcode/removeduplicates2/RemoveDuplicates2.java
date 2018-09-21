package com.leetcode.removeduplicates2;

/**
 * Created by titan-developer on 11/2/14.
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicates2 {

    public static void main(String[] strings) {

        int[] a = {1, 1, 1, 2, 2, 2, 3};

        RemoveDuplicates2 remover = new RemoveDuplicates2();
        System.out.println(remover.removeDuplicates(a));
    }

    public int removeDuplicates(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        int id = 0;

        int count = 0;

        for (int i = 1; i < a.length; i++) {
            if (a[id] != a[i]) {
                count = 0;
                id++;
            } else if (++count < 2) {
                id++;
            }
            a[id] = a[i];
        }

        return id + 1;
    }
}
