package com.leetcode.candy;

/**
 *
 * https://oj.leetcode.com/problems/candy/
 *
 * Created by titan-developer on 8/19/14.
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p/>
 * You are giving candies to these children subjected to the following requirements:
 * <p/>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 */
public class Candy {

    public static void main(String[] strings) {

        int[] ratings = new int[]{2, 1, 5, 4, 7, 9, 8, 3};

        Candy candy = new Candy();
        candy.candy(ratings);
    }

    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        //allocate candies, considering the minimal rating on the left
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            candy[i] = ratings[i] > ratings[i - 1] ? candy[i - 1] + 1 : 1;
        }
        //modify the allocation, considering the minimal rating on the right
        int totalCandy = candy[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            candy[i] = (ratings[i] > ratings[i + 1] && candy[i + 1] + 1 > candy[i]) ? candy[i + 1] + 1 : candy[i];
            //count total candies by the way
            totalCandy += candy[i];
        }
        return totalCandy;
    }
}
