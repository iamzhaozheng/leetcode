package com.hisrv.leetcode2;

import java.util.Arrays;

public class JumpGame2 {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        int[] steps = new int[n];
        Arrays.fill(steps, Integer.MAX_VALUE);
        int j = 1;
        steps[0] = 0;
        for (int i = 0; i < n && j < n; i ++) {
            while (j < n && i + A[i] >= j) {
                steps[j] = Math.min(steps[j], steps[i] + 1);
                j ++;
            }
        }
        return steps[n - 1];
    }
}
