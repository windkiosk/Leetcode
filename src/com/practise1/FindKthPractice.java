package com.practise1;

/**
 * Created by titan-developer on 12/13/14.
 */
public class FindKthPractice {
    public static void main(String[] strings) {
        int[] a = {2, 3, 6, 8, 10};
        int[] b = {9, 11, 12, 13, 14};

        FindKthPractice findKth = new FindKthPractice();
        System.out.println(findKth.findKth(a, b, 6));
    }

    public int findKth(int[] a, int[] b, int k) {
        return helper(a, 0, a.length - 1, b, 0, b.length - 1, k);
    }

    public int helper(int[] a, int al, int ar, int[] b, int bl, int br, int k) {
        if (k > a.length + b.length) {
            throw new RuntimeException("invalid input");
        }

        int i = k * (ar - al + 1) / (ar + br - al - bl + 2);
        int j = k - i - 1;
        i += al;
        j += bl;

        int v_i = i == a.length ? Integer.MAX_VALUE : a[i];
        int v_i_left = i - 1 < 0 ? Integer.MIN_VALUE : a[i - 1];
        int v_j = j == b.length ? Integer.MAX_VALUE : b[j];
        int v_j_left = j - 1 < 0 ? Integer.MIN_VALUE : b[j - 1];

        if (v_j_left <= v_i && v_i < v_j) return v_i;
        if (v_i_left <= v_j && v_j < v_i) return v_j;

        if (v_i < v_j) {
            return helper(a, i + 1, ar, b, bl, j - 1, k - (i + 1 - al));
        } else {
            return helper(a, al, i - 1, b, j + 1, br, k - (j + 1 - bl));
        }
    }
}
