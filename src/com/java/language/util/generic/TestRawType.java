package com.java.language.util.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 1/2/15.
 */
public class TestRawType {

    public static void main(String[] strings) {
        TestRawType testRawType = new TestRawType();
        testRawType.test1();
        testRawType.test2();
        testRawType.test3();

        Pair<Integer, String> p1 = new OrderedPair<Integer, String>(1, "apple");
        Pair<Integer, String> p2 = new OrderedPair<Integer, String>(2, "pear");
        Pair<Integer, Integer> p3 = new OrderedPair<Integer, Integer>(1, 1);
        boolean same = TestRawType.<Integer, String>compare(p1, p2);
        same = TestRawType.compare(p1, p2);
        //same = TestRawType.compare(p1, p3); //p3 compile error
        //same = TestRawType.<Integer, Integer>compare(p1, p3); //p1 compile error
        //same = TestRawType.<Object, Object>compare(p1, p2); //p1, p2 compile error


        //List<String> list = pick("1", new ArrayList<String>());
        Serializable serializable = pick("1", new ArrayList<String>());
    }

    void test1() {
        Box<String> stringBox = new Box<String>();
        Box rawBox = stringBox;               // OK
        System.out.println(rawBox);
    }

    void test2() {
        Box rawBox = new Box();           // rawBox is a raw type of Box<T>
        Box<Integer> intBox = rawBox;     // warning: unchecked conversion
        System.out.println(rawBox);
        System.out.println(intBox);
    }

    void test3() {
        Box<Integer> intBox = new Box<Integer>();
        Box rawBox = intBox;
        rawBox.set("abc");  // warning: unchecked invocation to set(T)
        //intBox.set("abc"); //compile error here.
        System.out.println(intBox.get());
    }

    void warningDemo(){
        Box<Integer> bi;
        bi = createBox();
    }

    Box createBox(){
        return new Box();
    }

    <T> void testGenericMethod(T a) {
        System.out.println(a.getClass());
    }

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }

    public static <T> T pick(T a1, T a2) {
        return a2;
    }
}
