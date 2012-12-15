package com.hisrv.leetcode;

public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[][] dp = new int[S.length()][T.length()];
		for (int i = 0; i < S.length(); i++) {
			for (int j = 0; j < T.length(); j++) {
				if (i < j) {
					dp[i][j] = 0;
				} else if (j == 0 && i == 0) {
					if (T.charAt(0) == S.charAt(0)) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = 0;
					}
				} else if (j == 0) {
					if (T.charAt(j) == S.charAt(i)) {
						dp[i][j] = dp[i - 1][j] + 1;
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				} else if (S.charAt(i) == T.charAt(j)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		if (S.length() == 0 || T.length() == 0) {
			return 0;
		} else {
			return dp[S.length() - 1][T.length() - 1];
		}
	}
}
