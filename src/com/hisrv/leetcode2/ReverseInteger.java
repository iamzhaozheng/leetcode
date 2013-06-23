package com.hisrv.leetcode2;

public class ReverseInteger {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long ret = 0;
        long l = x;
        boolean pos = x >= 0 ? true : false;
        l = Math.abs(l);
        while (l > 0) {
            ret = ret * 10 + l % 10;
            l /= 10;
        }
        ret = pos ? ret : -ret;
        return (int)ret;
    }
}
