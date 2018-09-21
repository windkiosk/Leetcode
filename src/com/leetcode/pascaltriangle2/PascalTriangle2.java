package com.leetcode.pascaltriangle2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalTriangle2 {

    public static void main(String[] string) {
        PascalTriangle2 triangle2 = new PascalTriangle2();
        List<Integer> list = triangle2.getRow(4);

        for (int v : list) {
            System.out.print(v + ", ");
        }

        System.out.println();

        list = triangle2.getRowByMath(6);

        for (int v : list) {
            System.out.print(v + ", ");
        }
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            result.add(0, 1);
            for (int j = 1; j < result.size() - 1; j++) {
                int v_j = result.get(j) + result.get(j + 1);
                result.remove(j);
                result.add(j, v_j);
            }
        }
        return result;
    }

    /**
     *
     *              1
     *            1   1
     *          1   2   1
     *        1   3   3   1
     *      1   4   6   4   1
     *    1   5  10   10  5   1
     *  1   6  15   20  15  6   1
     *
     *
     */

    public List<Integer> getRowByMath(int rowIndex) {
        List<Integer> resultList = new ArrayList<Integer>();
        if (rowIndex == 0) {
            resultList.add(1);
            return resultList;
        }

        int num = rowIndex / 2;
        long temp = 1; // Some test cases have numbers larger than Integer.MAX_VALUE
        resultList.add((int) temp);

        // Compute first half using C(n, m) = C(n, m - 1) * (n - m + 1) / m;
        for (int i = 1; i <= num; i++) {
            temp *= rowIndex - i + 1;
            temp /= i;
            resultList.add((int) temp);
        }

        // Mirror the second half
        for (int i = (rowIndex - 1) / 2; i >= 0; i--) {
            resultList.add(resultList.get(i));
        }

        return resultList;
    }
}
