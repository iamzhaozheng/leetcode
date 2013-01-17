package com.hisrv.leetcode;

public class TrappingRainWater {
    public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        int sum = 0;
        for (int i = 1; i < n; i ++) {
            int diff = A[i] - A[i - 1];
            if (diff > 0) {
                int t = A[i - 1];
                for (int j = i - 2; j >= 0; j --) {
                    if (A[j] > t) {
                        if (A[j] >= A[i]) {
                            sum += (A[i] - t) * (i - j - 1);
                            break;
                        } else {
                            sum += (A[j] - t) * (i - j - 1);
                            t = A[j];
                        }
                    }
                }
            }
        }
        return sum;
    }
}
