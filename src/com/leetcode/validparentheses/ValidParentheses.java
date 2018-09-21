package com.leetcode.validparentheses;

import java.util.Stack;

/**
 * Created by titan-developer on 10/24/14.
 * https://oj.leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public static void main(String[] strings) {

        //String a = "()[[]{}";
        String a = "[])";

        ValidParentheses parentheses = new ValidParentheses();
        System.out.println(parentheses.isValid(a));
    }

    public boolean isValid(String s) {

        if (s == null || s.length() < 2) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0 ; i < s.length() ; i ++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
