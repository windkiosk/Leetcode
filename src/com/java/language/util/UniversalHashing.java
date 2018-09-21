package com.java.language.util;

/**
 * Created by titan-developer on 12/1/14.
 */

import java.util.Arrays;
import java.util.Random;

/**
 * A universal hash function family.
 */
public class UniversalHashing {
    /**
     * Prime smaller than Integer.MAX_VALUE. (Normally must be chosen so that is greater than largest table size.)
     */
    private static final int p = 1999999973;

    private final int[] a;
    private final int[] b;

    UniversalHashing(int[] a, int[] b) {
        this.a = a;
        this.b = b;
    }

    public void multihash(Object o, int[] output, int tableSize) {
        int h = o.hashCode();
        for (int i = 0; i < output.length; i++) {
            output[i] = (a[i] * h + b[i]) % p % tableSize;
        }
    }

    @Override
    public String toString() {
        return "UniversalHashing[a=" + Arrays.toString(a) + ", b=" + Arrays.toString(b) + "]";
    }

    /**
     * Creates a UniversalHashing with the specified components. Integers in array {@code a}
     * cannot be zero, while numbers in {@code b} can be arbitrary (both are be chosen randomly).
     * The length of the two arrays must be equal, and it defines the maximum hashes that the resulting
     * UniversalHashing instance can generate per object.
     */
    public static UniversalHashing create(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new RuntimeException("need equal");
        }
        for (int x : a) {
            if(x == 0) {
                throw new RuntimeException("cannot zero");
            }
        }
        return new UniversalHashing(a, b);
    }

    /**
     * Creates a UniversalHashing that can serve up to {@code k} hashes per object, using the
     * specified {@code Random} instance to randomly select internal components.
     * @param k the maximum number of hashes that the returned UniversalHashing must be able to serve
     * @param random the random number generator to use for the creation of the UniversalHashing object
     * @return a UniversalHashing object
     */
    public static UniversalHashing create(int k, Random random) {
        int[] a = new int[k];
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            while ((a[i] = random.nextInt()) == 0)
                continue;
            b[i] = random.nextInt();
        }
        return new UniversalHashing(a, b);
    }
}
