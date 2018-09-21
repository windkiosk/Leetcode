package com.java.language.util.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 1/2/15.
 */
public class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public List<T> getList() {
        return new ArrayList<T>();
    }

    public <E> List<E> getFirst(List<E> eList) {
        eList.remove(0);
        return eList;
    }

    public <U extends Integer> void set(U value) {

    }
}