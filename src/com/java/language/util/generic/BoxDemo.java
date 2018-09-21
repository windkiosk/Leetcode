package com.java.language.util.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by titan-developer on 1/3/15.
 */
public class BoxDemo {

    public static <U> void addBox(U u,
                                  java.util.List<Box<U>> boxes) {
        Box<U> box = new Box<U>();
        box.set(u);
        boxes.add(box);
    }

    public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box : boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" +
                    boxContents.toString() + "]");
            counter++;
        }
    }

    public static void main(String[] args) {
        java.util.ArrayList<Box<Integer>> listOfIntegerBoxes = new ArrayList<Box<Integer>>();
        BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
        BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
        BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
        BoxDemo.outputBoxes(listOfIntegerBoxes);

        java.util.ArrayList<Box<Number>> listOfNumberBoxes = new ArrayList<Box<Number>>();
        BoxDemo.<Number>addBox(Integer.valueOf(10), listOfNumberBoxes);
        BoxDemo.addBox(Integer.valueOf(20), listOfNumberBoxes);
        BoxDemo.addBox(Integer.valueOf(30), listOfNumberBoxes);

        java.util.ArrayList rawlist = listOfNumberBoxes; //hack here.
        BoxDemo.addBox("abc", rawlist);
        BoxDemo.outputBoxes(listOfNumberBoxes);
    }
}
