package com.hisrv.leetcode;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = s.length();
        int i = 0;
        int j = n - 1;
        char[] cs = s.toCharArray();
        while (i < j) {
            char a = trans(cs[i]);
            char b = trans(cs[j]);
            if (a == '.') {
                i ++;
            } else if (b == '.') {
                j --;
            } else {
                if (a != b) {
                    return false;
                } else {
                    i ++;
                    j --;
                }
            }
        }
        return true;
    }
    
    private char trans(char c) {
        if (c >= '0' && c <= '9') {
            return c;
        }
        if (c >= 'A' && c <= 'Z') {
            return (char)(c + 'a' - 'A');
        }
        if (c >= 'a' && c <= 'z') {
            return c;
        }
        return '.';
    }
}
