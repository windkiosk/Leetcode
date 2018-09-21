package com.java.language.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by titan-developer on 12/12/14.
 */
public class PersonTest {

    public static void main(String[] args) {
        String filename = "time.ser";
        Person p = new Person("Lars", "Vogel");

        // save the object to file
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(p);

            out.close();
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // read the object from file
        // save the object to file
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            p = (Person) in.readObject();
            in.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(p);
    }
}
