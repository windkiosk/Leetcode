package com.leetcode.reversewords2;

/**
 * Created by titan-developer on 2/14/15.
 */
public class ReverseWords2 {

    public static void main(String[] strings) {
        ReverseWords2 reverseWords2 = new ReverseWords2();

        String ori = "the sky is blue";

        char[] s = ori.toCharArray();

        reverseWords2.reverseWords(s);

        System.out.println(new String(s));
    }

    public void reverseWords(char[] s) {
        int left = 0, right = s.length - 1;

        reverseWords(s, left, right);

        right = 0;

        while (right < s.length) {
            if (s[right] == ' ') {
                reverseWords(s, left, right - 1);
                left = right + 1;
            }

            right ++;
        }

        right --;
        if (left < right) {
            reverseWords(s, left, right);
        }
    }

    void reverseWords(char[] s, int left, int right) {
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left ++;
            right --;
        }
    }

}
