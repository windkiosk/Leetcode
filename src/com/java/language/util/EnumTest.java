package com.java.language.util;

/**
 * Created by bod on 1/16/2015.
 */
public class EnumTest {
    Type type;
    int value;

    public EnumTest() {

    }

    public static void main(String[] strings) {
        EnumTest enumTest = new EnumTest();
        System.out.println(enumTest.type);

        if (enumTest == enumTest) {
            System.out.println("equal");
        }
    }
}

enum Type {
    A,
    B,
}
