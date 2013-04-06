package com.hisrv.leetcode2;

public class DistinctSubsequences {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int m = t.length;
        int n = s.length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i ++) {
            dp[0][i] = (i == 0 ? 0 : dp[0][i - 1]) + (t[0] == s[i] ? 1 : 0);
        }
        for (int i = 1; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                dp[i][j] = j < i ? 0 : ((t[i] == s[j] ? dp[i - 1][j - 1] : 0) + dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
