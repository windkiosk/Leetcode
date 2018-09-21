package com.leetcode.jumpgame;

/**
 * Created by titan-developer on 10/31/14.
 * https://oj.leetcode.com/problems/jump-game/
 */
public class JumpGame1 {

    public static void main(String[] strings) {
        int[] a = {3, 2, 1, 0, 4};
        int[] b = {2, 3, 1, 1, 4};

        JumpGame1 jumper = new JumpGame1();
        System.out.println(jumper.canJump(a));
        System.out.println(jumper.canJump(b));
    }

    public boolean canJump(int[] a) {
        if (a == null || a.length == 0) {
            return false;
        }

        if (a.length == 1) {
            return true;
        }

        int range[] = new int[2];
        range[0] = 0;
        range[1] = 0;
        int step = 0;

        while (range[1] < a.length - 1) {
            int max = 0;
            for (int i = range[0]; i <= range[1]; i++) {
                if (i + a[i] > max) {
                    max = i + a[i];
                }
            }

            if (max <= range[1]) {
                return false;
            }

            range[0] = range[1] + 1;
            range[1] = max;
            step++;
        }

        return step > 0;
    }
}
