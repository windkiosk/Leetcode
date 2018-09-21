package com.java.language.util.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by bod on 1/6/2015.
 */
public class HeapPollution {
    public static void main(String[] args) {

        List<String> stringListA = new ArrayList<String>();
        List<String> stringListB = new ArrayList<String>();

        ArrayBuilder.addToList(stringListA, "Seven", "Eight", "Nine");
        ArrayBuilder.addToList(stringListB, "Ten", "Eleven", "Twelve");
        List<List<String>> listOfStringLists =
                new ArrayList<List<String>>();
        ArrayBuilder.addToList(stringListA, stringListB);
        ArrayBuilder.addToList(listOfStringLists,
                stringListA, stringListB);

        ArrayBuilder.faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));
    }
}

class ArrayBuilder {

    public static <T> void addToList (List<T> listArg, List<T> elements) {
        for (T x : elements) {
            listArg.add(x);
        }
    }

    public static <T> void addToList (List<T> listArg, T... elements) {
        for (T x : elements) {
            listArg.add(x);
        }
    }

    public static void faultyMethod(List<String>... l) {
        Object[] objectArray = l;     // Valid
        objectArray[0] = Arrays.asList(42);
        String s = l[0].get(0);       // ClassCastException thrown here
    }

}
