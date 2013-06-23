package com.hisrv.leetcode2;

import java.util.ArrayList;
import java.util.Arrays;

public class SudokuSolver {
    private ArrayList<Integer> mEmptyPos;
    private char[][] mBoard;
    private int mMask = (1 << 9) - 1;
    
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        mBoard = board;
        mEmptyPos = new ArrayList<Integer> ();
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
                mEmptyPos.add(i);
            } else {
                int bit = 1 << (board[r][c] - '1');
                row[r] |= bit;
                col[c] |= bit;
                cell[ce] |= bit;
            }
        }
        solve(0, row, col, cell);
    }
    
    private boolean solve(int posIdx, int[] row, int[] col, int[] cell) {
        if (posIdx >= mEmptyPos.size()) {
            return true;
        }
        int r = mEmptyPos.get(posIdx) / 9;
        int c = mEmptyPos.get(posIdx) % 9;
        int ce = r / 3 * 3 + c / 3;
        int bitmap = ~(row[r] | col[c] | cell[ce]) & mMask;
        while (bitmap != 0) {
            int bit = bitmap & (-bitmap);
            bitmap ^= bit;
            row[r] |= bit;
            col[c] |= bit;
            cell[ce] |= bit;
            mBoard[r][c] = getNum(bit);
            if (solve(posIdx + 1, row, col, cell)) {
                return true;
            }
            row[r] &= ~bit;
            col[c] &= ~bit;
            cell[ce] &= ~bit;
        }
        return false;
    }
    
    private char getNum(int bit) {
        int r = 0;
        while (bit != 0) {
            bit = bit >> 1;
            r ++;
        }
        return (char)(r + '0');
    }
}
