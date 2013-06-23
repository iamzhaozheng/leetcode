package com.hisrv.leetcode2;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] str = s.toCharArray();
        int n = str.length;
        int maxS = 0, maxE = 0;
        for (int i = 0; i < n; i ++) {
            int t = maxPalin(str, i, true);
            if (t * 2 + 1 > maxE - maxS + 1) {
                maxS = i - t;
                maxE = i + t;
            }
            if (i < n - 1) {
                t = maxPalin(str, i, false);
                if (t * 2 > maxE - maxS + 1) {
                    maxS = i - t + 1;
                    maxE = i + t;
                }
            }
        }
        return s.substring(maxS, maxE + 1);
    }
    
    private int maxPalin(char[] s, int center, boolean onCenter) {
        int n = s.length;
        if (onCenter) {
            int mr = Math.min(center, n - center - 1);
            for (int i = 1; i <= mr; i ++) {
                if (s[center - i] != s[center + i]) {
                    return i - 1;
                }
            }
            return mr;
        } else {
            int mr = Math.min(center + 1, n - center - 1);
            for (int i = 1; i <= mr; i ++) {
                if (s[center - i + 1] != s[center + i]) {
                    return i - 1;
                }
            }
            return mr;
        }
    }
}
