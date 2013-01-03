package com.hisrv.leetcode;

public class Sqrtx {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x <= 0) {
            return 0;
        } else if (x == 1) {
            return 1;
        }
        long s, e;
        s = 1;
        e = x / 2;
        while (true) {
            long r = (s + e) / 2;
            long r2 = r * r;
            long rp12 = (r + 1) * (r + 1);
            if (r2 <= x && rp12 > x) {
                return (int)r;
            } else if (r * r > x) {
                e = r - 1;
            } else {
                s = r + 1;
            }
        }
    }
}
