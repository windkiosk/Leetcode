package com.java.language.util.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by titan-developer on 1/3/15.
 */
public class GenericSubclass<T> extends Parent<T>  {

    GenericSubclass() {
        Class c = getClass();
        Type type = c.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType)type;
        Type realType = parameterizedType.getActualTypeArguments()[0];
        System.out.println(realType);
    }

    public static void main(String[] strings) {
        GenericSubclass<Integer> integerGenericSubclass = new GenericSubclass<Integer>();

    }

}

class Parent<T> {

}