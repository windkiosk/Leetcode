package com.leetcode.stringtointeger;

/**
 * Created by titan-developer on 9/13/14.
 * https://oj.leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {

    public static void main(String[] strings) {

        StringToInteger stringToInteger = new StringToInteger();

        System.out.println(stringToInteger.atoi("+1"));
        System.out.println(stringToInteger.atoi("        -479484a"));
        System.out.println(stringToInteger.atoi("2147483647"));
        System.out.println(stringToInteger.atoi("-2147483648"));
        System.out.println(stringToInteger.atoi("-08"));
        System.out.println(stringToInteger.atoi("+-08"));
    }

    public int atoi(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
            //throw new NumberFormatException();
        }

        str = str.trim();
        int length = str.length();

        boolean isNegative = false;
        boolean isHasSymbol = false;
        int tail = 0;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);

            if (i == 0 && (c == '-' || c == '+')) {
                isHasSymbol = true;
                if (c == '-')
                    isNegative = true;
                continue;
            }

            if (i > 13) {
                return 0;
                //throw new NumberFormatException();
            }

            if (c >= '0' && c <= '9') {
                tail = i;
                continue;
            } else {
                break;
                //throw new NumberFormatException();
            }
        }

        str = str.substring(0, tail + 1);
        length = str.length();

        int intValue = 0;
        int endValue = isHasSymbol ? 1 : 0;
        for (int i = length - 1; i >= endValue; i--) {
            char c = str.charAt(i);
            int temp = charToInt(c) * (int) Math.pow(10, length - i - 1);
            if (isNegative) {
                temp = -temp;
            }

            intValue += temp;

            if (isNegative && intValue > 0) {
                return Integer.MIN_VALUE;
                //throw new NumberFormatException();
            }

            if (!isNegative && intValue < 0) {
                return Integer.MAX_VALUE;
                //throw new NumberFormatException();
            }
        }

        return intValue;
    }

    public int charToInt(char c) {
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                return 0;
        }
    }
}
