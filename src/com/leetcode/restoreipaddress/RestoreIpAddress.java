package com.leetcode.restoreipaddress;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIpAddress {

    public static void main(String[] strings) {
        //String s = "25525511135";
        String s = "0000";

        RestoreIpAddress restoreIpAddress = new RestoreIpAddress();
        List<String> list = restoreIpAddress.restoreIpAddresses(s);

        for (String ip : list) {
            System.out.println(ip);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();

        if (s == null || s.length() < 4) {
            return list;
        }

        List<String> current = new ArrayList<String>();
        findIp(s.toCharArray(), 0, list, current);

        return list;
    }

    private boolean findIp(char[] chars, int index, List<String> list, List<String> current) {

        if (index >= chars.length || chars.length - index > (4 - current.size()) * 3) {
            return false;
        }

        if (current.size() < 3) {

            StringBuilder stringBuilder = new StringBuilder();

            //try 1 bit
            if (checkIpFormat(chars, index, index + 1) >= 0) {
                stringBuilder.append(chars[index]);
                current.add(stringBuilder.toString());
                findIp(chars, index + 1, list, current);
                current.remove(current.size() - 1);
            }

            //try 2 bit
            if (checkIpFormat(chars, index, index + 2) >= 0) {
                stringBuilder.append(chars[index + 1]);
                current.add(stringBuilder.toString());
                findIp(chars, index + 2, list, current);
                current.remove(current.size() - 1);
            }

            //try 3 bit
            if (checkIpFormat(chars, index, index + 3) >= 0) {
                stringBuilder.append(chars[index + 2]);
                current.add(stringBuilder.toString());
                findIp(chars, index + 3, list, current);
                current.remove(current.size() - 1);
            }

        } else {
            int v = checkIpFormat(chars, index, chars.length);
            if (v >= 0) {
                current.add(v + "");
                addToList(list, current);
                current.remove(current.size() - 1);
                return true;
            }
        }

        return false;
    }

    private void addToList(List<String> list, List<String> current) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < current.size(); i++) {
            String s = current.get(i);
            stringBuilder.append(s);
            if (i != current.size() - 1) {
                stringBuilder.append(".");
            }
        }
        list.add(stringBuilder.toString());
    }

    private int checkIpFormat(char[] chars, int start, int end) {
        if (end - start > 3 || end > chars.length) {
            return -1;
        }

        if (chars[start] == '0') {
            if (end == start + 1) {
                return 0;
            } else {
                return -1;
            }
        }

        int count = 0;
        int v = 0;
        for (int i = end - 1; i >= start; i--) {
            v += (chars[i] - '0') * (int) Math.pow(10, count);
            count++;
        }

        if (v > 255 || v < 0) {
            return -1;
        } else {
            return v;
        }
    }
}
