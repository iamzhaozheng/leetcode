package com.hisrv.leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        boolean[] flag = new boolean[256];
        for (int i = 0; i < 256; i ++) {
            flag[i] = false;
        }
        int b = 0;
        int e = 0;
        int max = 1;
        while (e < n) {
            if (flag[s.charAt(e)]) {
                flag[s.charAt(b ++)] = false;
            } else {
                if (e - b + 1 > max) {
                    max = e - b + 1;
                }
                flag[s.charAt(e ++)] = true;
            }
        }
        return max;
    }
}
