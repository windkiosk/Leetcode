package com.interviewproblems.strstr;

/**
 * Created by titan-developer on 10/24/14.
 */
public class StrStr {

    public static void main(String[] strings) {
        StrStr strStr = new StrStr();

        String a = "this simp a ssimple game";
        System.out.println(strStr.strStr(a, "this"));
    }

    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null
                || needle.length() > haystack.length()) {
            return null;
        }

        if (haystack.length() == 0 && needle.length() == 0) {
            return "";
        }

        if (needle.length() == 0) {
            return haystack;
        }

        int currentMatch = 0;
        for (int i = 0 ; i < haystack.length() ; i ++) {
            char a = haystack.charAt(i);
            char b = needle.charAt(currentMatch);

            if (a == b) {
                currentMatch ++;
                if (currentMatch == needle.length()) {
                    return haystack.substring(i - currentMatch + 1);
                }
            } else if (currentMatch > 0) {
                i = i - currentMatch;
                currentMatch = 0;
            }
        }

        return null;
    }

    public String strStrKMP(String haystack, String needle) {
        //KMP algorithms
        if(needle.equals("")) return haystack;
        if(haystack.equals("")) return null;
        char[] arr = needle.toCharArray();
        int[] next = makeNext(arr);

        for(int i = 0, j = 0, end = haystack.length(); i < end;){
            if(j == -1 || haystack.charAt(i) == arr[j]){
                j++;
                i++;
                if(j == arr.length) return haystack.substring(i - arr.length);
            }
            if(i < end && haystack.charAt(i) != arr[j]) j = next[j];
        }
        return null;
    }

    private int[] makeNext(char[] arr){
        int len = arr.length;
        int[] next = new int[len];

        next[0] = -1;
        for(int i = 0, j = -1; i + 1 < len;){
            if(j == -1 || arr[i] == arr[j]){
                next[i+1] = j+1;
                if(arr[i+1] == arr[j+1]) next[i+1] = next[j+1];
                i++;
                j++;
            }
            if(arr[i] != arr[j]) j = next[j];
        }

        return next;
    }
}
