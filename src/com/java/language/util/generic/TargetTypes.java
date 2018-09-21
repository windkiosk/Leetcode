package com.java.language.util.generic;

import java.util.Collections;
import java.util.List;

/**
 * Created by titan-developer on 1/4/15.
 */
public class TargetTypes <T extends Number> {
    public static void main(String[] strings) {
        List<String> listOne = Collections.emptyList();
        listOne = Collections.emptyList();
        listOne = Collections.<String>emptyList();
    }
}
