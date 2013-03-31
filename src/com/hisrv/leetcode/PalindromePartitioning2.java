package com.hisrv.leetcode;

public class PalindromePartitioning2 {

	public int minCut(String s) {
        int n = s.length();
		char[] str = s.toCharArray();
		boolean[][] flags = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				flags[j][j + i] = (str[j] == str[j + i] && (i <= 1 || flags[j + 1][j
						+ i - 1])) ? true : false;
			}
		}
		int[] cut = new int[n];
		cut[0] = 0;
		for (int i = 1; i < n; i ++) {
			int min = cut[i - 1] + 1;
			for (int j = 0; j < i; j ++) {
				if (flags[j][i]) {
					min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
				}
			}
			cut[i] = min;
		}
		return cut[n - 1];
	}
}
