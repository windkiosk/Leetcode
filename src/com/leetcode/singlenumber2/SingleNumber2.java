package com.leetcode.singlenumber2;

/**
 *
 * https://oj.leetcode.com/problems/single-number-ii/
 *
 * Created by bod on 8/14/14.
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * <p/>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber2 {

    static int[] a = new int[]{
            1,
            1,
            3,
            2,
            2,
            3,
            3,
            2,
            1,
            4,
            5,
            5,
            5,
    };

    public static void main(String[] strings) {
        SingleNumber2 singleNumber2 = new SingleNumber2();
        int x = singleNumber2.singleNumber(a);
        System.out.println(x);

        x = singleNumber2.singleNumber2(a);
        System.out.println(x);
    }

    //refer to http://www.cnblogs.com/daijinqiao/p/3352893.html
    //and http://www.acmerblog.com/leetcode-single-number-ii-5394.html
    int singleNumber(int A[]) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < A.length; i++) {
            twos |= ones & A[i];
            ones ^= A[i];// 异或3次 和 异或 1次的结果是一样的
            //对于ones 和 twos 把出现了3次的位置设置为0 （取反之后1的位置为0）
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }

    public int singleNumber2(int A[]) {
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                int x = A[j] & 1;
                if (x > 0) {
                    count[i]++;
                }
                A[j] = A[j] >> 1;
            }
            result |= ((count[i] % 3) << i);
        }
        return result;
    }
}
