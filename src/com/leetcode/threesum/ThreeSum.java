package com.leetcode.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by titan-developer on 10/19/14.
 * https://oj.leetcode.com/problems/3sum/
 */
public class ThreeSum {

    public static void main(String string[]) {
        int value[] = {-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> list = threeSum.threeSum(value);

        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

    public List<List<Integer>> threeSum(int[] num) {
        List resultList = new ArrayList();
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;
            if (num[i] > 0) {
                break;
            } else {
                for (int j = i + 1, k = num.length - 1; k > j; ) {
                    if (j > i + 1 && num[j] == num[j - 1]) {
                        j++;
                        continue;
                    }
                    if (num[j] + num[i] > 0) {
                        break;
                    }
                    if (num[j] + num[i] + num[k] < 0)
                        j++;
                    else if (num[j] + num[i] + num[k] > 0)
                        k--;
                    else {
                        List ll = Arrays.asList(num[i], num[j], num[k]);
                        resultList.add(ll);
                        j++;
                    }
                }
            }

        }
        return resultList;
    }

}
