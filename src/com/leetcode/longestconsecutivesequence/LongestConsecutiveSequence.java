package com.leetcode.longestconsecutivesequence;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {

    public static void main(String[] strings) {
        int[] a = {100, 4, 200, 1, 3, 2};

        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longestConsecutive(a));
    }

    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>(num.length);
        for (int n: num) {
            set.add(n);
        }

        int maxLength = 0;
        for (int n: num) {
            if (set.contains(n)) {
                int length = 1;
                int next = n - 1;
                while (set.contains(next)) {
                    length++;
                    set.remove(next);
                    next--;
                }
                next = n+1;
                while (set.contains(next)) {
                    length++;
                    set.remove(next);
                    next++;
                }

                if (length > maxLength) {
                    maxLength = length;
                }
            }
        }

        return maxLength;
    }
}
