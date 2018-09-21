package com.interviewproblems.sorting;

/**
 * Created by titan-developer on 8/7/14.
 */
public class CocktailSort implements Sorter {

    public static void main(String[] strings) {
        SortTester sortTester = new SortTester(new CocktailSort());
        sortTester.testSort();
    }

    @Override
    public void sort(int[] input) {
        if (input == null || input.length == 0 || input.length == 1) {
            return;
        }

        int begin = 0;
        int end = input.length - 2;

        boolean isSwapped;
        do {
            isSwapped = false;
            for (int i = begin; i <= end; i++) {
                if (input[i] > input[i + 1]) {
                    int temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                    isSwapped = true;
                }
            }

            end = end - 1;

            for (int m = end; m >= begin; m--) {
                if (input[m] > input[m + 1]) {
                    int temp = input[m];
                    input[m] = input[m + 1];
                    input[m + 1] = temp;
                    isSwapped = true;
                }
            }

            begin = begin + 1;

        } while (isSwapped);
    }
}
