package com.java.language.util;

import java.util.ArrayDeque;

/**
 * Created by titan-developer on 12/24/14.
 */
public class TestArrayDeque {
    public static void main(String[] strings) {

        int a = 23 >> 1;
        int b = (-23) >> 1;
        int c = 23 >>> 1;
        int d = (-23) >>> 1;

//        int initialCapacity = 1073741824;
//        initialCapacity |= (initialCapacity >>>  1);
//        initialCapacity |= (initialCapacity >>>  2);
//        initialCapacity |= (initialCapacity >>>  4);
//        initialCapacity |= (initialCapacity >>>  8);
//        initialCapacity |= (initialCapacity >>> 16);
//        initialCapacity++;
//
//        if (initialCapacity < 0)   // Too many elements, must back off
//            initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements

        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE - 1));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE + 1));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));

        System.out.println(a + ", " + b + ", " + c + ", " + d);

        ArrayDeque<Integer> deque = new ArrayDeque<Integer>(23);

        for (int i = 0; i < 50; i ++) {
            if (i % 2 == 0) {
                deque.offerFirst(i);
            } else {
                deque.offerLast(i);
            }
        }

        System.out.println(deque);
    }

}
