package com.leetcode.removeelement;

/**
 * Created by titan-developer on 10/24/14.
 * https://oj.leetcode.com/problems/remove-element/
 */
public class RemoveElement {

    public static void main(String[] strings) {
        //int[] a = {1, 3, 3, 4, 5, 6, 7};
        int[] a = {1};
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(a, 1));

        for (int i : a) {
            System.out.print(i + ", ");
        }
    }

    public int removeElement(int[] a, int elem) {
        if (a == null || a.length == 0) {
            return 0;
        }

        int id = -1;

        for (int i = 0 ; i < a.length ; i ++) {
            if (a[i] != elem) {
                id ++;
                a[id] = a[i];
            }
        }

        return id + 1;
    }
}
