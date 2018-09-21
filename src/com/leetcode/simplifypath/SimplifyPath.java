package com.leetcode.simplifypath;

import java.util.Stack;

/**
 * Created by titan-developer on 11/5/14.
 * https://oj.leetcode.com/problems/simplify-path/
 */
public class SimplifyPath {

    public static void main(String[] strings) {
        SimplifyPath simplifier = new SimplifyPath();
        System.out.println(simplifier.simplifyPath("/home/../../.."));
        System.out.println(simplifier.simplifyPath("/abc/..."));
        System.out.println(simplifier.simplifyPath("/..."));
        System.out.println(simplifier.simplifyPath("/."));
        System.out.println(simplifier.simplifyPath("//home//"));
        System.out.println(simplifier.simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifier.simplifyPath("/a/./b/../../c/"));
    }

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }

        Stack<String> stack = new Stack<String>();

        int left = -1, right = -1;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);

            if (c == '/') {
                if (left > 0) {
                    right = i - 1;

                    if (right == left && path.charAt(right) == '.') {
                        //do nothing;
                    } else if (right - left + 1 == 2 && path.charAt(right) == '.' && path.charAt(right - 1) == '.') {
                        if (!stack.empty()) {
                            stack.pop();
                        }
                    } else {
                        stack.push(path.substring(left, i));
                    }

                    left = -1;
                }
            } else {
                if (left < 0) {
                    left = i;
                }
            }
        }

        if (left > 0) {
            right = path.length() - 1;
            if (right == left && path.charAt(right) == '.') {
                //do nothing;
            } else if (right - left + 1 == 2 && path.charAt(right) == '.' && path.charAt(right - 1) == '.') {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(path.substring(left));
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.empty()) {
            builder.insert(0, stack.pop());
            builder.insert(0, '/');
        }

        return builder.toString();
    }
}
