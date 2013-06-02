package com.hisrv.leetcode2;

import java.util.Arrays;

public class JumpGame {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        boolean[] flags = new boolean[n];
        Arrays.fill(flags, false);
        flags[0] = true;
        int i = 0, j = 1;
        while (i < j && j < n) {
            while (i + A[i] >= j && j < n) {
                flags[j ++] = true;
            }
            i ++;
        }
        return flags[n - 1];
    }
}
