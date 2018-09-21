package com.leetcode.containerwithmostwater;

/**
 * Created by titan-developer on 10/20/14.
 * https://oj.leetcode.com/problems/container-with-most-water/
 * <p/>
 * Suppose the returned result is not the optimal solution.
 * Then there must exist an optimal solution, say a container with aol and aor (left and right respectively),
 * such that it has a greater volume than the one we got. Since our algorithm stops only if the two pointers meet.
 * So, we must have visited one of them but not the interviewproblems.
 * WLOG, let's say we visited aol but not aor. When a pointer stops at a_ol, it won't move until
 * <p/>
 * The interviewproblems pointer also points to aol.
 * In this case, iteration ends.
 * But the interviewproblems pointer must have visited aor on its way from right end to aol.
 * Contradiction to our assumption that we didn't visit aor.
 * <p/>
 * The interviewproblems pointer arrives at a value,
 * say arr, that is greater than aol before it reaches aor.
 * In this case, we does move aol.
 * But notice that the volume of aol and arr is already greater than aol and aor (as it is wider and heigher),
 * which means that aol and aor is not the optimal solution -- Contradiction!
 * <p/>
 * https://oj.leetcode.com/discuss/1074/anyone-who-has-a-o-n-algorithm
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int len = height.length, low = 0, high = len - 1;
        int maxArea = 0;
        while (low < high) {
            maxArea = Math.max(maxArea, (high - low) * Math.min(height[low], height[high]));
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }
}
