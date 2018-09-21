package com.java.language.serialization;

import java.io.*;

/**
 * Created by titan-developer on 12/12/14.
 */
public class UidTest implements Serializable {

    int value;

    UidTest(int v) {
        this.value = v;
    }

    static final long serialVersionUID = 12345L;

    public static void main(String[] args) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.ser"));
        oos.writeObject(new UidTest(5));
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.ser"));
        UidTest test = (UidTest) ois.readObject();
        ois.close();
        System.out.println(test.value);
    }
}
