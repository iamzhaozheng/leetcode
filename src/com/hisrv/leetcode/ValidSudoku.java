package com.hisrv.leetcode;

import java.util.Arrays;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] row = new int[9];
		int[] col = new int[9];
		int[] cell = new int[9];
		Arrays.fill(row, 0);
		Arrays.fill(col, 0);
		Arrays.fill(cell, 0);
		for (int i = 0; i < 81; i++) {
			int x = i % 9;
			int y = i / 9;
			int c = y / 3 * 3 + x / 3;
			if (board[y][x] == '.') {
			} else if (board[y][x] < '1' || board[y][x] > '9') {
                return false; 		
			} else {
				int t = board[y][x] - '1';
				t = 1 << t;
                if ((row[y] & t) != 0 || (col[x] & t) != 0 || (cell[c] & t) != 0) {
                    return false;
                }
				row[y] |= t;
				col[x] |= t;
				cell[c] |= t;
			}
		}
        return true;
    }
}
