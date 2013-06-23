package com.hisrv.leetcode2;

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
        for (int i = 0; i < 81; i ++) {
            int r = i / 9;
            int c = i % 9;
            int ce = r / 3 * 3 + c / 3;
            if (board[r][c] == '.') {
                continue;
            }
            if (board[r][c] > '9' || board[r][c] < '1') {
                return false;
            }
            int bit = 1 << (board[r][c] - '1');
            if ((row[r] & bit) != 0 || (col[c] & bit) != 0 
                    || (cell[ce] & bit) != 0) {
                return false;
            }
            row[r] |= bit;
            col[c] |= bit;
            cell[ce] |= bit;
        }
        return true;
    }
}
