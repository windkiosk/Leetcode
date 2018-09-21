package com.interviewproblems.sorting;

/**
 * Created by bod on 8/2/14.
 */
public class InsertSort implements Sorter {

    public static void main(String[] strings) {
        SortTester sortTester = new SortTester(new InsertSort());
        sortTester.testSort();
    }

    public void sort(int[] input) {
        if (input == null || input.length == 0 || input.length == 1) {
            return;
        }

        for (int m = 1; m < input.length; m++) {
            for (int i = 0; i < m; i++) {
                if (input[m] < input[i]) {
                    move(input, i, m);
                }
            }
        }
    }

    private void move(int[] array, int m, int n) {
        if (array == null || m >= array.length || n >= array.length) {
            return;
        }

        int value = array[n];

        System.arraycopy(array, m, array, m + 1, (n - m));

        array[m] = value;
    }
}
