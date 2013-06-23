package com.hisrv.leetcode2;

public class StringToInteger {
    private boolean sign;
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] s = str.toCharArray();
        s = purify(s);
        long num = 0;
        int n = Math.min(s.length, 11);
        for (int i = 0; i < n; i ++) {
            num *= 10;
            num += (s[i] - '0');
        }
        num = sign ? num : -num;
        int ret;
        if (num > Integer.MAX_VALUE) {
            ret = Integer.MAX_VALUE;
        } else if (num < Integer.MIN_VALUE) {
            ret = Integer.MIN_VALUE;
        } else {
            ret = (int)num;
        }
        return ret;
    }
    
    private char[] purify(char[] s) {
        sign = true;
        char[] a = new char[s.length];
        int j = 0;
        boolean nonspace = false;
        for (int i = 0; i < s.length; i ++) {
            if (s[i] != ' ' || nonspace) {
                a[j ++] = s[i];
                nonspace = true;
            }
        }
        if (j == 0 || a[0] != '+' && a[0] != '-' && (a[0] < '0' || a[0] > '9')) {
            return new char[0];
        }
        if (a[0] == '-') {
            sign = false;
        }
        int start = (a[0] == '+' || a[0] == '-') ? 1 : 0;
        if (start >= j || a[start] < '0' || a[start] > '9') {
            return new char[0];
        }
        boolean gotStart = false;
        int end = j - 1;
        for (int i = start; i < j; i ++) {
            if (a[i] != '0' && !gotStart) {
                gotStart = true;
                start = i;
            } 
            if (a[i] < '0' || a[i] > '9') {
                end = i - 1;
                break;
            }
        }
        if (gotStart) {
            char[] ret = new char[end - start + 1];
            for (int i = start; i <= end; i ++) {
                ret[i - start] = a[i];
            }
            return ret;
        } else {
            return new char[0];
        }
    }
}
