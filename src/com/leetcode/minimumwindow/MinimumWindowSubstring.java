package com.leetcode.minimumwindow;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by titan-developer on 10/21/14.
 * https://oj.leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {

    public static void main(String[] strings) {
//        String s = "aa";
//        String t = "aa";

        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int needToFind[] = new int[256];
        int minWindowBegin = -1;
        int minWindowEnd = -1;

        for (int i = 0; i < tLen; i++)
            needToFind[t.charAt(i)]++;

        int hasFound[] = new int[256];
        int minWindowLen = Integer.MAX_VALUE;
        int count = 0;
        for (int begin = 0, end = 0; end < sLen; end++) {
            // skip characters not in T
            if (needToFind[s.charAt(end)] == 0) continue;
            hasFound[s.charAt(end)]++;
            if (hasFound[s.charAt(end)] <= needToFind[s.charAt(end)])
                count++;

            // if window constraint is satisfied
            if (count == tLen) {
                // advance begin index as far right as possible,
                // stop when advancing breaks window constraint.
                while (needToFind[s.charAt(begin)] == 0 ||
                        hasFound[s.charAt(begin)] > needToFind[s.charAt(begin)]) {
                    if (hasFound[s.charAt(begin)] > needToFind[s.charAt(begin)])
                        hasFound[s.charAt(begin)]--;
                    begin++;
                }

                // update minWindow if a minimum length is met
                int windowLen = end - begin + 1;
                if (windowLen < minWindowLen) {
                    minWindowBegin = begin;
                    minWindowEnd = end;
                    minWindowLen = windowLen;
                } // end if
            } // end if
        } // end for

        if (minWindowEnd >= 0 && minWindowBegin >= 0) {
            return s.substring(minWindowBegin, minWindowEnd + 1);
        }

        return "";
    }

    public String minWindowWithHash(String s, String t) {
        String subStr = "";
        if (s == null || t == null)
            return subStr;

        HashMap<Character, PointerList> hashMap = new HashMap<Character, PointerList>();
        LinkedList<Pointer> linkedList = new LinkedList<Pointer>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (hashMap.containsKey(c)) {
                hashMap.get(c).count++;
            } else {
                hashMap.put(t.charAt(i), new PointerList());
            }
        }

        int min = Integer.MAX_VALUE;
        int left = -1, right = -1;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            if (hashMap.containsKey(c)) {
                PointerList pointerlist = hashMap.get(c);
                if (pointerlist.list.size() < pointerlist.count) {
                    Pointer pointer = new Pointer();
                    pointer.character = c;
                    pointer.index = j;
                    pointerlist.list.add(pointer);
                    linkedList.add(pointer);
                } else {
                    Pointer pointer = pointerlist.list.peekFirst();
                    pointer.index = j;
                    linkedList.remove(pointer);
                    linkedList.add(pointer);
                    pointerlist.list.add(pointer);
                }

                if (linkedList.size() == t.length()) {
                    int l = linkedList.peekFirst().index;
                    int r = linkedList.peekLast().index;
                    if (r - l < min) {
                        min = r - l;
                        left = l;
                        right = r;
                    }
                }
            }
        }

        if (left >= 0 && right >= 0) {
            subStr = s.substring(left, right + 1);
        }

        return subStr;
    }

    class PointerList {
        LinkedList<Pointer> list = new LinkedList<Pointer>();
        int count;

        PointerList() {
            count = 1;
        }
    }

    class Pointer {
        Character character;
        int index;
    }
}
