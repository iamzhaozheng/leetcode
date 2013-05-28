package com.hisrv.leetcode2;

public class EditDIstance {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int n1 = s1.length;
        int n2 = s2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i ++) {
            for (int j = 0; j <= n2; j ++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = Math.max(i, j);
                } else {
                    dp[i][j] = s1[i - 1] == s2[j - 1] ? dp[i - 1][j - 1] : Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }
}
