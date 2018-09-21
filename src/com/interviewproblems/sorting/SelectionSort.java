package com.interviewproblems.sorting;

/**
 * Created by bod on 8/2/14.
 */
public class SelectionSort implements Sorter {

    public static void main(String[] strings) {
        SortTester tester = new SortTester(new SelectionSort());
        tester.testSort();
    }

    public void sort(int[] input) {
        if (input == null || input.length == 0 || input.length == 1) {
            return;
        }

        int minIndex;
        for (int i = 0; i < input.length; i++) {
            minIndex = i;
            for (int m = i; m < input.length; m++) {
                if (input[m] < input[minIndex]) {
                    minIndex = m;
                }
            }

            if (minIndex != i) {
                int temp = input[i];
                input[i] = input[minIndex];
                input[minIndex] = temp;
            }
        }
    }
}
