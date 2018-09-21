package com.java.language.util.generic;

import java.util.Comparator;
import java.util.List;

/**
 * Created by bod on 1/6/2015.
 */
public class Practice {
    public static <T> void switchElements(T[] array, int from, int to) {
        T tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }


    public static void print(List<? extends Number> list) {
        for (Number n : list)
            System.out.print(n + " ");
        System.out.println();
    }

    public static <T extends Object & Comparable<? super T>> T max(List<? extends T> list, int begin, int end) {
        T maxElem = list.get(begin);

        for (++begin; begin < end; ++begin)
            if (maxElem.compareTo(list.get(begin)) < 0)
                maxElem = list.get(begin);
        return maxElem;
    }

    public static <T>
    int findFirst(List<T> list, int begin, int end, UnaryPredicate<T> p) {

        for (; begin < end; ++begin)
            if (p.test(list.get(begin)))
                return begin;
        return -1;
    }

    // x > 0 and y > 0
    public static int gcd(int x, int y) {
        for (int r; (r = x % y) != 0; x = y, y = r) { }
        return y;
    }
}

interface UnaryPredicate<T> {
    public boolean test(T obj);
}