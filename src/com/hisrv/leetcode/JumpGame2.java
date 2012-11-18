package com.hisrv.leetcode;

public class JumpGame2 {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length == 0 || A.length == 1) {
            return 0;
        }
        int[] steps = new int[A.length];
        steps[A.length - 1] = 0;
        for(int i = A.length - 2; i >= 0; i --) {
            int min = -1;
            int len = Math.min(A.length - 1, A[i] + i);
            for (int j = i + 1; j <= len; j ++) {
                if (steps[j] == -1) {
                    continue;
                }
                if (min == -1 || min > steps[j] + 1) {
                    min = steps[j] + 1;
                }
            }
            steps[i] = min;
        }
        return steps[0];
    }
}
