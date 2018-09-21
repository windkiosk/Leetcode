package com.leetcode.multiplystrings;

/**
 * Created by titan-developer on 10/31/14.
 * https://oj.leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {

    public static void main(String[] strings) {

        MultiplyStrings multiplyStrings = new MultiplyStrings();

        String a = multiplyStrings.multiply("0", "0");

        System.out.println(a);
    }

    public String multiply(String num1, String num2) {

        int l1 = num1.length(), l2 = num2.length();
        if (l1 == 0 || l2 == 0) return "0";

        int[] v = new int[l1 + l2];

        for (int i = 0; i < l1; i++) {
            int carry = 0;
            int n1 = num1.charAt(l1 - i - 1) - '0';//Calculate from rightmost to left
            for (int j = 0; j < l2; j++) {
                int n2 = (num2.charAt(l2 - j - 1) - '0');//Calculate from rightmost to left

                int sum = n1 * n2 + v[i + j] + carry;
                carry = sum / 10;
                v[i + j] = sum % 10;
            }
            if (carry > 0)
                v[i + l2] += carry;

        }
        int start = l1 + l2 - 1;
        while (start >= 0 && v[start] == 0) start--;
        if (start == -1) return "0";

        String s = "";
        for (int i = start; i >= 0; i--)
            s += (char) (v[i] + '0');
        return s;
    }
}
