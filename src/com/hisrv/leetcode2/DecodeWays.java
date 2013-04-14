package com.hisrv.leetcode2;

public class DecodeWays {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] str = s.toCharArray();
        int n = str.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[n] = 1;
        dp[n - 1] = str[n - 1] == '0' ? 0 : 1;
        for (int i = n - 2; i >= 0; i --) {
            if (str[i] == '0') {
                dp[i] = 0;
            } else if (str[i] == '1' || str[i] == '2' && str[i + 1] <= '6') {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }
}
