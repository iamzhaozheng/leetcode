package com.hisrv.leetcode;

public class SurroundedRegions {
	
	private char[][] mBoard;
	private int mW, mH;
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	mH = board.length;
    	mW = board[0].length;
    	mBoard = board;
    	for (int i = 0; i < mH; i ++) {
    		for (int j = 0; j < mW; j ++) {
    			if (board[i][j] == 'O') {
    				if (floodfill(i, j, 'T')) {
    					floodfill(i, j, 'X');
    				}
    			}
    		}
    	}
    	for (int i = 0; i < mH; i ++) {
    		for (int j = 0; j < mW; j ++) {
    			if (mBoard[i][j] == 'T') {
    				mBoard[i][j] = 'O';
    			}
    		}
    	}
    }
    
    private boolean floodfill(int i, int j, char c) {
    	if (i < 0 || i >= mH || j < 0 || j >= mW) {
    		return false;
    	}
    	if (mBoard[i][j] == 'X' || mBoard[i][j] == c) {
    		return true;
    	}
    	mBoard[i][j] = c;
    	if (!(floodfill(i - 1, j, c) || floodfill(i + 1, j, c) || floodfill(i, j - 1, c) || floodfill(i, j + 1, c))) {
    		return false;
    	}
    	return true;
    }
}
