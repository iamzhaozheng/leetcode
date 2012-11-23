package com.hisrv.leetcode;

public class EditDistance {
	public int minDistance(String word1, String word2) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++) {
			for (int j = 0; j <= word2.length(); j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else {
					int min = dp[i][j - 1] + 1;
					if (min > dp[i - 1][j] + 1) {
						min = dp[i - 1][j] + 1;
					}
					int rep = dp[i - 1][j - 1]
							+ (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0
									: 1);
					if (min > rep) {
						min = rep;
					}
					dp[i][j] = min;
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}
}
