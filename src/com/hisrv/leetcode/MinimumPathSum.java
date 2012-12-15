package com.hisrv.leetcode;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int n = grid.length;
    	if (n == 0) {
    		return 0;
    	}
    	int m = grid[0].length;
    	if (m == 0) {
    		return 0;
    	}
    	int[][] dp = new int[n][m];
    	for (int i = 0; i < n; i ++) {
    		for (int j = 0; j < m; j ++) {
    			if (i == 0 && j == 0) {
    				dp[i][j] = grid[i][j];
    			} else if (i == 0) {
    				dp[i][j] = dp[i][j - 1] + grid[i][j];
    			} else if (j == 0) {
    				dp[i][j] = dp[i - 1][j] + grid[i][j];
    			} else {
    				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
    			}
    		}
    	}
    	return dp[n - 1][m - 1];
    }
}
