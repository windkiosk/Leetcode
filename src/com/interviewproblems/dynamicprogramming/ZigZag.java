package com.interviewproblems.dynamicprogramming;

/**
 * Created by bod on 8/24/14.
 * Description: http://community.topcoder.com/tc?module=ProblemDetail&rd=4493&pm=1259
 */
public class ZigZag {

    public static void main(String[] strings) {
        ZigZag zigZag = new ZigZag();

        int[] array = new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8};

        int longest = zigZag.findLongestZigZag(array);

        System.out.println(longest);


        array = new int[]{1, 7, 4, 9, 2, 5};

        longest = zigZag.findLongestZigZag(array);

        System.out.println(longest);


        array = new int[]{44};

        longest = zigZag.findLongestZigZag(array);

        System.out.println(longest);


        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        longest = zigZag.findLongestZigZag(array);

        System.out.println(longest);


        array = new int[]{70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32};

        longest = zigZag.findLongestZigZag(array);

        System.out.println(longest);


        array = new int[]{374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
                600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
                67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
                477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
                249, 22, 176, 279, 23, 22, 617, 462, 459, 244};

        longest = zigZag.findLongestZigZag(array);

        System.out.println(longest);
    }

    public int findLongestZigZag(int[] array) {
        if (array == null) {
            return 0;
        } else if (array.length == 1) {
            return 1;
        } else {
            int[] zigLength = new int[array.length];
            zigLength[0] = 1;

            int lastTrend = 0;
            int lastValue = array[0];
            for (int i = 1; i < array.length; i++) {
                if (lastTrend == 0) {
                    if (array[i] != lastValue) {
                        zigLength[i] = zigLength[i - 1] + 1;
                        if (array[i] > lastValue) {
                            lastTrend = 1;
                        } else {
                            lastTrend = -1;
                        }
                    }
                    lastValue = array[i];
                } else {
                    if (array[i] > lastValue) {
                        if (lastTrend > 0) {
                            zigLength[i] = zigLength[i - 1];
                            lastValue = array[i];
                        } else {
                            zigLength[i] = zigLength[i - 1] + 1;
                            lastValue = array[i];
                            lastTrend = 1;
                        }
                    } else if (array[i] < lastValue) {
                        if (lastTrend > 0) {
                            zigLength[i] = zigLength[i - 1] + 1;
                            lastValue = array[i];
                            lastTrend = -1;
                        } else {
                            zigLength[i] = zigLength[i - 1];
                            lastValue = array[i];
                        }
                    } else {
                        zigLength[i] = zigLength[i - 1];
                    }
                }
            }

            return zigLength[array.length - 1];
        }
    }
}
