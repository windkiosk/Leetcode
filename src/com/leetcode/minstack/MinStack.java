package com.leetcode.minstack;

import com.leetcode.util.ListNode;

import java.util.ArrayList;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/min-stack/
 */
public class MinStack {
    ListNode minNode = new ListNode(Integer.MAX_VALUE);

    ArrayList<ListNode> list = new ArrayList<ListNode>();

    public static void main(String[] strings) {
        MinStack minStack = new MinStack();

        minStack.push(10);
        minStack.push(7);
        minStack.push(9);
        minStack.push(5);
        minStack.push(1);
        minStack.push(2);
        minStack.push(3);

        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    public void push(int x) {
        ListNode newNode = new ListNode(x);
        if (x < minNode.val) {
            newNode.next = minNode;
            minNode = newNode;
        }
        list.add(newNode);
    }

    public void pop() {
        if (list.size() > 0) {
            ListNode node = list.remove(list.size() - 1);

            if (node == minNode) {
                minNode = minNode.next;
            }
        }
    }

    public int top() {
        if (list.size() > 0) {
            ListNode node = list.get(list.size() - 1);
            return node.val;
        }

        return -1;
    }

    public int getMin() {
        return minNode.val;
    }
}
