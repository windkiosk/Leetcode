package com.leetcode.validpalindrome;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    public static void main(String[] strings) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char l_c = s.charAt(left);
            if (!isAlphaNumeric(l_c)) {
                left ++;
                continue;
            }

            char r_c = s.charAt(right);

            if (!isAlphaNumeric(r_c)) {
                right --;
                continue;
            }

            if (l_c == r_c) {
                left ++;
                right --;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return  ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'));
    }
}
