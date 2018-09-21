package com.leetcode.LRU;

import java.util.HashMap;

/**
 *
 * https://oj.leetcode.com/problems/lru-cache/
 *
 * Created by bod on 8/14/14.
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * <p/>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
public class LRUCache {

    HashMap<Integer, DualNode> indexer;
    int capacity;
    int size;
    DualNode mockHead;
    DualNode mockTail;

    public static void main(String[] strings) {
        LRUCache cache = new LRUCache(5);

        cache.set(1, 15);
        cache.set(2, 25);
        cache.set(3, 35);
        cache.set(4, 45);
        cache.set(1, 15);
        cache.get(2);
        cache.set(5, 55);
        cache.set(6, 65);
        cache.set(7, 75);

        System.out.println("get 1 : " + cache.get(1));
        System.out.println("get 2 : " + cache.get(2));
        System.out.println("get 3 : " + cache.get(3));
        System.out.println("get 4 : " + cache.get(4));
        System.out.println("get 5 : " + cache.get(5));
        System.out.println("get 6 : " + cache.get(6));
        System.out.println("get 7 : " + cache.get(7));

        System.out.println("--------------------");

        cache = new LRUCache(2);

        cache.set(2, 1);
        cache.set(1, 1);
        System.out.println("get 2 : " + cache.get(2));
        cache.set(4, 1);
        System.out.println("get 1 : " + cache.get(1));
        System.out.println("get 2 : " + cache.get(2));
    }

    public LRUCache(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            indexer = new HashMap<Integer, DualNode>();
            mockHead = new DualNode(0, 0);
            mockHead.pre = null;

            mockTail = new DualNode(0, 0);
            mockTail.pre = mockHead;
            mockHead.next = mockTail;
        }
    }

    public int get(int key) {
        if (indexer.containsKey(key)) {
            DualNode node = indexer.get(key);

            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.next = mockHead.next;
            mockHead.next.pre = node;
            mockHead.next = node;
            node.pre = mockHead;

            return node.val;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (indexer.containsKey(key)) {
            DualNode node = indexer.get(key);
            node.val = value;
            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.next = mockHead.next;
            mockHead.next.pre = node;
            mockHead.next = node;
            node.pre = mockHead;
        } else if (size == capacity) {
            //remove last one.
            DualNode last = mockTail.pre;
            indexer.remove(last.key);
            last.pre.next = mockTail;
            mockTail.pre = last.pre;

            last.pre = null;
            last.next = null;

            DualNode node = new DualNode(key, value);
            indexer.put(key, node);
            node.next = mockHead.next;
            mockHead.next.pre = node;
            mockHead.next = node;
            node.pre = mockHead;
        } else {
            DualNode node = new DualNode(key, value);
            node.next = mockHead.next;
            mockHead.next.pre = node;
            mockHead.next = node;
            node.pre = mockHead;
            indexer.put(key, node);
            size++;
        }
    }

    public static class DualNode {

        public int val, key;
        public DualNode pre, next;

        public DualNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
