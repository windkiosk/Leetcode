package com.leetcode.permutations2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by titan-developer on 11/1/14.
 * https://oj.leetcode.com/problems/permutations-ii/
 */
public class Permutations2 {

    public static void main(String[] strings) {

        Permutations2 permutations = new Permutations2();

        List<List<Integer>> list = permutations.permuteUnique(new int[]{1, 2, 1, 2});

        for (List<Integer> array : list) {
            for (int a : array) {
                System.out.print(a + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permuteUnique(int[] num) {

        Arrays.sort(num);

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        int l = num.length;

        addToList(list, num);

        int cursor = l - 1;

        while (cursor > 0) {
            if (num[cursor] > num[cursor - 1]) {
                swap(num, cursor);
                addToList(list, num);
                cursor = l - 1;
            } else {
                cursor--;
            }
        }

        return list;
    }

    private void swap(int[] num, int cursor) {
        int last = num[cursor - 1];
        int index = Integer.MAX_VALUE;
        int value = Integer.MAX_VALUE;
        for (int i = num.length - 1, j = cursor; i >= j; i--, j++) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;

            if (num[i] > last && num[i] <= value) {
                if (i < index)
                    index = i;
                value = num[i];
            }

            if (num[j] > last && num[j] <= value) {
                if (j < index)
                    index = j;
                value = num[j];
            }
        }

        num[cursor - 1] = num[index];
        num[index] = last;
    }

    private void addToList(List<List<Integer>> list, int[] num) {
        List<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++) {
            array.add(num[i]);
        }
        list.add(array);
    }
}
