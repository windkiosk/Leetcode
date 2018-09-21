package com.java.language.bitwiseoperator;

/**
 * Created by bod on 8/14/14.
 */
public class Test {

    public static void main(String args[]) {
        int a = 60;	/* 60 = 0011 1100 */
        int b = 13;	/* 13 = 0000 1101 */
        int d = -5;
        int c = 0;

        c = a & b;       /* 12 = 0000 1100 */
        System.out.println("a & b = " + c);

        c = a | b;       /* 61 = 0011 1101 */
        System.out.println("a | b = " + c);

        c = a ^ b;       /* 49 = 0011 0001 */
        System.out.println("a ^ b = " + c);

        c = ~a;          /*-61 = 1100 0011 */
        System.out.println("~a = " + c);

        c = a << 2;     /* 240 = 1111 0000 */
        System.out.println("a << 2 = " + c);

        c = a << 4;     /* 960 = 0011 1100 0000 */
        System.out.println("a << 4 = " + c);

        c = a >> 2;     /* 215 = 1111 */
        System.out.println("a >> 2  = " + c);

        c = a >>> 2;     /* 215 = 0000 1111 */
        System.out.println("a >>> 2 = " + c);

        System.out.println("d = -5, binary is : " + Integer.toBinaryString(d));
        System.out.println("a = 60, binary is : " + Integer.toBinaryString(a));

        c = d >> 2;     /* 215 = 1111 */
        System.out.println("d >> 2  = " + c);

        c = d >>> 2;     /* 215 = 0000 1111 */
        System.out.println("d >>> 2 = " + c);
    }
}
