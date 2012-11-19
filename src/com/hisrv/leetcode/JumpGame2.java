package com.hisrv.leetcode;

public class JumpGame2 {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length <= 1) {
            return 0;
        }
        int[] steps = new int[A.length];
        int j = 0;
        steps[j ++] = 0;
        for (int i = 0; i < A.length - 1; i ++) {
            while (A[i] + i >= j && j < A.length) {
                steps[j ++] = steps[i] + 1;
            }
        }
        return steps[A.length - 1];
    }
}
