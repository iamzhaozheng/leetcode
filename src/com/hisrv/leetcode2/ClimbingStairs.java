package com.hisrv.leetcode2;

public class ClimbingStairs {
    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 1) {
            return 1;
        } 
        int a = 1;
        int b = 2;
        int c = b;
        for (int i = 2; i < n; i ++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
