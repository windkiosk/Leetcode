package com.java.language.serialization;

import java.io.*;

/**
 * Try to ignore the latest state in Runtime and honor the instance from serialization.
 * Created by titan-developer on 12/12/14.
 */
public class TestSingleton2 implements Serializable {

    private static TestSingleton2 instance;
    static {
        System.out.println("Create Object");
        instance = new TestSingleton2();
        System.out.println("Create Object finish : " + instance);
    }
    private int i;

    public static TestSingleton2 getInstance() {
        return instance;
    }

    private TestSingleton2() {
        System.out.println("new instance : " + this);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        //need comment this line if want to use the instance in Runtime.
        instance = this;
    }

    public static void main(String[] args) throws Throwable {

        TestSingleton2 s = TestSingleton2.getInstance();
        s.i = 5;

        ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
        oos.writeObject(getInstance());
        oos.close();

        System.out.println(s == instance);
        s.i = 7; //modified after serialization

        InputStream is = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(is);
        TestSingleton2 deserialized = (TestSingleton2) ois.readObject();
        System.out.println(deserialized.i);  // prints 5
        System.out.println(deserialized == instance);
    }
}
