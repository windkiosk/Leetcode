package com.java.language.util.generic;

import java.util.Arrays;
import java.util.List;

/**
 * Created by titan-developer on 1/4/15.
 */
public class UpperWildCard {

    public static void main(String[] strings) {


        List<Integer> li = Arrays.<Integer>asList(1, 2, 3);
        output(li);
        System.out.println("sum = " + sumOfList(li));

        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        output(ld);
        System.out.println("sum = " + sumOfList(ld));
        //outputList(ld); //error compile

        List<Object> lo = Arrays.<Object>asList(new Integer(10), new Double(1.0d));
        output(lo);
    }

    public static void outputList(List<Object> list) {

    }

    public static <T> void output(List<T> list) {
        for (T t : list) {
            System.out.print(t + ", ");
        }
        System.out.println();
    }

    public static void process(List<? extends Number> list) {
        for (Number elem : list) {
            // ...
        }
    }

    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }
}
