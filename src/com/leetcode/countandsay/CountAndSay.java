package com.leetcode.countandsay;

/**
 * Created by titan-developer on 10/28/14.
 * https://oj.leetcode.com/problems/count-and-say/
 */
public class CountAndSay {

    public static void main(String[] strings) {
        CountAndSay countAndSay = new CountAndSay();
        System.out.println(countAndSay.countAndSay(7));
    }

    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }

        StringBuilder current = new StringBuilder("1");

        for (int i = 2 ; i <= n ; i ++) {
            int index = 0;
            StringBuilder newStr = new StringBuilder();
            while (index < current.length()) {
                char say = current.charAt(index);
                int count = 0;
                while (index + count < current.length() && current.charAt(index + count) == say) {
                    count++;
                }
                index += count;
                char cc = (char)('0' + count);
                newStr.append(cc);
                newStr.append(say);
            }
            current = newStr;
        }

        return current.toString();
    }
}
