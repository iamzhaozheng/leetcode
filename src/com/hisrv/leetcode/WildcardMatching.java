package com.hisrv.leetcode;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        p = optPattern(p);
        if (p.length() == 0 && s.length() == 0) {
            return true;
        } else if (p.length() == 0) {
            return false;
        } else if (s.length() == 0) {
            if (p.length() == 1 && p.charAt(0) == '*') {
                return true;
            } else {
                return false;
            }
        }
        if (p.charAt(0) == '?') {
            return isMatch(s.substring(1), p.substring(1));
        } else if (p.charAt(0) == '*') {
            for (int i = 0; i <= s.length(); i ++) {
                if (isMatch(s.substring(i), p.substring(1))) {
                    return true;
                }
            }
            return false;
        } else {
            if (p.charAt(0) == s.charAt(0)) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
    }
    
    private String optPattern(String p) {
        String r = "";
        for (int i = 0; i < p.length(); i ++) {
           if (p.charAt(i) == '*') {
                if (r.length() > 0 && r.charAt(r.length() - 1) == '*') {
                } else {
                    r += '*';
                }
            } else {
                r += p.charAt(i);
            }
        }
        return r;
    }
}
