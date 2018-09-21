package com.java.language.serialization;

import java.io.*;

/**
 * Created by titan-developer on 12/12/14.
 */
public class Pojo implements Serializable, ObjectInputValidation {

    private String msg;

    public Pojo(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        System.out.println("writeObject");
        out.defaultWriteObject();
    }

    private Object writeReplace() throws ObjectStreamException {
        System.out.println("writeReplace");
        return this;
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        System.out.println("readObject");
        in.registerValidation(this, 0);
        in.defaultReadObject();
    }

    @Override
    public void validateObject() throws InvalidObjectException {
        System.out.println("validateObject");
    }

    private Object readResolve() throws ObjectStreamException {
        System.out.println("readResolve");
        return this;
    }
}
