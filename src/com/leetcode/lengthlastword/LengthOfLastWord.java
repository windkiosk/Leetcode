package com.leetcode.lengthlastword;

/**
 * Created by titan-developer on 11/4/14.
 * https://oj.leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {

    public static void main(String[] strings) {
        LengthOfLastWord checkLength = new LengthOfLastWord();
        System.out.println(checkLength.lengthOfLastWord("world "));
    }

    public int lengthOfLastWord(String s) {
        int length = 0;
        if (s == null || s.length() == 0) {
            return length;
        }

        int l = s.length();
        boolean isStartCount = false;
        for (int i = l - 1 ; i >= 0 ; i --) {
            char c = s.charAt(i);

            if (c == ' ') {
                if (isStartCount) {
                    break;
                }
            } else {
                if (!isStartCount) {
                    isStartCount = true;
                }
                length ++;
            }

        }

        return length;
    }
}
