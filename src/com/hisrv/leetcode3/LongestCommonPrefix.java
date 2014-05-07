package com.hisrv.leetcode3;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }
        String ret = "";
        for (int i = 0; i < strs[0].length(); i ++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    return ret;
                }
            }
            ret += c;
        }
        return ret;
    }
}
