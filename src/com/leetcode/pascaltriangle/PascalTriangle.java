package com.leetcode.pascaltriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/pascals-triangle/
 */
public class PascalTriangle {

    public static void main(String[] strings) {

        PascalTriangle pascalTriangle = new PascalTriangle();

        outputList(pascalTriangle.generate(7));
    }

    public static void outputList(List<List<Integer>> list) {
        for (List<Integer> intList : list) {
            for (int a : intList) {
                System.out.print(a + " , ");
            }
            System.out.println("");
        }
        System.out.println("--------------");
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        if (numRows <= 0) {
            return lists;
        }

        List<Integer> array = new ArrayList<Integer>();
        array.add(1);
        lists.add(array);

        for (int i = 0; i < numRows - 1; i++) {
            array = lists.get(i);

            List<Integer> nextArray = new ArrayList<Integer>();

            for (int j = 0; j <= i + 1; j++) {
                int v = 0;
                if (j == 0) {
                    v += array.get(0);
                } else if (j == i + 1) {
                    v += array.get(i);
                } else {
                    v += (array.get(j - 1) + array.get(j));
                }
                nextArray.add(v);
            }

            lists.add(nextArray);
        }

        return lists;
    }

}
