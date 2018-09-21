package com.leetcode.jumpgame2;

/**
 * Created by titan-developer on 10/31/14.
 * https://oj.leetcode.com/problems/jump-game-ii/
 */
public class JumpGame2 {

    public static void main(String[] strings) {

        int[] a = {2, 3, 1, 0, 1, 4};
        //int[] a = {2, 1};

        JumpGame2 jumper = new JumpGame2();
        System.out.println(jumper.jump(a));
    }

    public int jump(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }

        if (a.length == 1) {
            return 0;
        }

        int range[] = new int[2];
        range[0] = 0;
        range[1] = 0;
        int step = 0;

        while (range[1] < a.length - 1) {
            int max = 0;
            for (int i = range[0] ; i <= range[1] ; i ++) {
                if (i + a[i] > max) {
                    max = i + a[i];
                }
            }

            if (max <= range[1]) {
                return -1;
            }

            range[0] = range[1] + 1;
            range[1] = max;
            step ++;
        }

        return step;
    }

    public int jumpDP(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }

        if (a.length == 1) {
            return 0;
        }

        int step[] = new int[a.length];

        step[0] = 0;

        for (int x = 1; x < a.length; x++) {
            step[x] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 1; j <= a[i]; j++) {
                if (i + j < a.length && step[i] + 1 < step[i + j]) {
                    step[i + j] = step[i] + 1;
                }
            }
        }

        return step[a.length - 1];
    }
}
