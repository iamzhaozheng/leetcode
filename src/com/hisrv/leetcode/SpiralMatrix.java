package com.hisrv.leetcode;

import java.util.ArrayList;

public class SpiralMatrix {
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> ret = new ArrayList<Integer>();
		int n = matrix.length;
		if (n == 0) {
			return ret;
		}
		int m = matrix[0].length;
		if (m == 0) {
			return ret;
		}
		int loop = 0;
		int dir = 0;
		int cnt = 0;
		int i = 0, j = 0;
		while (cnt < m * n) {
			ret.add(matrix[i][j]);
			switch (dir) {
			case 0:
				if (j + 1 < m - loop) {
					j += 1;
				} else {
					i += 1;
					dir = 1;
				}
				break;
			case 1:
				if (i + 1 < n - loop) {
					i += 1;
				} else {
					j -= 1;
					dir = 2;
				}
				break;
			case 2:
				if (j - 1 >= loop) {
					j -= 1;
				} else {
					i -= 1;
					dir = 3;
					loop++;
				}
				break;
			case 3:
				if (i - 1 >= loop) {
					i -= 1;
				} else {
					j += 1;
					dir = 0;
				}
				break;
			}
			cnt++;
		}
		return ret;
	}
}
