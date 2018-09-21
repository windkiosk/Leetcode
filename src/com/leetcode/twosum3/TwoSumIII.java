package com.leetcode.twosum3;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by titan-developer on 12/25/14.
 * https://oj.leetcode.com/problems/two-sum-iii-data-structure-design/
 */
public class TwoSumIII {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void add(int number) {
        int v = map.containsKey(number) ? map.get(number) : 0;
        map.put(number, v + 1);
    }

    public boolean find(int value) {
        Iterator<Integer> iter = map.keySet().iterator();
        while(iter.hasNext()) {
            int a = iter.next();
            int b = value - a;
            if (map.containsKey(b) && (a != b || map.get(b) > 1))return true;
        }
        return false;
    }
}
