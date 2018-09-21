package com.interviewproblems.sorting;

/**
 * Created by titan-developer on 8/7/14.
 */
public class CombSort implements Sorter {

    public static void main(String[] strings) {
        SortTester sortTester = new SortTester(new CombSort());
        sortTester.testSort();
    }

    @Override
    public void sort(int[] input) {
        if (input == null || input.length == 0 || input.length == 1) {
            return;
        }

        int gap = input.length;
        float shrinkFactor = 1.3f;

        boolean isSwapped;
        do {
            gap = (int) (gap / shrinkFactor);
            if (gap < 1) {
                gap = 1;
            }
            isSwapped = false;

            for (int i = 0; i + gap < input.length; i++) {
                if (input[i] > input[i + gap]) {
                    int temp = input[i];
                    input[i] = input[i + gap];
                    input[i + gap] = temp;
                    isSwapped = true;
                }
            }

        } while (isSwapped);
    }
}
