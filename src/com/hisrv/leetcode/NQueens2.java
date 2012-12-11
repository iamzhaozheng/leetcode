package com.hisrv.leetcode;


public class NQueens2 {
	
	private int mSize;
	private int mMask;
	private int mRet;
    
	public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        mRet = 0;
        mSize = n;
        mMask = (1 << mSize) - 1;
        queen(0, 0, 0, 0);
        return mRet;
    }

	private void queen(int y, int left, int down, int right) {
		if (y == mSize) {
			mRet ++;
		} else {
			int bitmap = mMask & ~(left | down | right);
			while (bitmap != 0) {
				int bit = -bitmap & bitmap;
				bitmap ^= bit;
				queen(y + 1, (left | bit) << 1, down | bit, (right | bit) >> 1);
			}
		}
	}

}
