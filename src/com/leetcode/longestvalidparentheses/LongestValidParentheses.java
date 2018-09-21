package com.leetcode.longestvalidparentheses;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by titan-developer on 10/23/14.
 * https://oj.leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    public static void main(String[] strings) {
        String s = ")()())";
        //String s = "(()";
        //String s = "()(()";

        LongestValidParentheses longestParentheses = new LongestValidParentheses();
        System.out.println(longestParentheses.longestValidParentheses(s));
    }

    int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxLen = 0;
        for (int i = 0; i < s.length(); ++i)
        {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (!stack.empty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    int lastPos = -1;
                    if (!stack.empty())
                        lastPos = stack.peek();
                    int curLen = i - lastPos;
                    maxLen = (maxLen < curLen) ? curLen : maxLen;
                } else
                    stack.push(i);
            }
        }
        return maxLen;
    }

    public int longestValidParentheses2Pass(String s) {
        int maxLength = 0;

        if (s == null || s.length() < 2) {
            return maxLength;
        }

        Stack<BracketInfo> stack = new Stack<BracketInfo>();

        char[] charsArray = s.toCharArray();

        for (int i = 0 ; i < charsArray.length ; i ++) {
            char c = charsArray[i];

            if (c == '(') {
                BracketInfo bracketInfo = new BracketInfo();
                bracketInfo.c = '(';
                bracketInfo.index = i;
                stack.push(bracketInfo);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    continue;
                } else if (stack.peek().c == '(') {
                    BracketInfo info = stack.pop();
                    charsArray[i] = 0;
                    charsArray[info.index] = 0;
                } else {
                    stack.clear();
                }
            }
        }

        int current = 0;
        for (int i = 0 ; i < charsArray.length ; i ++) {
            if (charsArray[i] == 0) {
                current ++;
                if (current > maxLength) {
                    maxLength = current;
                }
            } else {
                current = 0;
            }
        }

        return maxLength;
    }

    class BracketInfo {
        char c;
        int index;
    }

}
