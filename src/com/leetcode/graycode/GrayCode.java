package com.leetcode.graycode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by titan-developer on 11/11/14.
 * https://oj.leetcode.com/problems/gray-code/
 */
public class GrayCode {

    public static void main(String[] strings) {
        GrayCode grayCode = new GrayCode();

        List<Integer> list = grayCode.grayCodeBackTrack(3);
        for (int i : list) {
            System.out.println(Integer.toBinaryString(i));
        }
    }

    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        for (int i = 0; i < n; i++) {
            int inc = 1 << i;
            for (int j = arr.size() - 1; j >= 0; j--) {
                arr.add(arr.get(j) + inc);
            }
        }
        return arr;
    }

    public ArrayList<Integer> grayCode3rd(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        for (int i = 0; i < n; i++) {
            int inc = 1 << i;
            for (int j = arr.size() - 1; j >= 0; j--) {
                arr.add(arr.get(j) + inc);
            }
        }
        return arr;
    }

    public List<Integer> grayCodeNew(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        if (n <= 0) return ret;
        boolean[] set = new boolean[1 << n];
        set[0] = true;
        int count = 1, current = 0;
        while (count < set.length) {
            for (int i = 0; i < n; i++) {
                int mask = 1 << i;
                int v = current ^ mask;
                if (!set[v]) {
                    set[v] = true;
                    count++;
                    current = v;
                    ret.add(v);
                    break;
                }
            }
        }
        return ret;
    }

    public List<Integer> grayCodeBackTrack(int n) {
        List<Integer> list = new ArrayList<Integer>();
        if (n <= 0) {
            return list;
        }

        HashSet<Integer> set = new HashSet<Integer>();
        list.add(0);
        set.add(0);
        helper(list, set, 0, n);

        return list;
    }

    private boolean helper(List<Integer> list, HashSet<Integer> set, int current, int n) {
        if (list.size() == (1 << n)) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            int tmp;
            if ((current & (1 << i)) == 0) {
                tmp = current + (1 << i);
            } else {
                tmp = current - (1 << i);
            }

            if (!set.contains(tmp)) {
                set.add(tmp);
                current = tmp;
                list.add(current);
                return helper(list, set, current, n);
            }
        }

        return false;
    }
}
