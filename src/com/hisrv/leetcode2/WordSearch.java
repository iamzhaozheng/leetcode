package com.hisrv.leetcode2;

public class WordSearch {
    private char[][] mBoard;    
    private char[] mWord;
    private int mW, mH;
    private int[] mDir = {1, 0, -1, 0, 0, 1, 0, -1};
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        mBoard = board;
        mWord = word.toCharArray();
        mH = mBoard.length;
        if (mH <= 0) {
            return false;
        }
        mW = mBoard[0].length;
        for (int i = 0; i < mH; i ++) {
            for (int j = 0; j < mW; j ++) {
                if (exist(i, j, 0)) {
                    return true;
                }                
            }
        }
        return false;
    }
    
    private boolean exist(int y, int x, int p) {
        if (p >= mWord.length) {
            return true;
        }
        if (x < 0 || x >= mW || y < 0 || y >= mH) {
            return false;
        }
        if (mBoard[y][x] == mWord[p]) {
            char c = mBoard[y][x];
            mBoard[y][x] = 0;
            for (int i = 0; i < 4; i ++) {
                if (exist(y + mDir[i * 2], x + mDir[i * 2 + 1], p + 1)) {
                    return true;
                }
            }
            mBoard[y][x] = c;
        }
        return false;
    }
}
