package com.practise1;

/**
 * Created by titan-developer on 12/19/14.
 */
public class Atoi {

    public static void main(String[] strings) {
        Atoi solution = new Atoi();
        System.out.println(solution.atoi("1"));
    }

    public int atoi(String str) {
        int ret = 0;
        int i = 0, left = -1, right = -1;
        int len = str.length();
        boolean isLookingSign = true;
        boolean isNegative = false;
        while(i < len) {
            char c = str.charAt(i);
            if (isLookingSign) {
                if (c == '+' || c == '-') {
                    isLookingSign = false;
                    i ++;
                    isNegative = c == '-';
                } else if (isNum(c)) {
                    isLookingSign = false;
                    isNegative = false;
                    left = i;
                    right = i;
                } else if (c == ' ') {
                    i ++;
                } else {
                    return 0;
                }
            } else {
                if (isNum(c)) {
                    if (left < 0) left = i;
                    right = i;
                    i ++;
                } else {
                    break;
                }
            }
        }

        i = right;
        while(i >= 0 && i >= left) {
            int v = str.charAt(i) - '0';
            int tmp = (int)Math.pow(10, (right - i));
            if (tmp < 0) return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            if (isNegative) tmp = -tmp;
            ret += v * tmp;
            if (isNegative && ret > 0) return Integer.MIN_VALUE;
            if (!isNegative && ret < 0) return Integer.MAX_VALUE;
            i --;
        }
        return ret;
    }

    boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
