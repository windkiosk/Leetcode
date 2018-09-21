package com.leetcode.largestrectangle;

import java.util.Stack;

/**
 * Created by titan-developer on 10/21/14.
 * https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * <p/>
 * Solution refers to:
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 */
public class LargestRectangleArea {

    public static void main(String[] strings) {
        int[] height0 = {2, 2, 3, 3, 4, 3, 2, 2, 2};
        int[] height = {2, 1, 5, 6, 2, 3};
        int[] height1 = {2, 1, 5, 100, 2, 3};
        int[] height2 = {2, 2, 3, 3, 4, 3};
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        System.out.println(largestRectangleArea.largestRectangleArea(height0));
        System.out.println(largestRectangleArea.largestRectangleArea(height));
        System.out.println(largestRectangleArea.largestRectangleArea(height1));
        System.out.println(largestRectangleArea.largestRectangleArea(height2));
    }

    // The main function to find the maximum rectangular area under given
    // histogram with n bars
    public int largestRectangleArea(int hist[]) {
        // Create an empty stack. The stack holds indexes of hist[] array
        // The bars stored in stack are always in increasing order of their
        // heights.
        Stack<Integer> stack = new Stack<Integer>();

        int max_area = 0; // Initialize max area
        int tp;  // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        int i = 0;
        while (i < hist.length) {
            // If this bar is higher than the bar on top stack, push it to stack
            if (stack.empty() || hist[stack.peek()] <= hist[i])
                stack.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else {
                tp = stack.pop();  // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = hist[tp] * (stack.empty() ? i : i - stack.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (!stack.empty()) {
            tp = stack.pop();
            area_with_top = hist[tp] * (stack.empty() ? i : i - stack.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;
    }

    /**
     * Big O N2
     *
     * @param height
     * @return
     */
    public int largestRectangleAreaON2(int[] height) {
        int max = 0;

        if (height == null || height.length == 0)
            return max;

        if (height.length == 1) {
            return height[0];
        }

        int[][] maxHeight = new int[height.length][height.length];

        maxHeight[0][0] = height[0];
        max = height[0];
        for (int i = 1; i < height.length; i++) {
            maxHeight[i][i] = height[i];
            if (height[i] > max) {
                max = height[i];
            }

            for (int j = 0; j < i; j++) {
                maxHeight[j][i] = Math.min(maxHeight[j][i - 1], height[i]);
                int rectSize = (i - j + 1) * maxHeight[j][i];
                if (rectSize > max) {
                    max = rectSize;
                }
            }
        }

        return max;
    }
}
