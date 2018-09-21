package com.leetcode.twosum;

import java.util.HashMap;

/**
 * Created by bod on 9/7/14.
 * https://oj.leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public static void main(String[] strings) {
        int[] test = {2, 7, 11, 15};

        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(test, 18);

        System.out.println(result[0] + ", " + result[1]);
    }

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int val = numbers[i];
            if (map.containsKey((target - val))) {
                int firstIndex = map.get((target - val));
                result[0] = firstIndex + 1;
                result[1] = i + 1;

                return result;
            } else {
                map.put(val, i);
            }
        }

        return result;
    }

}
