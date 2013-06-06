package com.hisrv.leetcode2;

public class TrappingRainWater {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i ++) {
            int s = 0;
            int step = A[i - 1];
            for (int j = i - 1; j >= 0; j --) {
                if (A[j] >= A[i]) {
                    s += (A[i] - step) * (i - j - 1);
                    break;
                } else if (A[j] <= step) {
                    //do nothing
                } else {
                    s += (A[j] - step) * (i - j - 1);
                    step = A[j];
                }
            }
            dp[i] = dp[i - 1] + s;
        }
        return dp[n - 1];
    }
}
