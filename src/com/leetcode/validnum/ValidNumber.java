package com.leetcode.validnum;

/**
 * Created by titan-developer on 11/5/14.
 * https://oj.leetcode.com/problems/valid-number/
 */
public class ValidNumber {

    public static void main(String[] strings) {
        ValidNumber validNumber = new ValidNumber();
        System.out.println(validNumber.isNumber("3."));
        System.out.println(validNumber.isNumber("01"));
        System.out.println(validNumber.isNumber(".1"));
        System.out.println(validNumber.isNumber("e"));
        System.out.println(validNumber.isNumber("005047e+6"));
        System.out.println(validNumber.isNumber("-."));
        System.out.println(validNumber.isNumber("6+1"));
        System.out.println(validNumber.isNumber("0e"));
    }

    public boolean isNumberRegular(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        return s.matches("(\\s*)[+-]?((\\.[0-9]+)|([0-9]+(\\.[0-9]*)?))(e[+-]?[0-9]+)?(\\s*)");
    }

    //Check the DFA diagram :
    //https://drive.google.com/drive/u/0/#folders/0B3aUHDF0ApC9LUE4bzlvQjRpVms
    public boolean isNumber(String str) {
        int state = 0, flag = 0; // flag to judge the special case "."
        str = str.trim();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('0' <= c && c <= '9') {
                flag = 1;
                if (state <= 2) state = 2;
                else state = (state <= 5) ? 5 : 7;
            } else if ('+' == c || '-' == c) {
                if (state == 0 || state == 3) state++;
                else return false;
            } else if ('.' == c) {
                if (state <= 2) state = 6;
                else return false;
            } else if ('e' == c) {
                if (flag == 1 && (state == 2 || state == 6 || state == 7)) state = 3;
                else return false;
            } else return false;
        }
        return (state == 2 || state == 5 || (flag == 1 && state == 6) || state == 7);
    }
}
