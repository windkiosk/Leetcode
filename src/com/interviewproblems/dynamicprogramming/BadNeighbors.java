package com.interviewproblems.dynamicprogramming;

/**
 * Created by bod on 8/24/14.
 * Problem description: http://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
 */
public class BadNeighbors {

    public static void main(String[] strings) {
        BadNeighbors badNeighbors = new BadNeighbors();

        int a[] = {5, 3, 23, 1, 2, 37, 4};
        int b[] = {5, 23, 3, 7, 29, 2};
        int d[] = {7, 7, 7, 7, 7, 7, 7};
        int e[] = {10, 3, 2, 5, 7, 8};
        int f[] = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int g[] = {94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
                6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
                52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72};

        System.out.println(badNeighbors.maxDonations(b));
        System.out.println(badNeighbors.maxDonations(a));
        System.out.println(badNeighbors.maxDonations(e));
        System.out.println(badNeighbors.maxDonations(f));
        System.out.println(badNeighbors.maxDonations(g));
        System.out.println(badNeighbors.maxDonations(d));
    }

    public int maxDonations(int[] array) {
        if (array == null || array.length <= 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        if (array.length == 2) {
            return Math.max(array[0], array[1]);
        }

        if (array.length == 3) {
            return Math.max(Math.max(array[0], array[1]), array[2]);
        }

        int[] dp1 = new int[array.length];
        int[] dp2 = new int[array.length];

        dp1[0] = array[0];
        dp1[1] = array[0];

        for (int i = 2; i < array.length; i++) {
            dp1[i] = Math.max(dp1[i - 2] + array[i], dp1[i - 1]);
        }

        dp2[0] = array[0];
        dp2[1] = array[0];
        dp2[2] = Math.max(array[1], array[2]);

        for (int i = 3; i < array.length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + array[i], dp2[i - 1]);
        }

        return Math.max(dp1[dp1.length - 2], dp2[dp2.length - 2]);
    }
}
