package com.hisrv.leetcode3;

public class ReverseInteger {
    public int reverse(int x) {
        boolean sign = x >= 0;
        x = sign ? x : -x;
        int ret = 0;
        while (x != 0) {
            int digit = x % 10;
            x = x / 10;
            ret = ret * 10 + digit;
        }
        ret = sign ? ret : -ret;
        return ret;
    }
    
    public static void main(String[] args) {
    	ReverseInteger f = new ReverseInteger();
    	System.out.print(f.reverse(-123));
    }
}
