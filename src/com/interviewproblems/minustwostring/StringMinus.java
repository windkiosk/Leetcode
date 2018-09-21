package com.interviewproblems.minustwostring;

/**
 * Created by bod on 12/10/2014.
 * All the input are valid non-negative integers as String.
 */
public class StringMinus {


    public static void main(String[] strings) {
        StringMinus stringMinus = new StringMinus();

        System.out.println(stringMinus.minus("1000", "1"));
        System.out.println(stringMinus.minus("1", "1000"));
        System.out.println(stringMinus.minus("999999999991", "1000"));
        System.out.println(stringMinus.minus("1000", "999999999991"));
        System.out.println(stringMinus.minus("100", "100"));

        System.out.println(stringMinus.compare("12345", "12345"));
        System.out.println(stringMinus.compare("12335", "12345"));
        System.out.println(stringMinus.compare("12385", "12375"));
        System.out.println(stringMinus.compare("12345", "123495"));
        System.out.println(stringMinus.compare("312345", "123495"));
    }

    public String minus(String a, String b) {
        boolean isNegative = false;
        int compareResult = compare(a, b);
        if (compareResult == 0) {
            return "0";
        } else if (compareResult < 0) {
            String tmp = b;
            b = a;
            a = tmp;
            isNegative = true;
        }

        int la = a.length(), lb = b.length();
        int carry = 0;
        int cursor = 1;
        StringBuilder builder = new StringBuilder();
        while (cursor <= la) {
            int va = a.charAt(la - cursor) - '0' + carry;
            int vb = cursor > lb ? 0 : b.charAt(lb - cursor) - '0';
            carry = 0;
            if (va < 0 || (va == 0 && vb > 0)) {
                va += 10;
                carry = -1;
            }
            builder.insert(0, Math.abs(va - vb));
            if (carry >= 0)
                carry = va >= vb ? 0 : -1;

            //no need to continue the loop if carry == 0 and reached the firstIndex of b
            if (cursor > lb && carry == 0) {
                builder.insert(0, a.substring(0, la - cursor));
                break;
            }

            cursor ++;
        }

        if (builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }

        if (isNegative) {
            builder.insert(0, '-');
        }

        return builder.toString();
    }

    int compare(String a, String b) {
        if (a.length() == b.length()) {
            int l = a.length();
            int i = 0;
            while (i < l && a.charAt(i) == b.charAt(i)) {
                i ++;
            }

            if (i == l) {
                return 0;
            } else {
                return a.charAt(i) > b.charAt(i) ? 1 : -1;
            }
        } else if (a.length() > b.length()) {
            return 1;
        } else {
            return -1;
        }
    }
}
