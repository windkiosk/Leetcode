package com.java.language.util;

/**
 * Created by titan-developer on 12/23/14.
 */
public class TestClone {

    public static void main(String[] strings) {
        A testA = new A(3);
        B testB = new B(4);

        System.out.println("Is B clonable ? " + (testB instanceof Cloneable));

        try {
            Object newObj = testA.clone();

            A testA2 = (A)newObj;
            System.out.println(testA2.val);

            newObj = testB.clone();

            B testB2 = (B)newObj;
            System.out.println(testB2.i);
            System.out.println(testB2.val);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}

class A implements Cloneable{
    int val;
    A() {
        val = 1;
    }

    A(int v) {
        this.val = v;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        //Object obj = new A(); error impl
        System.out.println("clone method of A: " + obj);

        A a = (A)obj;
        //a.val = this.val; //don't need call this explicitly.

        return a;
    }
}

class B extends A {
    int i;

    B() {
        i = 2;
    }

    B(int i) {
        this.i = i;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        System.out.println("clone method of B: " + obj);

        B b = (B)obj;
        //b.i = this.i; //don't need call this explicitly.
        return b;
    }
}