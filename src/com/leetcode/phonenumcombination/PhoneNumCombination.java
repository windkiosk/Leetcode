package com.leetcode.phonenumcombination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bod on 10/23/14.
 * https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class PhoneNumCombination {

    public static void main(String[] strings) {

        String num = "22";

        PhoneNumCombination combination = new PhoneNumCombination();

        List<String> list = combination.letterCombinations(num);

        for (int i = 0 ; i < list.size() ; i ++) {
            System.out.println(i + " : " + list.get(i));
        }
    }

    static char[] map_2 = {'a', 'b', 'c'};
    static char[] map_3 = {'d', 'e', 'f'};
    static char[] map_4 = {'g', 'h', 'i'};
    static char[] map_5 = {'j', 'k', 'l'};
    static char[] map_6 = {'m', 'n', 'o'};
    static char[] map_7 = {'p', 'q', 'r', 's'};
    static char[] map_8 = {'t', 'u', 'v'};
    static char[] map_9 = {'w', 'x', 'y', 'z'};

    protected char[] getCharArray(char c) {
        switch (c) {
            case '2':
                return map_2;
            case '3':
                return map_3;
            case '4':
                return map_4;
            case '5':
                return map_5;
            case '6':
                return map_6;
            case '7':
                return map_7;
            case '8':
                return map_8;
            case '9':
                return map_9;
        }

        return null;
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<String>();

        if (digits == null)
            return list;

        digits = digits.replace("0", "");
        digits = digits.replace("1", "");
        digits = digits.replace("*", "");
        digits = digits.replace("#", "");

        if (digits.length() == 0) {
            list.add("");
            return list;
        }

        recursiveLetterCombination(digits, list);

        return list;
    }

    private void recursiveLetterCombination(String digits, ArrayList<String> list) {
        if (digits.length() == 0) {
            return;
        }

        char c = digits.charAt(0);
        char[] chars = getCharArray(c);
        int size = list.size();

        if (size == 0) {
            for (char x : chars) {
                String str = "" + x;
                list.add(str);
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                String str = list.get(i);
                list.remove(i);
                for (char x : chars) {
                    list.add(str + x);
                }
            }
        }

        recursiveLetterCombination(digits.substring(1), list);
    }

    public List<String> letterCombinations_Recurrence(String digits) {
        ArrayList<String> list = new ArrayList<String>();

        if (digits == null)
            return list;

        digits = digits.replace("0", "");
        digits = digits.replace("1", "");
        digits = digits.replace("*", "");
        digits = digits.replace("#", "");

        if (digits.length() == 0) {
            list.add("");
            return list;
        }

        char[][] arrayList = new char[digits.length()][];

        int possibility = 1;
        for (int i = 0; i < digits.length(); i ++) {
            char c = digits.charAt(i);
            char[] chars = getCharArray(c);
            arrayList[i] = getCharArray(c);
            possibility *= chars.length;
        }

        for (int i = 0 ; i < possibility ; i ++) {
            StringBuilder buffer = new StringBuilder();
            int currentBase;
            int index;
            int code = i;
            for (int j = arrayList.length - 1 ; j >= 0 ; j --) {
                if (code > 0) {
                    currentBase = arrayList[j].length;
                    index = code % currentBase;
                    buffer.append(arrayList[j][index]);
                    code = code / currentBase;
                } else {
                    buffer.append(arrayList[j][0]);
                }
            }
            list.add(buffer.reverse().toString());
        }

        return list;
    }

}
