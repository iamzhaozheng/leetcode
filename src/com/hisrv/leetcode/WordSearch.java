package com.hisrv.leetcode;


public class WordSearch {
	
	private char[][] mBoard;
	private char[] mWord;
	private boolean[][] mFlags;
	private int mRow, mCol;
	private static final int[] DIR = {0, 1, 0, -1, 1, 0, -1, 0};
	
	public boolean exist(char[][] board, String word) {
		// Start typing your Java solution below
		// DO NOT write main() function
		mRow = board.length;
		if (mRow == 0) {
			return false;
		}
		mCol = board[0].length;
		mBoard = board;
		mWord = word.toCharArray();
		mFlags = new boolean[mRow][mCol];
		for (int i = 0; i < mRow; i ++) {
			for (int j = 0; j < mCol; j ++) {
				if (search(j, i, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean search(int x, int y, int t) {
		if (t == mWord.length) {
			return true;
		}
		if (x < 0 || y < 0 || x >= mCol || y >= mRow || mWord[t] != mBoard[y][x] || mFlags[y][x]) {
			return false;
		}
		mFlags[y][x] = true;
		for (int i = 0; i < 4; i ++) {
			if (search(x + DIR[i * 2], y + DIR[i * 2 + 1], t + 1)) {
				return true;
			}
		}
		mFlags[y][x] = false;
		return false;
	}
}
