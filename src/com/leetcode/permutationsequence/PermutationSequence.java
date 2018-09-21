package com.leetcode.permutationsequence;

/**
 * Created by titan-developer on 11/1/14.
 * https://oj.leetcode.com/problems/permutation-sequence/
 */
public class PermutationSequence {

    public static void main(String[] strings) {
        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(1, 1));
    }

    String getPermutation(int n, int k) {
        int i, j, f = 1;
        // left part of s is partially formed permutation, right part is the leftover chars.
        char[] chars = new char[n];
        for (i = 1; i <= n; i++) {
            f *= i;
            chars[i - 1] = (char)('0' + i); // make s become 1234...n
        }
        for (i = 0, k--; i < n; i++) {
            f /= n - i;
            j = i + k / f; // calculate index of char to put at s[i]
            char c = chars[j];
            // remove c by shifting to cover up (adjust the right part).
            for (; j > i; j--)
                chars[j] = chars[j - 1];
            k %= f;
            chars[i] = c;
        }
        return new String(chars);
    }

}
