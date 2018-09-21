package com.leetcode.textjustify;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 11/5/14.
 * https://oj.leetcode.com/problems/text-justification/
 */
public class TextJustify {

    public static void main(String[] strings) {
//        String[] words = {
//                "abc",
//                "aaaaaa",
//                "pppppp",
//                "iiiiiii",
//                "123456",
//                "def",
//        };
//
//        String[] words = {
//                "",
//        };
//
//        String[] words = {
//                "Listen","to","many,","speak","to","a","few."
//        };
        String[] words = {
                "Here", "is", "an", "example", "of", "text", "justification."
        };

        TextJustify justify = new TextJustify();
        List<String> list = justify.fullJustify(words, 16);

        for (String word : list) {
            System.out.println("\"" + word + "\"" + "    : " + word.length());
        }
    }

    public List<String> fullJustify(String[] words, int L) {
        List<String> list = new ArrayList<String>();

        if (words == null || words.length == 0) {
            return list;
        }

        int currentLength = 0;
        int lastIndex = 0;
        char[] fillChars = new char[L];
        for (int x = 0; x < L; x++) {
            fillChars[x] = ' ';
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (currentLength + word.length() + (i == lastIndex ? 0 : 1) > L) {
                StringBuilder builder = new StringBuilder();
                int index = i - 1;
                if (index == lastIndex) {
                    builder.append(words[index]);
                    builder.append(fillChars, 0, L - words[index].length());
                    list.add(builder.toString());
                } else {
                    int space = L - currentLength;
                    int count = index - lastIndex;
                    int fill = space / count;
                    int more = space - (fill * count);

                    for (int m = lastIndex; m <= index; m++) {
                        if (m != lastIndex) {
                            int l = fill + 1 + ((m - lastIndex < more + 1) ? 1 : 0);
                            builder.append(fillChars, 0, l);
                        }
                        builder.append(words[m]);
                    }
                    list.add(builder.toString());
                }
                currentLength = 0;
                lastIndex = i;
                i--;
            } else {
                currentLength += words[i].length() + (i == lastIndex ? 0 : 1);
            }
        }

        if (lastIndex < words.length) {
            StringBuilder builder = new StringBuilder();

            for (int i = lastIndex; i < words.length; i++) {
                if (i != lastIndex) {
                    builder.append(' ');
                }
                builder.append(words[i]);
            }
            if (builder.length() < L) {
                builder.append(fillChars, 0, L - builder.length());
            }
            list.add(builder.toString());
        }

        return list;
    }
}
