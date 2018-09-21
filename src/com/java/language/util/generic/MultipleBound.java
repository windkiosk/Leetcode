package com.java.language.util.generic;

/**
 * Created by titan-developer on 1/2/15.
 */
public class MultipleBound implements A, B, C {
    public static void main(String[] strings) {
        TestMultiBound<MultipleBound> testMultiBound = new TestMultiBound<MultipleBound>();
    }
}

interface A {

}

interface B {

}

interface C {

}

class TestMultiBound <T extends MultipleBound & A & C> {

}