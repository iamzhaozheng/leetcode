package com.hisrv.leetcode3;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), 0, p.toCharArray(), 0);
    }
    
    private boolean isMatch(char[] s, int ps, char[] p, int pp) {
        if (ps >= s.length && pp >= p.length) {
            return true;
        } else if (pp < p.length) {
            if (pp < p.length - 1 && p[pp + 1] == '*') {
                if (ps < s.length && (s[ps] == p[pp] || p[pp] == '.')) {
                    return isMatch(s, ps + 1, p, pp) || isMatch(s, ps, p, pp + 2);
                } else {
                    return isMatch(s, ps, p, pp + 2);
                }
            } else if (ps < s.length && (s[ps] == p[pp] || p[pp] == '.')) {
                return isMatch(s, ps + 1, p, pp + 1);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
