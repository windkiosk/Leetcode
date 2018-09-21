package com.java.language.util.generic;

import java.util.List;

/**
 * Created by bod on 1/5/2015.
 */
public class WildcardError {

    void foo(List<?> i) {
        //i.set(0, i.get(0)); //compile error
        fooHelper(i);
    }

    // Helper method created so that the wildcard can be captured
    // through type inference.
    private <T> void fooHelper(List<T> l) {
        l.set(0, l.get(0));
    }
}