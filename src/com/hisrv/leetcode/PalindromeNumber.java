package com.hisrv.leetcode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x < 0) {
        	return false;
        }
        if (x < 10) {
        	return true;
        }
        int n = 1;
        while (x / n >= 10) {
        	n *= 10;
        }
        while (x >= 10) {
        	if (x % 10 != x / n) {
        		return false;
        	}
        	x = (x % n) / 10;
        	n /= 100;
        }
        return true;
    }
}
