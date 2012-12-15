package com.hisrv.leetcode;

public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = A[0];
        int max = dp[0];        
        for (int i = 1; i < n; i ++) {
            dp[i] = Math.max(dp[i - 1] + A[i], A[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
