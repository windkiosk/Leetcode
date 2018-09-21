package com.leetcode.wordladder;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by titan-developer on 11/18/14.
 * https://oj.leetcode.com/problems/word-ladder/
 */
public class WordLadder {

    public static void main(String[] strings) {
        WordLadder wordLadder = new WordLadder();

        String start = "hit";
        String end = "cog";

        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("hot");
        hashSet.add("dot");
        hashSet.add("dog");
        hashSet.add("lot");
        hashSet.add("log");
        hashSet.add("cog");

        System.out.println(wordLadder.ladderLength(start, end, hashSet));
    }

    public int ladderLength(String start, String end, HashSet<String> dict) {

        if (dict.size() == 0)
            return 0;

        LinkedList<String> wordQueue = new LinkedList<String>();
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();

        wordQueue.add(start);
        distanceQueue.add(1);


        while (!wordQueue.isEmpty()) {
            String currWord = wordQueue.pop();
            Integer currDistance = distanceQueue.pop();

            if (currWord.equals(end)) {
                return currDistance;
            }

            for (int i = 0; i < currWord.length(); i++) {
                char[] currCharArr = currWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    currCharArr[i] = c;

                    String newWord = new String(currCharArr);
                    if (dict.contains(newWord)) {
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance + 1);
                        dict.remove(newWord);
                    }
                }
            }
        }

        return 0;
    }
}
