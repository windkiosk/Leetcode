package com.leetcode.longestsubstring;

/**
 * Created by bod on 9/9/14.
 * https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubStringWithoutRepeat {

    public static void main(String[] strings) {

        LongestSubStringWithoutRepeat subString = new LongestSubStringWithoutRepeat();
        System.out.println(subString.lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int maxLength = 0;

        StringBuffer currentStr = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            String c = s.substring(i, i + 1);
            int index = currentStr.indexOf(c);
            if (index == -1) {
                currentStr.append(c);
            } else {
                currentStr = currentStr.delete(0, index + 1);
                currentStr.append(c);
            }

            if (currentStr.length() > maxLength) {
                maxLength = currentStr.length();
            }
        }

        return maxLength;
    }

    public int lengthOfLongestSubstringHash(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int max = 0;
        int[] map = new int[256];
        for (int i = 0; i < map.length; i ++) {
            map[i] = -1;
        }

        int len = 0;
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            int index = map[c];
            if (index < 0 || index < i - len) {
                len ++;
                if (len > max)
                    max = len;
            } else {
                len = i - index;
            }
            map[c] = i;
        }

        return max;
    }

}
