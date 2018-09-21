package com.java.language.util.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bod on 1/6/2015.
 */
public class CreateObj {

    public static void main(String[] strings) {
        List<String> list = new ArrayList<String>();
        try {
            append(list, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <E> void append(List<E> list, Class<E> cls) throws Exception {
        E elem = cls.newInstance();   // OK
        list.add(elem);
    }
}
