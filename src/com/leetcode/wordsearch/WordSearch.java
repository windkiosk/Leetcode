package com.leetcode.wordsearch;

/**
 * Created by titan-developer on 11/7/14.
 * https://oj.leetcode.com/problems/word-search/
 */
public class WordSearch {

    public static void main(String[] strings) {
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'},
//        };

        char[][] board = {
                {'A'},
        };

        WordSearch wordSearch = new WordSearch();
        //System.out.println(wordSearch.exist(board, "ABCCED"));
        System.out.println(wordSearch.exist(board, "A"));
        //System.out.println(wordSearch.exist(board, "ADEE"));
    }

    public boolean exist(char[][] board, String word) {
        boolean isExist = false;
        if (board == null || board.length == 0 || word == null || word.length() == 0)
            return false;

        int m = board.length, n = board[0].length;

        char[] chars = word.toCharArray();

        for (int i = 0 ; i < m ; i ++) {
            for (int j = 0 ; j < n ; j ++) {
                if (board[i][j] == chars[0]) {
                    isExist = dfs(board, i, j, chars, 0);
                    if (isExist) {
                        return isExist;
                    }
                }
            }
        }

        return isExist;
    }

    private boolean dfs(char[][] board, int i, int j, char[] chars, int start) {
        boolean isExist = false;

        if (start == chars.length) {
            return true;
        }

        if (board[i][j] == chars[start]) {
            board[i][j] = '.';

            if (start + 1 == chars.length) {
                return true;
            }

            if (i > 0) {
                isExist = dfs(board, i - 1, j, chars, start + 1);
            }

            if (!isExist && i < board.length - 1) {
                isExist = dfs(board, i + 1, j, chars, start + 1);
            }

            if (!isExist && j > 0) {
                isExist = dfs(board, i, j - 1, chars, start + 1);
            }

            if (!isExist && j < board[0].length - 1) {
                isExist = dfs(board, i, j + 1, chars, start + 1);
            }

            if (!isExist) {
                board[i][j] = chars[start];
            }
        }

        return isExist;
    }

    public boolean existSimple(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        if (word.length() == 0) return true;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int i, int j, String target, int index) {
        if(index == target.length()) return true;
        char c = target.charAt(index);
        boolean isSucc = false;
        if (board[i][j] == c) {
            if (index + 1 == target.length()) return true;
            board[i][j] = ' ';
            if (i > 0)
                isSucc = dfs(board, i - 1, j, target, index + 1);
            if (!isSucc && j < board[0].length - 1)
                isSucc = dfs(board, i, j + 1, target, index + 1);
            if (!isSucc && i < board.length - 1)
                isSucc = dfs(board, i + 1, j, target, index + 1);
            if (!isSucc && j > 0)
                isSucc = dfs(board, i, j - 1, target, index + 1);
            board[i][j] = c;
        }

        return isSucc;
    }
}
