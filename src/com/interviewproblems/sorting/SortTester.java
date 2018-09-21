package com.interviewproblems.sorting;

/**
 * Created by bod on 8/2/14.
 */
public class SortTester {
    private static int[][] cases = {
            {},
            {0},
            {0, 0},
            {0, 0, 0},
            {0, 1},
            {1, 0},
            {0, 1, 2},
            {0, 2, 1},
            {1, 0, 2},
            {1, 2, 0},
            {2, 0, 1},
            {2, 1, 0},
            {0, 1, 1},
            {1, 0, 1},
            {1, 1, 0},
            {3, 5, 1, 9, 8, 7, 4},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
            {42, 9, 17, 54, 602, -3, 54, 999, -11},
            {-11, -3, 9, 17, 42, 54, 54, 602, 999},
    };


    Sorter sorter;

    public SortTester(Sorter sorter) {
        this.sorter = sorter;
    }

    public void testSort() {
        for (int[] testArray : cases) {
            sorter.sort(testArray);
            printArray(testArray);
        }
    }

    private void printArray(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("empty array");
        } else {
            for (int i : array) {
                System.out.println(i);
            }
        }
        System.out.println("-----------");
    }
}
