package com.leetcode.zigzag;

/**
 *
 * https://oj.leetcode.com/problems/zigzag-conversion/
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p/>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p/>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Zigzag {

    public String convert(String s, int nRows) {
        if (nRows <= 0 || s == null || s.length() <= 0)
            return "";

        if (nRows == 1)
            return s;

        String[] convertArray = new String[nRows];
        for (int i = 0; i < nRows; i++) {
            convertArray[i] = "";
        }

        int currentRow = 0;

        int length = s.length();

        int index = 0;

        boolean isPlus = true;

        while (index < length) {
            convertArray[currentRow] += s.substring(index, index + 1);

            if (currentRow == nRows - 1) {
                isPlus = false;
            } else if (currentRow == 0) {
                isPlus = true;
            }

            if (isPlus)
                currentRow++;
            else
                currentRow--;

            index++;
        }

        String output = "";
        for (int i = 0; i < nRows; i++) {
            output += convertArray[i];
        }

        return output;
    }
}
