package com.hisrv.leetcode;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (matrix == null) {
			return 0;
		}
		int n = matrix.length;
		if (n == 0) {
			return 0;
		}
		int m = matrix[0].length;
		if (m == 0) {
			return 0;
		}
		int max = 0;
		int[][] h = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == '0') {
					h[i][j] = 0;
					continue;
				}
				h[i][j] = j == 0 ? 1 : h[i][j - 1] + 1;
				int k = i;
				int width = h[i][j];
				while (k >= 0 && matrix[k][j] == '1') {
					width = Math.min(width, h[k][j]);
					max = Math.max(max, width * (i - k + 1));
					k--;
				}
			}
		}
		return max;
	}
}
