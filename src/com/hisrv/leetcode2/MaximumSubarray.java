package com.hisrv.leetcode2;

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
        int max = A[0];
        for (int i = 1; i < n; i ++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1]+ A[i] : A[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
