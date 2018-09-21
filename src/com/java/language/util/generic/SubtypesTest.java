package com.java.language.util.generic;

import com.leetcode.integertoroman.IntegerToRoman;

import java.util.List;

/**
 * Created by titan-developer on 1/2/15.
 */
public class SubtypesTest {
    public static void main(String[] strings) {

        //Object --> Integer
        Object someObject = new Object();
        Integer someInteger = new Integer(10);
        someObject = someInteger;   // OK

        NumberHolder holder = new NumberHolder();
        holder.setNumber(new Integer(10)); //all good
        holder.setNumber(new Double(10));  //all good


        Box<Number> box = new Box<Number>();
        box.set(new Integer(10));  //all good
        box.set(new Double(10));   //all good

        BoxTest boxTest = new BoxTest();
//        boxTest.setBox(new Box<Integer>());//compile error here;
//        boxTest.setBox(new Box<Double>());//compile error here;
        boxTest.setBoundBox(new Box<Integer>());// use wildcard here, no error.


        PayloadList<String, Integer> integerPayloadList = null;
        PayloadList<String, Double> doublePayloadList = null;
        PayloadList<String, Exception> exceptionPayloadList = null;
        boxTest.setList(integerPayloadList);        //all good
        boxTest.setList(doublePayloadList);         //all good
        boxTest.setList(exceptionPayloadList);      //all good
    }
}

class NumberHolder {
    Number number;
    public void setNumber(Number number) {
        this.number = number;
    }
}

class BoxTest {
    void setBox(Box<Number> box) {
        //...
    }

    void setList(List<String> list) {

    }

    void setBoundBox(Box<? extends Number> box) {

    }
}


interface PayloadList<E,P> extends List<E> {
    void setPayload(int index, P val);
}