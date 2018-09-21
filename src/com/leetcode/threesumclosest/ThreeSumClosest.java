package com.leetcode.threesumclosest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by titan-developer on 10/22/14.
 * https://oj.leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {

    public static void main(String[] strings) {
        int a[] = {6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10};
        //int a[] = {-1, 2, 1, -4};

        ThreeSumClosest closest = new ThreeSumClosest();
        System.out.println(closest.threeSumClosest(a, -52));
    }

    public int threeSumClosest(int[] num, int target) {
        boolean isFirst = true;
        int closest = Integer.MIN_VALUE;
        if (num == null || num.length < 3) {
            return closest;
        }
        Arrays.sort(num);

        int currentValue;
        for (int i = 0; i < num.length; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;
            if (( target > 0 && num[i] >= target ) ) {
                if (i == 0) {
                    currentValue = num[i] + num[i + 1] + num[i + 2];
                    if (isFirst || Math.abs(currentValue - target) < Math.abs(closest - target)) {
                        isFirst = false;
                        closest = currentValue;
                    }
                }
                break;
            } else {
                for (int j = i + 1, k = num.length - 1; k > j; ) {
                    if (j > i + 1 && num[j] == num[j - 1]) {
                        j++;
                        continue;
                    }
                    if (target > 0 && num[j] + num[i] > target) {
                        currentValue = num[i] + num[j] + num[k];
                        if (isFirst || Math.abs(currentValue - target) < Math.abs(closest - target)) {
                            isFirst = false;
                            closest = currentValue;
                        }
                        break;
                    }
                    if (num[j] + num[i] + num[k] < target) {
                        currentValue = num[i] + num[j] + num[k];
                        if (isFirst || Math.abs(currentValue - target) < Math.abs(closest - target)) {
                            isFirst = false;
                            closest = currentValue;
                        }
                        j++;
                    }
                    else if (num[j] + num[i] + num[k] > target) {
                        currentValue = num[i] + num[j] + num[k];
                        if (isFirst || Math.abs(currentValue - target) < Math.abs(closest - target)) {
                            isFirst = false;
                            closest = currentValue;
                        }
                        k--;
                    }
                    else {
                        return target;
                    }
                }
            }

        }

        return closest;
    }
}
