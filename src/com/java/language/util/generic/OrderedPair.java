package com.java.language.util.generic;

/**
 * Created by titan-developer on 1/2/15.
 */


public class OrderedPair<K, V> implements Pair<K, V> {

    public static void main(String[] strings) {
        //OrderedPair<Integer, Integer> pairs = new OrderedPair<Integer, Integer>("", 2);
        OrderedPair<Integer, Integer> pairs = new OrderedPair<Integer, Integer>(1, 2);
        OrderedPair<Integer, OrderedPair<Integer, Integer>> pairs2 =
                new OrderedPair<Integer, OrderedPair<Integer, Integer>>(1, new OrderedPair<Integer, Integer>(1, 1));
    }

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey()	{ return key; }
    public V getValue() { return value; }
}

interface Pair<K, V> {
    public K getKey();
    public V getValue();
}