package com.hisrv.leetcode;

public class Pow {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0) {
            return 1;
        }
        boolean minus = false;
        if (n < 0) {
            n = -n;
            minus = true;
        }
        double[] lut = new double[50];
        lut[0] = x;
        int m = 1;
        while ((1 << (m - 1)) <= n / 2) {
            lut[m] = lut[m - 1] * lut[m - 1];
            m ++;
        }
        double ret = 1;
        while (n > 0) {
            int i = m - 1;
            while ((1 << i) > n) {
                i --;
            }
            ret *= lut[i];
            n -= (1 << i);
        }
        return minus ? 1 / ret : ret;
    }
}
