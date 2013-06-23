package com.hisrv.leetcode2;

public class RegularExpressionMatching {
    private boolean[] star;
    private char[] p;
    
    public boolean isMatch(String S, String P) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] s = S.toCharArray();
        p = P.toCharArray();
        int n = s.length;
        initPattern(p);
        int m = p.length;
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int j = 0; j < m + 1; j ++) {
            for (int i = 0; i < n + 1; i ++) {
                if (j == 0) {
                    dp[i][j] = i == 0 ? true : false;
                } else if (i > 0) {
                    if (!star[j - 1] && s[i - 1] != p[j - 1] && p[j - 1] != '.') {
                        dp[i][j] = false;
                    } else if (star[j - 1] && s[i - 1] != p[j - 1] && p[j - 1] != '.') {
                        dp[i][j] = dp[i][j - 1];
                    } else if (star[j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '.')) {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                } else {
                    if (star[j - 1]) {
                        dp[i][j] = dp[i][j - 1]; 
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[n][m];
    }
    
    private void initPattern(char[] pat) {
        int m = pat.length;
        int t = 0;
        for (int i = 0; i < m; i ++) {
            if (pat[i] != '*') {
                t ++;
            }
        }
        star = new boolean[t];
        p = new char[t];
        int j = 0;
        for (int i = 0; i < m; i ++) {
            if (pat[i] == '*') {
                continue;
            }
            if (i < m - 1 && pat[i + 1] == '*') {
                star[j] = true;
                p[j ++] = pat[i];
            } else {
                star[j] = false;
                p[j ++] = pat[i];
            }
        }
    }
}
