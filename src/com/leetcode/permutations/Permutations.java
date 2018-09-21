package com.leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/1/14.
 * https://oj.leetcode.com/problems/permutations/
 */
public class Permutations {

    public static void main(String[] strings) {

        Permutations permutations = new Permutations();

        List<List<Integer>> list = permutations.permute(new int[]{1, 2, 3, 4});

        for (List<Integer> array : list) {
            for (int a : array) {
                System.out.print(a + ", ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] num) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        int l = num.length;
        int[] pos = new int[l];

        for (int i = 0; i < l; i++) {
            pos[i] = i;
        }

        addToList(list, num, pos);

        int cursor = l - 1;

        while (cursor > 0) {
            if (pos[cursor] > pos[cursor - 1]) {
                swap(pos, cursor);
                addToList(list, num, pos);
                cursor = l - 1;
            } else {
                cursor --;
            }
        }

        return list;
    }

    private void swap(int[] pos, int cursor) {
        int a = pos[cursor - 1];
        int index = -1;
        int v = Integer.MAX_VALUE;
        for (int i = pos.length - 1, j = cursor; i >= j; i--, j ++) {
            int tmp = pos[i];
            pos[i] = pos[j];
            pos[j] = tmp;

            if (pos[i] > a && pos[i] < v) {
                index = i;
                v = pos[i];
            }

            if (pos[j] > a && pos[j] < v) {
                index = j;
                v = pos[j];
            }
        }

        pos[cursor - 1] = pos[index];
        pos[index] = a;
    }

    private void addToList(List<List<Integer>> list, int[] num, int[] pos) {
        List<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < pos.length; i++) {
            array.add(num[pos[i]]);
        }
        list.add(array);
    }
}
