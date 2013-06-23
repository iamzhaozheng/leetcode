package com.hisrv.leetcode2;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = strs.length;
        String s = "";
        if (n == 0) {
            return s;
        }
        int m = strs[0].length();
        for (int i = 0; i < m; i ++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < n; j ++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    return s;
                }
            }
            s += c;
        }
        return s;
    }
}
