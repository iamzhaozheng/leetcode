package com.hisrv.leetcode2;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x < 0) {
            return false;
        }
        int t = 1;
        while (x / t >= 10) {
            t *= 10;
        }
        while (x >= 10) {
            if ((x % 10) != x / t) {
                return false;
            } else {
                x -= x / t * t;
                x /= 10;
                t /= 100;
            }
        }
        return true;
    }
}
