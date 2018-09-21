package com.java.language.util.generic;

import java.util.List;

/**
 * Created by titan-developer on 1/2/15.
 */
public class BoundedBox<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Integer> void inspect(U u){
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public void test(List<? extends Number> number) {

    }

    public static void main(String[] args) {
        BoundedBox<Integer> integerBox = new BoundedBox<Integer>();
        integerBox.set(new Integer(10));
        //integerBox.inspect("some text"); //compile error: this is still String!
    }
}
