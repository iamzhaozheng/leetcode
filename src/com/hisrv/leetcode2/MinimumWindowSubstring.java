package com.hisrv.leetcode2;

import java.util.Arrays;

public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int n = s.length;
        int m = t.length;
        int i = 0;
        int j = 0;
        int[] hash = new int[256];
        int sum = 0;
        int minI = 0;
        int minL = Integer.MAX_VALUE;
        boolean[] flag = new boolean[256];
        Arrays.fill(hash, 0);
        Arrays.fill(flag, false);
        for (char c : t) {
            hash[c] ++;
            flag[c] = true;
            sum ++;
        }
        while (j < n || sum <= 0) {
            if (sum > 0) {
                if (flag[s[j]]) {
                    if (hash[s[j]] > 0) {
                        sum --;
                    }
                    hash[s[j]] --;                    
                }
                j ++;
            } else {
                if (minL > j - i) {
                    minL = j - i;
                    minI = i;
                }
                if (flag[s[i]]) {
                    if (hash[s[i]] >= 0) {
                        sum ++;
                    }
                    hash[s[i]] ++;
                }
                i ++;
            }
        }
        if (minL == Integer.MAX_VALUE) {
            return "";
        }
        return S.substring(minI, minI + minL);
    }
}
