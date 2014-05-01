package com.hisrv.leetcode3;

public class Pow {
    public double pow(double x, int n) {
        double ret = 1;
        boolean sign = (n >= 0);
        long t = n;
        t = Math.abs(t);
        while (t != 0) {
            int k = (int)(t % 2);
            if (k == 1) {
                ret *= x;
            }
            t = t >> 1;
            x *= x;
        }
        return sign ? ret : 1 / ret;
    }

}
