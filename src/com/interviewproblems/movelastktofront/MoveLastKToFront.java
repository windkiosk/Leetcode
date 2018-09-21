package com.interviewproblems.movelastktofront;

/**
 * Created by bod on 11/26/2014.
 */
public class MoveLastKToFront {
    public static void main(String[] strings) {
        MoveLastKToFront solution = new MoveLastKToFront();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        solution.moveLastKFront(a, 4);
        for (int i : a) {
            System.out.print(i + ", ");
        }

        System.out.println();

//        int[] b = {1, 2, 3, 4, 5, 6, 7, 8};
//        solution.moveLastKFront(b, 2);
//        for (int i : b) {
//            System.out.print(i + ", ");
//        }
    }

    public void moveLastKFront(int[] a, int k) {
        if (k <= 0 || k >= a.length) {
            return;
        }

        int count = 0;
        int index = 0;
        int len = a.length;
        int last = a[index];
        while (count < len) {
            int newIndex;

            if (index < len - k)
                newIndex = index + k;
            else
                newIndex = index - ( len - k );

            int tmp = a[newIndex];
            a[newIndex] = last;
            index = newIndex;
            last = tmp;

            if (index == 0) {
                index ++;
                last = a[index];
            }
            count ++;
        }
    }
}
