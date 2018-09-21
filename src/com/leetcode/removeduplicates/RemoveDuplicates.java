package com.leetcode.removeduplicates;

/**
 * Created by titan-developer on 10/24/14.
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates {

    public static void main(String[] strings) {

        int [] a = {1, 1, 2, 3, 4, 5, 6, 6};
        //int [] a = {1, 1};

        RemoveDuplicates remover = new RemoveDuplicates();
        System.out.println(remover.removeDuplicates(a));
    }

    public int removeDuplicates(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        int id = 0;

        for (int i = 1 ; i < a.length ; i ++) {
            if (a[id] != a[i]) {
                id ++;
            }
            a[id] = a[i];
        }

        return id + 1;
    }
}
