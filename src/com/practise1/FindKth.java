package com.practise1;

/**
 * Created by titan-developer on 12/11/14.
 */
public class FindKth {
    public static void main(String[] strings) {
        int[] a = {2, 3, 6, 8, 10};
        int[] b = {9, 11, 12, 13, 14};

        FindKth findKth = new FindKth();
        System.out.println(findKth.findKth(a, b, 1));
    }

    public int findKth(int[] a, int[] b, int k) {
        int res = findKth(a, 0, a.length, b, 0, b.length, k);
        return res;
    }

    private int findKth(int[] a, int a_start, int a_end, int[] b, int b_start, int b_end, int k) {
        int i = (a_end - a_start) * k / (b_end + a_end - b_start - a_start);
        int j = k - 1 - i;
        i += a_start;
        j += b_start;

        int a_left = i - 1 < 0 ? Integer.MIN_VALUE : a[i - 1];
        int b_left = j - 1 < 0 ? Integer.MIN_VALUE : b[j - 1];
        int a_current = i == a.length ? Integer.MAX_VALUE : a[i];
        int b_current = j == b.length ? Integer.MAX_VALUE : b[j];

        if (b_left < a_current && a_current < b_current) {
            return a_current;
        }

        if (a_left < b_current && b_current < a_current) {
            return b_current;
        }

        if (a_current < b_current) {
            return findKth(a, i + 1, a_end, b, b_start, j - 1, k - (i - a_start + 1));
        } else {
            return findKth(a, a_start, i - 1, b, j + 1, b_end, k - (j - b_start + 1));
        }
    }
}
