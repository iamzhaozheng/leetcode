package com.hisrv.leetcode;

import java.util.Stack;

public class SurroundedRegions {
	
	private char[][] mBoard;
	private int mW, mH;
	private static final int[][] STEP = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	mH = board.length;
    	if (mH == 0) {
    		return;
    	}
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
    	boolean ret = true;
    	Stack<Integer> stack = new Stack<Integer> ();
    	stack.push(i * mW + j);
    	while (!stack.isEmpty()) {
    		int n = stack.pop();
    		i = n / mW;
    		j = n % mW;
        	if (mBoard[i][j] == 'X' || mBoard[i][j] == c) {
        		continue;
        	}
        	mBoard[i][j] = c;
        	for (int k = 0; k < STEP.length; k ++) {
        		int y = i + STEP[k][0];
        		int x = j + STEP[k][1];
            	if (y < 0 || y >= mH || x < 0 || x >= mW) {
            		ret = false;
            	} else {
            		stack.push(y * mW + x);
            	}
        	}
    	}
    	return ret;
    }
}
