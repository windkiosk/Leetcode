package com.leetcode.plusone;

/**
 * Created by titan-developer on 11/5/14.
 * https://oj.leetcode.com/problems/plus-one/
 */
public class PlusOne {

    public static void main(String[] strings) {
        PlusOne plusOne = new PlusOne();

        int[] a = plusOne.plusOne(new int[] {9, 9});
        for (int v : a) {
            System.out.print(v);
        }
    }

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{1};
        }

        int carry = 1;
        for (int i = digits.length - 1 ; i >= 0; i --) {
            if (carry > 0) {
                if (digits[i] + carry >= 10) {
                    carry = 1;
                    digits[i] = (digits[i] + carry) % 10;
                } else {
                    digits[i] = (digits[i] + carry);
                    carry = 0;
                    break;
                }
            }
        }

        if (carry > 0) {
            int[] newArray = new int[digits.length + 1];
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            newArray[0] = 1;
            digits = newArray;
        }

        return digits;
    }
}
