package com.leetcode.triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/triangle/
 */
public class Triangle {

    public static void main(String[] strings) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(2);

        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(3);
        l1.add(4);

        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(6);
        l2.add(5);
        l2.add(7);

        List<Integer> l3 = new ArrayList<Integer>();
        l3.add(4);
        l3.add(1);
        l3.add(8);
        l3.add(3);

        lists.add(l0);
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);

        Triangle triangle = new Triangle();
        System.out.println(triangle.minimumTotal(lists));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int level = triangle.size();

        for (int i = level - 2; i >= 0; i --) {
            List<Integer> list = triangle.get(i);
            List<Integer> nestList = triangle.get(i + 1);

            for (int j = 0 ; j < list.size(); j ++) {
                int v = list.get(j);
                int min = Math.min(nestList.get(j), nestList.get(j + 1));
                list.remove(j);
                list.add(j, v + min);
            }
        }

        return triangle.get(0).get(0);
    }
}
