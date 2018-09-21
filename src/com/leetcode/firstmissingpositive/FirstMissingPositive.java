package com.leetcode.firstmissingpositive;

import java.util.HashMap;

/**
 * Created by titan-developer on 10/25/14.
 * https://oj.leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {

    public static void main(String[] strings) {
        int[] a = {1, 2, 0};
        int[] b = {3, 4, -1, 1};
        int[] c = {1, 1};

        FirstMissingPositive missingPositive = new FirstMissingPositive();
        System.out.println(missingPositive.firstMissingPositive(a));
        System.out.println(missingPositive.firstMissingPositive(b));
        System.out.println(missingPositive.firstMissingPositive(c));

        System.out.println(missingPositive.firstMissingPositive(a, a.length));
        System.out.println(missingPositive.firstMissingPositive(b, b.length));
        System.out.println(missingPositive.firstMissingPositive(c, c.length));
    }

    public int firstMissingPositive(int A[], int n) {
        for (int i = 0; i < n; ++i)
        {
            int num = A[i];
            while (num <= n && num > 0 && A[num - 1] != num)
            {
                swap(A, num - 1, i);
                num = A[i];
            }
        }
        for (int i = 0; i < n; ++i)
        {
            if (A[i] != i + 1)
            {
                return i + 1;
            }
        }
        return n + 1;
    }

    protected void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public int firstMissingPositive(int[] a) {
        if (a == null || a.length == 0) {
            return 1;
        }

        int missing = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int value : a) {

            if (value > 0) {
                if (missing == value) {
                    missing ++;

                    while (map.containsKey(missing)) {
                        missing ++;
                    }

                } else if (value > missing) {
                    map.put(value, value);
                }
            }
        }

        return missing;
    }
}
