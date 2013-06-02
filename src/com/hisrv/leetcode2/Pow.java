package com.hisrv.leetcode2;

public class Pow {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean positive = true;
        if (n < 0) {
            n = -n;
            positive = false;
        }
        double ret = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ret *= x;
            }
            n = n >> 1;
            x = x * x;
        }
        return positive ? ret : 1 / ret;
    }
}
