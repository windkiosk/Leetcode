package com.java.language.util.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bod on 1/5/2015.
 */
public class WildCardAndSubType {
    public static void main(String[] stings) {
        List<? extends Integer> intList = new ArrayList<Integer>();
        List<? extends Number>  numList = intList;  // OK. List<? extends Integer> is a subtype of List<? extends Number>
        //intList = numList; // compile error here.
    }
}
