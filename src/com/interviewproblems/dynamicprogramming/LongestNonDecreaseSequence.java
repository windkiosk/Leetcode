package com.interviewproblems.dynamicprogramming;

/**
 * Created by titan-developer on 8/24/14.
 * Given a sequence of N numbers - A[1] , A[2] , ..., A[N] . Find the length of the longest non-decreasing sequence.
 */
public class LongestNonDecreaseSequence {

    public static void main(String[] strings) {
        LongestNonDecreaseSequence sequence = new LongestNonDecreaseSequence();

        int[] array = new int[]{1, 3, 4, 5, 6, 8, 2, 0};
        int longest = sequence.findLongestNonDecrease(array);
        System.out.println(longest);

        array = new int[]{3, 2, 1, 5, 6, 9, 4, 2};
        longest = sequence.findLongestNonDecrease(array);
        System.out.println(longest);
    }

    public int findLongestNonDecrease(int[] array) {
        if (array == null) {
            return 0;
        } else if (array.length == 1) {
            return 1;
        }

        int[][] log = new int[array.length][2];

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                log[0][0] = 1;
                log[0][1] = array[i];
            } else {
                if (array[i] > log[i - 1][1]) {
                    log[i][0] = log[i - 1][0] + 1;
                } else {
                    log[i][0] = log[i - 1][0];
                }

                log[i][1] = array[i];
            }
        }

        return log[array.length - 1][0];
    }
}
