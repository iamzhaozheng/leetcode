package com.hisrv.leetcode2;

public class ImplementStrStr {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] pattern = needle.toCharArray();        
        char[] s = haystack.toCharArray();
        int m = pattern.length;
        int n = s.length;
        if (m == 0) {
            return haystack;
        }
        int[] back = getMatcher(pattern);
        int q = -1;
        for (int i = 0; i < n; i ++) {
            while (q > -1 && s[i] != pattern[q + 1]) {
                q = back[q];
            }
            if (s[i] == pattern[q + 1]) {
                q ++;
            }
            if (q == m - 1) {
                return haystack.substring(i - m + 1);
            }
        }
        return null;
    }
    
    private int[] getMatcher(char[] pattern) {
        int n = pattern.length;
        int[] ret = new int[n];
        ret[0] = -1;
        int q = -1;
        for (int i = 1; i < n; i ++) {
            while (q > -1 && pattern[i] != pattern[q + 1]) {
                q = ret[q];
            }
            if (pattern[i] == pattern[q + 1]) {
                q ++;
            }
            ret[i] = q;
        }
        return ret;
    }    
}
