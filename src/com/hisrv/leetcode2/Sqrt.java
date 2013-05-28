package com.hisrv.leetcode2;

public class Sqrt {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sqrt(x, 0, x);
    }
    
    private int sqrt(long x, long s, long e) {
        long r = (s + e) / 2;
        if (r * r <= x && (r + 1) * (r + 1) > x) {
            return (int)r;
        } else if (r * r > x) {
            return sqrt(x, s, r - 1);
        } else {
            return sqrt(x, r + 1, e);
        }
    }
}
