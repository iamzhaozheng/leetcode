package com.hisrv.leetcode;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = s1.length();
        if (n == 0) {
            return true;
        }
        boolean[][][] dp = new boolean[n][n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n - i; j ++) {
                for (int k = 0; k < n - i; k ++) {
                    if (i == 0) {
                        dp[i][j][k] = s1.substring(j, j + i + 1).equals(
                                s2.substring(k, k + i + 1)) ? true : false;
                    } else {
                        boolean temp = false;
                        for (int t = 0; t < i && !temp; t ++) {
                            temp = dp[t][j][k] && dp[i - t - 1][j + t + 1][k + t + 1] 
                                    || dp[t][j][k + i - t] && dp[i - t - 1][j + t + 1][k];
                        }
                        dp[i][j][k] = temp;
                    }
                }
            }
        }
        return dp[n - 1][0][0];
    }
}
