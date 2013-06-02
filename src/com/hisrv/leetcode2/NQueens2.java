package com.hisrv.leetcode2;

public class NQueens2 {
    private int mN;
    private int mSum;
    private int mMask;

    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        mSum = 0;
        mN = n;
        mMask = (1 << n) - 1;
        rec(0, 0, 0, 0);
        return mSum;
    }
    
    private void rec(int level, int left, int down, int right) {
        if (level == mN) {
            mSum ++;
            return;
        }
        int bitmap = ~(left | down | right) & mMask;
        while (bitmap != 0) {
            int now = -bitmap & bitmap;
            rec(level + 1, (left | now) << 1, down | now, (right | now) >> 1);
            bitmap ^= now;
        }
    }
}
