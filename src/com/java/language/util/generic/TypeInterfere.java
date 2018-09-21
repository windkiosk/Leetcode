package com.java.language.util.generic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by titan-developer on 1/2/15.
 */
public class TypeInterfere {
    static <T> T pick(T a1, T a2) {
        return a2;
    }

    public static void main(String[] strings) {
        Serializable s = pick("d", new ArrayList<String>());
        Serializable s1 = pick("d", 1);
    }

}
