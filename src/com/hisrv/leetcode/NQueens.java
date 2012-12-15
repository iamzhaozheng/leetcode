package com.hisrv.leetcode;

import java.util.ArrayList;

public class NQueens {
	
	private ArrayList<String[]> mRet;
	private int mSize;
	private int mMask;
    
	public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        mRet = new ArrayList<String[]>();
        mSize = n;
        mMask = (1 << mSize) - 1;
        queen(0, 0, 0, 0, new int[n]);
        return mRet;
    }

	private void queen(int y, int left, int down, int right, int[] status) {
		if (y == mSize) {
			out(status);
		} else {
			int bitmap = mMask & ~(left | down | right);
			while (bitmap != 0) {
				int bit = -bitmap & bitmap;
				status[y] = bit;
				bitmap ^= bit;
				queen(y + 1, (left | bit) << 1, down | bit, (right | bit) >> 1, status);
			}
		}
	}

	private void out(int[] status) {
		int n = status.length;
		String[] strs = new String[n];
		for (int i = 0; i < n; i ++) {
			char[] s = new char[n];
			for (int j = 0; j < n; j ++) {
				s[j] = '.';
			}
			int p = log2(status[i]);
			s[p] = 'Q';
			strs[i] = new String(s);
		}
		mRet.add(strs);
	}
	
	private int log2(int a) {
		int r = 0;
		while (a > 1) {
			a = a / 2;
			r ++;
		}
		return r;
	}
}
