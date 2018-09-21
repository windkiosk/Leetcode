package com.leetcode.reverseinteger;

/**
 * Created by titan-developer on 9/13/14.
 * https://oj.leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public static void main(String[] strings) {

        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(123));
        System.out.println(reverseInteger.reverse(-123));
        System.out.println(reverseInteger.reverse(101));
        System.out.println(reverseInteger.reverse(100));
        System.out.println(reverseInteger.reverse(-1010));
    }

    public int reverse(int x) {
        boolean isNegative = false;

        if (x < 0) {
            isNegative = true;
            x = -x;
        }

        long ret = 0;

        while (x > 0) {
            int tmp = x / 10;
            ret = ret * 10 + x % 10;
            if (ret > 0x7fffffff) {
                return 0;
            }
            x = tmp;
        }

        return isNegative ? - (int) ret : (int) ret;
    }
}
