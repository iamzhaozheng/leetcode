package com.hisrv.leetcode;
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int l1 = s1.length() + 1;
		int l2 = s2.length() + 1;
		if (s3.length() != s1.length() + s2.length()) {
			return false;
		}
		boolean dp[][] = new boolean[l1][l2];
		for (int i = 0; i < l1; i++) {
			for (int j = 0; j < l2; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					dp[i][j] = dp[i][j - 1]
							&& s2.charAt(j - 1) == s3.charAt(j - 1);
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j]
							&& s1.charAt(i - 1) == s3.charAt(i - 1);
				} else {
					dp[i][j] = dp[i - 1][j]
							&& s1.charAt(i - 1) == s3.charAt(i + j - 1)
							|| dp[i][j - 1]
							&& s2.charAt(j - 1) == s3.charAt(i + j - 1);
				}

			}
		}
		return dp[l1 - 1][l2 - 1];
	}
}
