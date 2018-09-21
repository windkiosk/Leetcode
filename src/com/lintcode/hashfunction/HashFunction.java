package com.lintcode.hashfunction;

/**
 * Created by titan-developer on 12/16/14.
 * http://lintcode.com/en/problem/hash-function/
 */
public class HashFunction {

    public static void main(String[] strings) {
        HashFunction hashFunction = new HashFunction();
        System.out.println(hashFunction.hashCode("Introduction to Algorithms".toCharArray(), 10007));
    }

    public int hashCode(char[] key,int HASH_SIZE) {
        long hashCode = 0;

        long lastMode = 1;
        for (int i = key.length - 1; i >= 0; i --) {
            int ascii = (int)key[i];

            if (i != key.length - 1)
                lastMode *= 33;

            lastMode %= HASH_SIZE;

            long v = ascii * lastMode;
            v = v % HASH_SIZE;
            hashCode += v;
            hashCode = hashCode % HASH_SIZE;
        }

        return (int)hashCode;
    }
}
