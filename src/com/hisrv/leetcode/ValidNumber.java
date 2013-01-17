package com.hisrv.leetcode;

public class ValidNumber {
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = s.length();
        if (n == 0) {
            return false;
        }
        int i = 0;
        while (s.charAt(i) == ' ') {
            i ++;
            if (i >= n) {
                return false;
            }
        }
        int j = n - 1;
        while (s.charAt(j) == ' ') {
            j --;
        }
        if (i == j && (s.charAt(i) < '0' || s.charAt(i) > '9')) {
            return false;
        }
        int pe = -1;
        int pd = -1;
        for (int k = i; k <= j; k ++) {
            char c = s.charAt(k);
            if (c == '.' && pd == -1) {
                pd = k;
            } else if (c == 'e' && pe == -1) {
                pe = k;
            } else if (k == i && (c == '+' || c == '-')) {
                if (k == j) {
                    return false;
                } else if (s.charAt(k + 1) == 'e') {
                    return false;
                } else if (s.charAt(k + 1) == '.' && k + 1 == j) {
                    return false;
                }
            } else if ((c == '+' || c == '-') && s.charAt(k - 1) == 'e' && k < j) {
            } else if (c >= '0' && c <= '9') {
            } else {
                return false;
            }
        }
        if (pe != -1) {
            if (pe == j || pe == i) {
                return false;
            } 
            if (s.charAt(pe - 1) < '0' || s.charAt(pe - 1) > '9') {
                if (s.charAt(pe - 1) != '.') {
                    return false;
                } else if (pd == i) {
                    return false;
                }
            } 
            for (int k = pe + 1; k <= j; k ++) {
                char c = s.charAt(k);
                if (c == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}
