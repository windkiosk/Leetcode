package com.interviewproblems.sorting;

/**
 * Created by titan-developer on 8/7/14.
 */
public class BubbleSort implements Sorter {

    public static void main(String[] strings) {
        SortTester sortTester = new SortTester(new BubbleSort());
        sortTester.testSort();
    }

    @Override
    public void sort(int[] input) {
        if (input == null || input.length == 0 || input.length == 1) {
            return;
        }

        boolean isSwapped;
        do {
            isSwapped = false;
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] > input[i + 1]) {
                    int temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                    isSwapped = true;
                }
            }
        } while (isSwapped);
    }
}
