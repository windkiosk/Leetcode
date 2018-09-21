package com.leetcode.findconcatenation;

import java.util.*;

/**
 * Created by titan-developer on 10/23/14.
 * https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class FindConcatenation {

    public static void main(String[] strings) {

        String s = "xbarcoobarfoocoothefoocoobarman";
        String[] words = {"foo", "coo", "bar"};
//
//        String s = "abaababbaba";
//        String[] words = {"ab","ba","ab","ba"};

//        String s = "sheateateseatea";
//        String[] words = {"sea","tea","ate"};

//        String s = "a";
//        String[] words = {"a"};

//        String s = "aaa";
//        String[] words = {"a", "a"};

        FindConcatenation concatenation = new FindConcatenation();
        System.out.println(concatenation.findSubstring(s, words));
    }


    public List<Integer> findSubstringMine(String S, String[] L) {
        List<Integer> ret = new ArrayList<Integer>();
        if (S == null || S.length() == 0) return ret;

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> curr = new HashMap<String, Integer>();
        int count = 0;

        for (String str : L) {
            int v = map.containsKey(str) ? map.get(str) : 0;
            map.put(str, v + 1);
        }
        int len = L[0].length();
        for (int i = 0; i < len; i ++) {
            for (int j = i; j < S.length(); j += len) {
                if (j + (L.length - count) * len > S.length()) break;
                String tmp = S.substring(j, j + len);
                if (map.containsKey(tmp) && (!curr.containsKey(tmp) || curr.get(tmp) < map.get(tmp))) {
                    int v = curr.containsKey(tmp) ? curr.get(tmp) : 0;
                    curr.put(tmp, v + 1);
                    count ++;
                    if (count == L.length) {
                        int index = j + len - L.length * len;
                        j = index;
                        ret.add(index);
                        count = 0;
                        curr.clear();
                    }
                } else {
                    j -= count * len;
                    count = 0;
                    curr.clear();
                }
            }
        }
        return ret;
    }


    List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        HashMap<String, Integer> cn = new HashMap<String, Integer>();
        HashMap<String, Integer> cntL = new HashMap<String, Integer>();

        int n = S.length();
        int e = L.length;
        int t = L[0].length();
        int k = 0;

        for (int i = 0; i < e; i++) {
            if (cn.containsKey(L[i])) {
                int v = cn.get(L[i]);
                cn.put(L[i], v + 1);
                k++;
            } else {
                cn.put(L[i], 1);
                k++;
            }
        }

        String tr, du;
        int r = 0;
        int start = 0;

        for (int j = 0; j < t; j++) {
            r = 0;
            start = j;
            for (int i = j; i + t <= n; i += t) {
                tr = S.substring(i, i + t);
                if (!cn.containsKey(tr)) {
                    cntL.clear();
                    r = 0;
                    start = i + t;
                } else if (!cntL.containsKey(tr) || cntL.get(tr) < cn.get(tr)) {
                    int v = cntL.containsKey(tr) ? cntL.get(tr) : 0;
                    cntL.put(tr, v + 1);
                    r++;
                } else {
                    du = S.substring(start, start + t);
                    while (!du.equals(tr)) {
                        cntL.put(du, cntL.get(du) - 1);
                        r--;
                        start += t;
                        du = S.substring(start, start + t);
                    }
                    start += t;
                }
                if (r == k) {
                    res.add(start);
                    du = S.substring(start, start + t);
                    cntL.put(du, cntL.get(du) - 1);
                    r--;
                    start += t;
                }

            }
            cntL.clear();
        }
        return res;
    }

    //------------------------------------------------------------

    public List<Integer> findSubstring2(String S, String[] L) {
        final List<Integer> result = new ArrayList<Integer>();
        if (L.length > 0 && L[0].length() > 0 && S.length() >= L.length * L[0].length()) {
            final Map<String, Integer> dict = new HashMap<String, Integer>();

            for (final String str : L) {
                dict.put(str, (dict.containsKey(str) ? dict.get(str) : 0) + 1);
            }

            final int len = L[0].length();
            // We only start from 0 ~ len - 1.
            for (int i = 0; i < len; ++i) {
                // This map is used to store the remained word count in the directory.
                Map<String, Integer> map = new HashMap<String, Integer>(dict);
                // Use queue to store current sequence. All the words in queue also should be in map.
                final Queue<String> queue = new LinkedList<String>();
                // Every time add one word.
                for (int j = i; (j + len) <= S.length(); j += len) {
                    final String str = S.substring(j, j + len);
                    // If this word is in directory.
                    if (dict.containsKey(str)) {
                        // Add the word into the sequence.
                        queue.add(str);
                        // We already have enough such word in the sequence so we need to move the starting point to next such word.
                        if (map.get(str) == 0) {
                            while (!str.equals(queue.element())) {
                                final String item = queue.remove();
                                map.put(item, map.get(item) + 1);
                            }

                            queue.remove();
                        } else {
                            map.put(str, map.get(str) - 1);
                        }

                        // There are enough words in the sequence.
                        if (queue.size() == L.length) {
                            result.add(j - len * (L.length - 1));
                        }
                    } else {
                        queue.clear();
                        map = new HashMap<String, Integer>(dict);
                    }
                }
            }
        }
        return result;
    }

    //------------------------------------------------------------

    public List<Integer> findSubstring3(String s, String[] words) {
        List<Integer> results = new ArrayList<Integer>();

        if (s == null || words == null || s.length() == 0 || words.length == 0) {
            return results;
        }

        int wordsListSize = words.length;
        int wordLength = words[0].length();

        if (s.length() < wordLength) {
            return results;
        }

        HashMap<String, CountNode> hashMap = new HashMap<String, CountNode>();
        for (String word : words) {
            if (hashMap.containsKey(word)) {
                CountNode node = hashMap.get(word);
                node.target++;
            } else {
                CountNode node = new CountNode();
                hashMap.put(word, node);
            }
        }

        int lastIndex = -1;
        int matchCount = 0;
        for (int i = wordLength; i <= s.length(); i++) {
            String tmp = s.substring(i - wordLength, i);
            if (hashMap.containsKey(tmp)) {
                CountNode node = hashMap.get(tmp);
                node.count++;

                if (node.count > node.target) {
                    resetCount(hashMap);
                    i = lastIndex + wordLength;
                    lastIndex = -1;
                    matchCount = 0;
                    continue;
                } else {
                    if (lastIndex < 0) {
                        lastIndex = i - wordLength;
                    }
                    if (node.count == node.target) {
                        matchCount += node.count;
                        if (matchCount == wordsListSize) {
                            results.add(lastIndex);
                            i = lastIndex + wordLength;
                            lastIndex = -1;
                            resetCount(hashMap);
                            matchCount = 0;
                            continue;
                        }
                    }

                    i = i + wordLength - 1;
                }
            } else {
                if (lastIndex >= 0) {
                    resetCount(hashMap);
                    i = lastIndex + wordLength;
                    lastIndex = -1;
                    matchCount = 0;
                }
            }
        }

        return results;
    }

    protected void resetCount(HashMap<String, CountNode> hashMap) {
        Iterator<CountNode> iterator = hashMap.values().iterator();
        while (iterator.hasNext()) {
            CountNode node = iterator.next();
            node.count = 0;
        }
    }

    class CountNode {
        int target;
        int count;

        public CountNode() {
            target = 1;
            count = 0;
        }
    }
}
