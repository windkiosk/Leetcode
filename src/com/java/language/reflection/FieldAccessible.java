package com.java.language.reflection;

import java.lang.reflect.Field;

/**
 * https://stackoverflow.com/questions/10638826/java-reflection-impact-of-setaccessibletrue
 * Created by titan-developer on 2/21/15.
 */
public class FieldAccessible {
    public static class MyClass {
        private String theField;
    }

    public static void main(String[] args) throws Exception {
        MyClass myClass = new MyClass();
        Field field1 = myClass.getClass().getDeclaredField("theField");
        field1.setAccessible(true);
        System.out.println(field1.get(myClass));
        Field field2 = myClass.getClass().getDeclaredField("theField");
        System.out.println(field2.get(myClass));
    }

}
