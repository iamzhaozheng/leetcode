package com.hisrv.leetcode3;

public class StringToInteger {
    public int atoi(String str) {
        char[] s = str.toCharArray();
        int start = removeWhiteSpaces(s);
        if (start >= s.length) {
            return 0;
        } 
        boolean sign = true;
        if (s[start] == '-') {
            sign = false;
            start ++;
        } else if (s[start] == '+') {
            start ++;
        }
        long ret = 0;
        int i = start;
        while (i < s.length && s[i] >= '0' && s[i] <= '9') {
            ret = ret * 10 + (s[i] - '0');
            if (sign && ret > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (!sign && -ret < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i ++;
        }
        ret = sign ? ret : -ret;
        return (int)ret;
    }
    
    private int removeWhiteSpaces(char[] s) {
        int i = 0;
        while (i < s.length) {
            if (s[i] == ' ') {
                i ++;
            } else {
                return i;
            }
        }
        return i;
    }
    
}
