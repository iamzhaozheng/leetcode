package com.hisrv.leetcode;

public class UniquePath2 {
    public int uniquePathsWithObstacles(int[][] dp) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = dp.length;
        int n = dp[0].length;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (dp[i][j] == 1) {
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[i][j] = -1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] >= 0 ? 0 : dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] >= 0 ? 0 : dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] >= 0 ? dp[i][j - 1] : dp[i][j - 1] >= 0 ? dp[i - 1][j] : dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return Math.max(-dp[m - 1][n - 1], 0);
    }
}
