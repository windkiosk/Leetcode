package com.interviewproblems.sorting;

/**
 * Created by titan-developer on 8/7/14.
 */
public class QuickSort implements Sorter {

    public static void main(String[] strings) {
        SortTester sortTester = new SortTester(new BubbleSort());
        sortTester.testSort();
    }

    @Override
    public void sort(int[] input) {
        if (input == null || input.length == 0 || input.length == 1) {
            return;
        }

        quickSort(input, 0, input.length - 1);
    }

    private void quickSort(int[] input, int left, int right) {
        if (left < right) {
            int p = partition(input, left, right);
            quickSort(input, left, p - 1);
            quickSort(input, p + 1, right);
        }
    }

    private int partition(int[] input, int left, int right) {
        int pivotIndex = choosePivot(input, left, right);
        int value = input[pivotIndex];
        swap(input, pivotIndex, right);
        int p = right;

        while (left < right) {
            if (input[left] > value) {
                swap(input, p, p - 1);
                if (left < p - 1) {
                    swap(input, left, p);
                }
                p--;
                right--;
            } else {
                left++;
            }
        }

        return p;
    }

    private void swap(int[] input, int x, int y) {
        if (input == null || input.length == 0 || x < 0 || x >= input.length || y < 0 || y >= input.length)
            return;

        int temp = input[x];
        input[x] = input[y];
        input[y] = temp;
    }

    private int choosePivot(int[] input, int left, int right) {
        if (input == null || input.length == 0 || left < 0 || right >= input.length || right < left) {
            return -1;
        }

        if (right > left)
            return (right - left) / 2 + 1;
        else //equal case.
            return right;
    }
}
