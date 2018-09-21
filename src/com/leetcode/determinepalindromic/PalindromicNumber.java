package com.leetcode.determinepalindromic;

/**
 * Created by bod on 9/10/14.
 * https://oj.leetcode.com/problems/palindrome-number/
 */
public class PalindromicNumber {

    public static void main(String[] strings) {

        int x = 100000;

        PalindromicNumber palindromic = new PalindromicNumber();

        System.out.println(Math.log10(x));

        System.out.println(palindromic.isPalindrome(1234543121));
        System.out.println(palindromic.isPalindrome(123454321));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x < 10) {
            return true;
        } else {
            int max = (int) (Math.log10(x));
            int min = 0;

            while (min < max) {
                int highestInt = x / ((int) Math.pow(10, max));

                int lowestInt = x / ((int) Math.pow(10, min)) % 10;

                if (highestInt == lowestInt) {
                    x = x - highestInt * ((int) Math.pow(10, max));

                    max--;
                    min++;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}

