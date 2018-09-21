package com.leetcode.largestnumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by titan-developer on 1/13/15.
 * https://oj.leetcode.com/problems/largest-number/
 */
public class LargestNumber {
    public static void main(String[] strings) {
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber.largestNumber(new int[]{2048}));
    }


    public String largestNumber(int[] num) {
        StringBuffer sbuf = new StringBuffer();
        ArrayList<String> numstrings = new ArrayList<String>(num.length);

        for (int i : num) numstrings.add(String.valueOf(i));
        Collections.sort(numstrings, new StringComparator());

        for (String s : numstrings) sbuf.append(s);

        String res = sbuf.toString();
        if (res.length() > 0 && res.charAt(0) == '0') return "0";

        return res;
    }
}

class StringComparator implements Comparator<String> {
    public int compare(String a, String b) {
        if (a.length() == b.length()) {
            return b.compareTo(a);
        } else {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        }
    }
}
