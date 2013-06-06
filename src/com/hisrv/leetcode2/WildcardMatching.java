package com.hisrv.leetcode2;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] S = s.toCharArray();
        char[] P = p.toCharArray();
        P = opt(P);
        int n = S.length;
        int m = P.length;
        boolean[][] dp = new boolean[n + 1][m + 1];
        boolean[][] flags = new boolean[n + 1][2];
        for (int j = 0; j < m + 1; j ++) {
            for (int i = 0; i < n + 1; i ++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && P[j - 1] == '*' ? true : false; 
                } else if (j == 0) {
                    dp[i][j] = false;
                } else {
                    if (S[i - 1] == P[j - 1] || P[j - 1] == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (P[j - 1] == '*') {
                        dp[i][j] = flags[i][(j + 1) % 2];
                    } else {
                        dp[i][j] = false;
                    }
                }
                flags[i][j % 2] = i == 0 ? dp[i][j] : (flags[i - 1][j % 2] || dp[i][j]);
            }
        }
        return dp[n][m];
    }
    
    private char[] opt(char[] p) {
        if (p.length == 0) {
            return p;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length - 1; i ++) {
            if (p[i] == '*' && p[i + 1] == '*') {
                
            } else {
                sb.append(p[i]);
            }
        }
        sb.append(p[p.length - 1]);
        return sb.toString().toCharArray();
    }
}
