package com.hisrv.leetcode;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        int max = 1;
        String rst = s.substring(0, 1);
        for (int i = 0; i < n - 1; i ++) {
            if (i != 0) {
                int num = getPalin(s, i, false);
                if (max < num) {
                    max = num;
                    rst = s.substring(i - num / 2, i - num / 2 + num);
                } 
            }
            int num = getPalin(s, i, true);
            if (max < num) {
                max = num;
                rst = s.substring(i - num / 2 + 1, i - num / 2 + 1 + num);
            }
        }
        return rst;
    }
    
    private int getPalin(String s, int p, boolean f) {
        int i = 1;
        int n = s.length();
        if (f) {
            while (p - i + 1 >= 0 && p + i < n) {
                if (s.charAt(p - i + 1) != s.charAt(p + i)) {
                    return 2 * (i - 1);
                }
                i ++;
            }
            return 2 * (i - 2);
        } else {
            while (p - i >= 0 && p + i < n) {
                if (s.charAt(p - i) != s.charAt(p + i)) {
                    return 2 * (i - 1) + 1;                    
                } 
                i ++;
            } 
            return 2 * (i - 2) + 1;
        }
    }

}
