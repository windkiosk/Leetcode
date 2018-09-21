package com.leetcode.integertoroman;

import java.util.LinkedHashMap;

/**
 * Created by titan-developer on 10/20/14.
 * https://oj.leetcode.com/problems/integer-to-roman/
 */
public class IntegerToRoman {

    public static void main(String[] strings) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman2(10));
        System.out.println(integerToRoman.intToRoman2(2014));
        System.out.println(integerToRoman.intToRoman2(1954));
        System.out.println(integerToRoman.intToRoman2(1990));
        System.out.println(integerToRoman.intToRoman2(1066));
        System.out.println(integerToRoman.intToRoman2(908));
        System.out.println(integerToRoman.intToRoman2(1910));
    }


    private static LinkedHashMap<Integer, String> numToRoman = new LinkedHashMap<Integer, String>();

    static {
        numToRoman.put(1000, "M");
        numToRoman.put(900, "CM");
        numToRoman.put(500, "D");
        numToRoman.put(400, "CD");
        numToRoman.put(100, "C");
        numToRoman.put(90, "XC");
        numToRoman.put(50, "L");
        numToRoman.put(40, "XL");
        numToRoman.put(10, "X");
        numToRoman.put(9, "IX");
        numToRoman.put(5, "V");
        numToRoman.put(4, "IV");
        numToRoman.put(1, "I");
    }

    public String intToRoman2(int num) {
        for (Integer i : numToRoman.keySet()) {
            if (num >= i) {
                return numToRoman.get(i) + intToRoman(num - i);
            }
        }
        return "";
    }
    //--------------------------------------------------

    //num is a number from 1 to 3999
    public String intToRoman(int num) {
        String romanStr = "";
        if (num < 1 || num > 3999)
            return romanStr;


        int bit0 = num % 10;
        if (bit0 != 0) {
            romanStr = createbitStr(bit0, "I", "V", "X") + romanStr;
        }

        if (num >= 10) {
            int bit1 = num % 100 - bit0;

            if (bit1 != 0) {
                romanStr = createbitStr(bit1 / 10, "X", "L", "C") + romanStr;
            }

            if (num >= 100) {
                int bit2 = num % 1000 - bit1 - bit0;

                if (bit2 != 0) {
                    romanStr = createbitStr(bit2 / 100, "C", "D", "M") + romanStr;
                }

                if (num >= 1000) {
                    int bit3 = num - bit0 - bit1 - bit2;

                    if (bit3 != 0) {
                        romanStr = createbitStr(bit3 / 1000, "M", "-", "-") + romanStr;
                    }
                }
            }
        }

        return romanStr;
    }

    private String createbitStr(int bit, String one, String five, String ten) {
        String bitStr = "";
        switch (bit) {
            case 1:
                bitStr = one;
                break;
            case 2:
                bitStr = one + one;
                break;
            case 3:
                bitStr = one + one + one;
                break;
            case 4:
                bitStr = one + five;
                break;
            case 5:
                bitStr = five;
                break;
            case 6:
                bitStr = five + one;
                break;
            case 7:
                bitStr = five + one + one;
                break;
            case 8:
                bitStr = five + one + one + one;
                break;
            case 9:
                bitStr = one + ten;
                break;
        }

        return bitStr;
    }
}
