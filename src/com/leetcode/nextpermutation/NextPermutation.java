package com.leetcode.nextpermutation;

/**
 * Created by titan-developer on 10/23/14.
 * https://oj.leetcode.com/problems/next-permutations/
 *
 * Samples
 1, 2, 3, 3, 4
 1, 2, 3, 4, 3
 1, 2, 4, 3, 3
 1, 3, 2, 3, 4
 1, 3, 2, 4, 3
 1, 3, 3, 2, 4
 1, 3, 3, 4, 2
 1, 3, 4, 2, 3
 1, 3, 4, 3, 2
 1, 4, 2, 3, 3
 1, 4, 3, 2, 3
 1, 4, 3, 3, 2
 2, 1, 3, 3, 4
 2, 1, 3, 4, 3
 2, 1, 4, 3, 3
 2, 3, 1, 3, 4
 2, 3, 1, 4, 3
 2, 3, 3, 1, 4
 2, 3, 3, 4, 1
 2, 3, 4, 1, 3
 2, 3, 4, 3, 1
 2, 4, 1, 3, 3
 2, 4, 3, 1, 3
 2, 4, 3, 3, 1
 3, 1, 2, 3, 4
 3, 1, 2, 4, 3
 3, 1, 3, 2, 4
 3, 1, 3, 4, 2
 3, 1, 4, 2, 3
 3, 1, 4, 3, 2
 3, 2, 1, 3, 4
 3, 2, 1, 4, 3
 3, 2, 3, 1, 4
 3, 2, 3, 4, 1
 3, 2, 4, 1, 3
 3, 2, 4, 3, 1
 3, 3, 1, 2, 4
 3, 3, 1, 4, 2
 3, 3, 2, 1, 4
 3, 3, 2, 4, 1
 3, 3, 4, 1, 2
 3, 3, 4, 2, 1
 3, 4, 1, 2, 3
 3, 4, 1, 3, 2
 3, 4, 2, 1, 3
 3, 4, 2, 3, 1
 3, 4, 3, 1, 2
 3, 4, 3, 2, 1
 4, 1, 2, 3, 3
 4, 1, 3, 2, 3
 4, 1, 3, 3, 2
 4, 2, 1, 3, 3
 4, 2, 3, 1, 3
 4, 2, 3, 3, 1
 4, 3, 1, 2, 3
 4, 3, 1, 3, 2
 4, 3, 2, 1, 3
 4, 3, 2, 3, 1
 4, 3, 3, 1, 2
 4, 3, 3, 2, 1

 */
public class NextPermutation {

    public static void main(String[] strings) {
        int a[] = {3, 2, 4, 3, 1};
        //int a[] = {3, 2, 1};

        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(a);

        for (int i : a) {
            System.out.print(i + ", ");
        }
    }

    public void nextPermutation(int[] num) {
        if (num == null || num.length <= 1) {
            return;
        }

        boolean isSwap = false;
        for (int i = num.length - 1 ; i > 0 ; i --) {
            if (num[i] > num[i - 1]) {
                int index = findClosest(num, i, num[i - 1]);
                swap(num, i - 1, index);
                reverse(num, i);
                isSwap = true;
                break;
            }
        }

        if (!isSwap) {
            reverse(num, 0);
        }
    }

    protected int findClosest(int[] num, int i, int target) {
        for (int m = num.length - 1; m >= i ; m --) {
            if (num[m] > target) {
                return m;
            }
        }

        return -1;
    }

    protected void reverse(int[] num, int i) {
        int m = i;
        int n = num.length - 1;

        while (m < n) {
            swap(num, m, n);
            m ++;
            n --;
        }
    }

    protected void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
