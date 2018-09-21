package com.leetcode.readnwithread4;

/**
 * Created by titan-developer on 12/9/14.
 * https://oj.leetcode.com/problems/read-n-characters-given-read4/
 */
public class ReadNWithRead4 {

    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int readBytes = 0;
        boolean eof = false;
        while (!eof && readBytes < n) {
            int sz = read4(buffer);
            if (sz < 4) eof = true;
            int bytes = Math.min(n - readBytes, sz);
            System.arraycopy(buffer, 0, buf, readBytes, bytes); // src, srcPos, dest, destPos, length
            readBytes += bytes;
        }
        return readBytes;
    }

    int read4(char[] buff) {
        return 4;
    }
}
