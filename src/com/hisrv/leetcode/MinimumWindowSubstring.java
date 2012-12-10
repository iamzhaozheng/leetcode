package com.hisrv.leetcode;

import java.util.Arrays;

public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = T.length();
        int n = S.length();
        if (m == 0 || n == 0 || n < m) {
            return "";
        }
        int[] hash = new int[256];
        boolean[] flag = new boolean[256];
        Arrays.fill(hash, 0);
        Arrays.fill(flag, false);
        char[] tcs = T.toCharArray();
        for (int i = 0; i < m; i ++) {
            hash[tcs[i]] ++; 
            flag[tcs[i]] = true;
        }
        char[] scs = S.toCharArray();
        int min = Integer.MAX_VALUE;
        int mini = 0, minj = 0;
        int j = 0;
        for (int i = 0; i < n; i ++) {
            int v = (int)scs[i];
            if (flag[v]) {
                hash[v] --;
                if (hash[v] >= 0) {
                    m --;
                }
            }
            while (m == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    mini = i;
                    minj = j;
                }
                int r = (int)scs[j ++];
                if (flag[r]) {
                    hash[r] ++;
                    if (hash[r] > 0) {
                        m ++;
                    }
                }
            }
        }
        if (min <= n) {
            return S.substring(minj, mini + 1);
        } else {
            return "";
        }
    }
}
