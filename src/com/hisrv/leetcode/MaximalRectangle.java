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
		int[][] v = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == '0') {
					h[i][j] = 0;
					v[i][j] = 0;
					continue;
				}
				if (i == 0 && j == 0) {
					v[0][0] = h[0][0] = 1;
					max = 1;
				} else if (i == 0) {
					h[0][j] = h[0][j - 1] + 1;
					v[0][j] = 1;
					max = Math.max(h[0][j], max);
				} else if (j == 0) {
					v[i][0] = v[i - 1][0] + 1;
					h[i][0] = 1;
					max = Math.max(v[i][0], max);
				} else {
					if (h[i][j - 1] == 0) {
						h[i][j] = 1;
						v[i][j] = v[i - 1][j] + 1;
						max = Math.max(v[i][j], max);
					} else if (v[i - 1][j] == 0) {
						v[i][j] = 1;
						h[i][j] = h[i][j - 1] + 1;
						max = Math.max(h[i][j], max);
					} else {
						int sh, sv;
						sh = (h[i][j - 1] + 1)
								* Math.min(v[i][j - 1], v[i - 1][j] + 1);
						sv = Math.min(h[i - 1][j], h[i][j - 1] + 1)
								* (v[i - 1][j] + 1);
						if (sh > sv) {
							h[i][j] = h[i][j - 1] + 1;
							v[i][j] = Math.min(v[i][j - 1], v[i - 1][j] + 1);
							max = Math.max(sh, max);
						} else {
							h[i][j] = Math.min(h[i - 1][j], h[i][j - 1] + 1);
							v[i][j] = v[i - 1][j] + 1;
							max = Math.max(sv, max);
						}
					}
				}
			}
		}
		return max;
	}
}
