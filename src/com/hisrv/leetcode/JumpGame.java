package com.hisrv.leetcode;

public class JumpGame {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length == 0) {
            return false;
        }
        if (A.length == 1) {
            return true;
        }
        int minDist = 1;
        for (int i = A.length - 2; i >= 1; i --) {
            if (A[i] >= minDist) {
                minDist = 1;
            } else {
                minDist ++;
            }
        }
        if (A[0] >= minDist) {
            return true;
        }
        return false;
    }
}
