package com.hisrv.leetcode;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        p = optPattern(p);
        int n = s.length();
        int m = p.length();
        boolean[] star = new boolean[m + 1];
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i ++) {
        	for (int j = 0; j <= m; j ++) {
        		if (i == 0 && j == 0) {
        			dp[i][j] = true;
        		} else if (i == 0) {
        			if (j == 1 && p.charAt(0) == '*') {
        				dp[i][j] = true;
        			} else {
        				dp[i][j] = false;
        			}
        		} else if (j == 0) {
        			dp[i][j] = false;
        		} else {
        			if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
        				dp[i][j] = dp[i - 1][j - 1];
        			} else if (p.charAt(j - 1) == '*') {
        				dp[i][j] = star[j - 1];
        			} else {
        				dp[i][j] = false;
        			}
        		}
        		star[j] |= dp[i][j];
        	}
        }
        return dp[n][m];
    }
    
    private String optPattern(String p) {
        String r = "";
        for (int i = 0; i < p.length(); i ++) {
           if (p.charAt(i) == '*') {
                if (r.length() > 0 && r.charAt(r.length() - 1) == '*') {
                } else {
                    r += '*';
                }
            } else {
                r += p.charAt(i);
            }
        }
        return r;
    }
}
