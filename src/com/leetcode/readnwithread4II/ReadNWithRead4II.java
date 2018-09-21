package com.leetcode.readnwithread4II;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 12/9/14.
 * https://oj.leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
 */
public class ReadNWithRead4II {

    private List<Character> left;

    public int read(char[] buf, int n) {
        if (left == null) left = new ArrayList<Character>();
        int ptr = Math.min(n, left.size());
        for (int i = 0; i < ptr; i++) buf[i] = left.get(i);
        left.subList(0, ptr).clear();
        if (n < left.size()) return n;
        else {
            while (ptr < n) {
                char[] b4 = new char[4];
                int r = read4(b4);
                if (r == 0) return ptr;
                int min2 = Math.min(r, n - ptr);
                for (int i = 0; i < min2; i++) buf[ptr++] = b4[i];
                if (min2 < r) for (int i = min2; i < r; i++) left.add(b4[i]);
            }
            return ptr;
        }
    }

    int read4(char[] buff) {
        return 4;
    }

}
