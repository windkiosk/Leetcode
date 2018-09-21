package com.lintcode.medianofstream;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by bod on 1/24/15.
 * http://lintcode.com/problem/median-ii
 */
public class MedianOfStream {

    public static void main(String[] strings) {
        int[] a = {7, 2, 9, 1, 8, 5, 4, 3, 10};
        int[] b = {1, 2, 3, 4, 5};
        MedianOfStream medianOfStream = new MedianOfStream();
        System.out.println(Arrays.toString(medianOfStream.medianII(b)));
    }

    public int[] medianII(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        PriorityQueue<Integer> max = new PriorityQueue<Integer>(100, Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<Integer>(100);

        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (max.size() <= min.size()) {
                if (min.size() == 0 || min.peek() > v) {
                    max.add(v);
                } else {
                    int r = min.poll();
                    min.add(v);
                    max.add(r);
                }
            } else {
                int r = max.peek();
                if (v > r) {
                    min.add(v);
                } else {
                    max.add(v);
                    r = max.poll();
                    min.add(r);
                }
            }
            ret[i] = max.peek();
        }

        return ret;
    }
}
