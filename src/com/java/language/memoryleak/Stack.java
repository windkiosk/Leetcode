package com.java.language.memoryleak;

import java.util.EmptyStackException;

/**
 * Created by titan-developer on 12/12/14.
 */
public class Stack {
    private Object[] elements;
    private int size = 0;

    public Stack(int initSize) {
        elements = new Object[initSize];
    }

    public void push(Object o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            Object[] old = elements;
            elements = new Object[2 * elements.length + 1];
            System.arraycopy(old, 0, elements, 0, size);
        }
    }
}
