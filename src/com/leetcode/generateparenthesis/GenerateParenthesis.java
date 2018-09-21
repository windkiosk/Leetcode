package com.leetcode.generateparenthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by bod on 10/23/14.
 * https://oj.leetcode.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    public static void main(String[] strings) {

        GenerateParenthesis parenthesisList = new GenerateParenthesis();
        List<String> list = parenthesisList.generateParenthesis(3);
        for (int i = 0 ; i < list.size() ; i ++) {
            System.out.println(i + " : " + list.get(i));
        }
    }

    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return null;
        }

        List<String> list = generateParenthesisStack(n);

        return list;
    }

    public List<String> generateParenthesisStack(int n) {
        ArrayList<String> list = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        Stack<Integer> validationStack = new Stack<Integer>();
        stack.push("(");
        validationStack.push(0);
        while(stack.size() != 0)
        {
            String s = stack.pop();
            int v = validationStack.pop();
            if(s.length() == n * 2)
            {
                list.add(s);
                continue;
            }
            if(s.length() - v < n)
            {
                stack.push(s + "(");
                validationStack.push(v);
            }
            if(2 * v < s.length())
            {
                stack.push(s + ")");
                validationStack.push(v+1);
            }
        }
        return list;
    }

    private List<String> recursiveGenerateParenthesis(int n) {
        List<String> arrayList = new ArrayList<String>();

        if (n == 0) {
            return arrayList;
        } else if (n == 1) {
            String one = "()";
            arrayList.add(one);
            return arrayList;
        } else {
            for (int i = 0 ; i < n ; i ++) {
                List<String> insideArray = recursiveGenerateParenthesis(i);
                List<String> outsideArray = recursiveGenerateParenthesis(n - i - 1);

                if (insideArray.size() == 0) {
                    for (int k = 0 ; k < outsideArray.size() ; k ++) {
                        String temp = "()" + outsideArray.get(k);
                        arrayList.add(temp);
                    }
                } else if (outsideArray.size() == 0) {
                    for (int m = 0 ; m < insideArray.size() ; m ++) {
                        String temp = "(" + insideArray.get(m) + ")";
                        arrayList.add(temp);
                    }
                } else {
                    for (int m = 0 ; m < insideArray.size() ; m ++) {
                        String temp = "(" + insideArray.get(m) + ")";
                        for (int k = 0 ; k < outsideArray.size() ; k ++) {
                            arrayList.add(temp + outsideArray.get(k));
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
