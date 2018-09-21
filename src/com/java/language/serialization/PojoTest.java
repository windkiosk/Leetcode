package com.java.language.serialization;

import java.io.*;

/**
 * Created by titan-developer on 12/12/14.
 */
public class PojoTest {
    public static void main(String[] args) throws Exception {
        Pojo pojo = new Pojo("Hello world");
        byte[] bytes = serialize(pojo); // Serialization
        Pojo p = (Pojo) deserialize(bytes); // De-serialization
        System.out.println(p.getMsg());
    }

    private static byte[] serialize(Object o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        oos.flush();
        oos.close();
        return baos.toByteArray();
    }

    private static Object deserialize(byte[] bytes) throws ClassNotFoundException, IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object o = ois.readObject();
        ois.close();
        return o;
    }
}
