package com.hisrv.leetcode2;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return recur(s1, s1.length(), s2, s2.length(), s3, s3.length());
    }
    
    private boolean recur(String s1, int l1, String s2, int l2, String s3, int l3) {
        if (l1 + l2 != l3) {
            return false;
        }
        if (l3 == 0) {
            return true;
        }
        if (l1 == 0) {
            if (s2.charAt(l2 - 1) == s3.charAt(l3 - 1)) {
                return recur(s1, l1, s2, l2 - 1, s3, l3 - 1);
            } else {
                return false;
            }
        } else if (l2 == 0) {
            if (s1.charAt(l1 - 1) == s3.charAt(l3 - 1)) {
                return recur(s1, l1 - 1, s2, l2, s3, l3 - 1);
            } else {
                return false;
            }
        } else {
            if (s1.charAt(l1 - 1) == s3.charAt(l3 - 1) && s2.charAt(l2 - 1) == s3.charAt(l3 - 1)) {
                return recur(s1, l1 - 1, s2, l2, s3, l3 - 1) || recur(s1, l1, s2, l2 - 1, s3, l3 - 1);
            } else if (s1.charAt(l1 - 1) == s3.charAt(l3 - 1)) {
                return recur(s1, l1 - 1, s2, l2, s3, l3 - 1);
            } else if (s2.charAt(l2 - 1) == s3.charAt(l3 - 1)) {
                return recur(s1, l1, s2, l2 - 1, s3, l3 - 1);
            } else {
                return false;
            }
        }
    }
}
