package com.leetcode.repeateddna;

import java.util.*;

/**
 * Created by titan-developer on 2/9/15.
 * https://oj.leetcode.com/problems/repeated-dna-sequences/
 */
public class RepeatedDNASequence {

    public static void main(String[] strings) {
        RepeatedDNASequence dnaSequence = new RepeatedDNASequence();
        List<String> list = dnaSequence.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        for (String str : list) {
            System.out.println(str);
        }
    }



    //https://oj.leetcode.com/discuss/24595/short-java-rolling-hash-solution
    private static final Map<Character, Integer> A = new HashMap<Character, Integer>();
    static { A.put('A',0); A.put('C',1); A.put('G',2); A.put('T',3); }
    private final int A_SIZE_POW_9 = (int) Math.pow(A.size(), 9);

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<String>();
        Set<Integer> hashes = new HashSet<Integer>();
        for (int i = 0, rhash = 0; i < s.length(); i++) {
            if (i > 9) rhash -= A_SIZE_POW_9 * A.get(s.charAt(i-10));
            rhash = A.size() * rhash + A.get(s.charAt(i));
            if (i > 8 && !hashes.add(rhash)) res.add(s.substring(i-9,i+1));
        }
        return new ArrayList<String>(res);
    }


    //----------------------------------------------------------------------

    HashMap<Character, Integer> bitPatterns = new HashMap<Character, Integer>();
    HashMap<Integer, Integer> sequences = new HashMap<Integer, Integer>();
    String[] strPatterns;
    //pass in oj.
    public List<String> findRepeatedDnaSequencesBit(String s) {

        bitPatterns.put('A', 0); //pattern: 00
        bitPatterns.put('C', 1); //pattern: 01
        bitPatterns.put('G', 2); //pattern: 10
        bitPatterns.put('T', 3); //pattern: 11

        //Save the bitpatterns the other way arround such that we can rebuild the string later.
        strPatterns = new String[bitPatterns.size()];
        for(Character character : bitPatterns.keySet()){
            strPatterns[bitPatterns.get(character)] = String.valueOf(character);
        }


        //BitMask to hide everything larger than 20 bits
        int bitMask = ((1 << 20)-1) ^ 2; // This bitmask is a bitset where bits 3-19 are set to 1.
        int currentSequence = 0;

        //load first sequence
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            //shift the current sequence to the left and clear the right most two bits. This is done by &-ing the bitmask with the current sequence
            currentSequence = bitMask & (currentSequence << 2);
            currentSequence |= bitPatterns.get(c);//add the current character to the sequence
            if(i>=9){
                //Count or add the sequence
                if(sequences.get(currentSequence) != null){
                    Integer count = sequences.get(currentSequence)+1;
                    sequences.put(currentSequence,count);
                }else{
                    sequences.put(currentSequence, 1);
                }
            }
        }
        //Get the sequences that occur more than 1 time
        LinkedList<String> result = new LinkedList<String>();
        for(Integer k : sequences.keySet()){
            Integer v = sequences.get(k);
            if(v>1){
                result.add(convertToString(k));
            }
        }
        return result;
    }

    public String convertToString(int k){
        StringBuilder sb = new StringBuilder();
        int bitMask = 3;
        for(int i = 0; i<10;i++){
            sb.append(strPatterns[bitMask & k]); //Get the rightmost two bits and convert it to a letter
            k = k >>> 2;
        }
        sb.reverse();
        return sb.toString();
    }

    /**
     * fails, memory exceed in oj
     */
    public List<String> findRepeatedDnaSequencesPrefixTree(String s) {
        List<String> ret = new ArrayList<String>();
        if (s == null || s.length() == 0) return ret;
        PrefixTreeNode root = new PrefixTreeNode('-');
        for (int i = 0; i + 10 <= s.length(); i ++) {
            PrefixTreeNode curr = root;
            for (int j = 0; j < 10; j ++) {
                char c = s.charAt(i + j);
                if (curr.children.containsKey(c)) {
                    if (j == 9) {
                        ret.add(s.substring(i, i + 10));
                    }
                } else {
                    PrefixTreeNode newNode = new PrefixTreeNode(c);
                    curr.children.put(c, newNode);
                }

                curr = curr.children.get(c);
            }
        }
        return ret;
    }

    /**
     * fails, memory exceed in oj
     */
    public List<String> findRepeatedDnaSequencesWithHashMap(String s) {
        List<String> ret = new ArrayList<String>();
        if (s == null || s.length() <= 10) return ret;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i + 10 <= s.length(); i ++) {
            String subStr = s.substring(i, i + 10);
            int key = subStr.hashCode();
            int count = 0;
            if (map.containsKey(key)) {
                count = map.get(key);
                if (count == 1) ret.add(subStr);
            }
            map.put(key, count + 1);
        }

        return ret;
    }
}

class PrefixTreeNode {
    char val;
    HashMap<Character, PrefixTreeNode> children;

    public PrefixTreeNode(char val) {
        this.val = val;
        children = new HashMap<Character, PrefixTreeNode>();
    }
}
