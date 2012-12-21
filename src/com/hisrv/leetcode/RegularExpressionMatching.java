package com.hisrv.leetcode;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.length() == 0) {
            if (p.length() == 0) {
            	return true;
            } else if (p.charAt(p.length() - 1) == '*') {
            	return isMatch(s, p.substring(0, p.length() - 2));
            } else {
                return false;
            }
        }
        char c = s.charAt(s.length() - 1);
        if (p.length() == 0) {
            return false;
        }
        char cp = p.charAt(p.length() - 1);
        if (cp == '.' || cp == c) {
            return isMatch(s.substring(0, s.length() - 1), p.substring(0, p.length() - 1));
        }
        if (cp != '*') {
            return false;
        }
        int i = p.length() - 1;
        while (i >= 0 && p.charAt(i) == '*') i --;
        if (i < 0) {
            return false;
        }
        String pat = p.substring(0, i);
        int j = 0;
        while (j <= s.length()) {
            if (isMatch(s, pat)) {
                return true;
            }
            pat += p.substring(i, i + 1);
            j ++;
        }
        return false;
    }
}
