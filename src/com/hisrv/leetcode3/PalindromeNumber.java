package com.hisrv.leetcode3;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int t = 1;
        while (x / t >= 10) {
            t *= 10;
        }
        while (x != 0) {
            if (x % 10 != x / t) {
                return false;
            }
            x = x % t;
            x = x / 10;
            t /= 100;
        }
        return true;
    }
    
    public static void main(String[] args) {
    	PalindromeNumber f = new PalindromeNumber();
    	System.out.print(f.isPalindrome(0));
    }
}
