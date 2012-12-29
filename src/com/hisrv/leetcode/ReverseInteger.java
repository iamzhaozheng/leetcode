package com.hisrv.leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean plus = true;
        if (x < 0) {
            plus = false;
            x = -x;
        }
        int ret = 0;
        while (x != 0) {
            ret *= 10;
            ret += x % 10;
            x /= 10;
        }
        return plus ? ret : -ret;
    }
}
