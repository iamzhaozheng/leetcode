package com.hisrv.leetcode;

import java.util.Stack;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = board.length;
		if (n == 0) {
			return false;
		}
		int m = board[0].length;
		char[] w = word.toCharArray();
		for (int i = 0; i < n * m; i++) {
			int x = i % m;
			int y = i / m;
			if (board[y][x] == w[0] && search(board, w, i)) {
				return true;
			}
		}
		return false;
	}

	private boolean search(char[][] board, char[] w, int p) {
		Stack<Step> stack = new Stack<Step>();
		int n = board.length;
		int m = board[0].length;
		int x = p % m;
		int y = p / m;
		int dir = 0;
		while (stack.size() < w.length) {
			if (board[x][y] == w[stack.size()]) {
				stack.push(new Step(x + y * m, dir));
			} else if (stack.size() == 0){
				return false;
			} else {
				
			}
		}
		return true;
	}
	
	private class Step {
		public int pos;
		public int dir;
		public Step(int pos, int dir) {
			this.pos = pos;
			this.dir = dir;
		}
	}
}
