package com.hisrv.leetcode2;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = s1.length();
        if (n <= 1) {
            return s1.equals(s2);
        }
        for (int i = 1; i <= n - 1; i ++) {
            String s1l = s1.substring(0, i);
            String s1r = s1.substring(i, n);
            String s2l = s2.substring(0, i);
            String s2r = s2.substring(i, n);
            if (same(s1l, s2l) && same(s1r, s2r)) {
                if (isScramble(s1l, s2l) && isScramble(s1r, s2r)) {
                    return true;
                }
            } 
            s2l = s2.substring(0, n - i);
            s2r = s2.substring(n - i, n);
            if (same(s1l, s2r) && same(s1r, s2l)) {
                if (isScramble(s1l, s2r) && isScramble(s1r, s2l)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean same(String s1, String s2) {
        int[] h = new int[256];
        for (int i = 0; i < s1.length(); i ++) {
            h[s1.charAt(i)] ++;
        }
        for (int i = 0; i < s2.length(); i ++) {
            if ((h[s2.charAt(i)] --) == 0) {
                return false;
            }
        }
        return true;
    }
}
