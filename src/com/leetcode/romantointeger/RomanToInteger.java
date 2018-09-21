package com.leetcode.romantointeger;

/**
 * Created by titan-developer on 10/20/14.
 * https://oj.leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

    /**
     * examples
     * X          10
     * MMXIV      2014
     * MCMLIV     1954
     * MCMXC      1990
     * MLXVI      1066
     * CMVIII     908
     * MCMX       1910
     */

    public static void main(String[] strings) {
        RomanToInteger romanToInteger = new RomanToInteger();

        String[] romanStrings = {"X", "MMXIV", "MCMLIV", "MCMXC", "MLXVI", "CMVIII", "MCMX",};
        for (String romanStr : romanStrings) {
            System.out.println(romanToInteger.romanToInt2(romanStr));
        }
    }

    public static int romanToInt2(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    res += (res >= 5 ? -1 : 1);
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10 * (res >= 50 ? -1 : 1);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100 * (res >= 500 ? -1 : 1);
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            char bit0 = s.charAt(i);
            char bit1 = '-';

            if (i < s.length() - 1) {
                bit1 = s.charAt(i + 1);
            }

            int[] result = getNum(bit0, bit1);
            num += result[0];

            if (result[1] == 1) {
                i++;
            }
        }

        return num;
    }

    private int[] getNum(char bit0, char bit1) {
        int value = 0;
        boolean twoStep = false;
        switch (bit0) {
            case 'I': {
                if (bit1 == 'V') {
                    value = 4;
                    twoStep = true;
                } else if (bit1 == 'X') {
                    value = 9;
                    twoStep = true;
                } else {
                    value = 1;
                }
                break;
            }
            case 'V': {
                value = 5;
                break;
            }
            case 'X': {
                if (bit1 == 'L') {
                    value = 40;
                    twoStep = true;
                } else if (bit1 == 'C') {
                    value = 90;
                    twoStep = true;
                } else {
                    value = 10;
                }
                break;
            }
            case 'L': {
                value = 50;
                break;
            }
            case 'C': {
                if (bit1 == 'D') {
                    value = 400;
                    twoStep = true;
                } else if (bit1 == 'M') {
                    value = 900;
                    twoStep = true;
                } else {
                    value = 100;
                }
                break;
            }
            case 'D': {
                value = 500;
                break;
            }
            case 'M': {
                value = 1000;
                break;
            }
        }

        return new int[]{value, twoStep ? 1 : 0};
    }
}
