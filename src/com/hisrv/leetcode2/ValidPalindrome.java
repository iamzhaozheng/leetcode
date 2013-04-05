package com.hisrv.leetcode2;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] strs = s.toCharArray();
        int i = 0;
        int j = strs.length - 1;
        while (i < j) {
            char f, e;
            while ((f = getValidChar(strs[i])) == '*' && i < j) {
                i ++;
            }
            while ((e = getValidChar(strs[j])) == '*' && i < j) {
                j --;
            }
            if (i >= j) {
                break;
            }
            if (f != e) {
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }
    
    private char getValidChar(char c) {
        if (c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
            return c;
        }
        if (c >= 'a' && c <= 'z') {
            return (char)(c - ('a' - 'A'));
        }
        return '*';
    }
}
