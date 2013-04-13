package com.hisrv.leetcode2;

import java.util.ArrayList;

public class RestoreIpAddress {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return recur(s, 3);
    }
    
    private ArrayList<String> recur(String s, int n) {
        ArrayList<String> ret = new ArrayList<String> ();
        if (s.length() == 0 || s.length() > 12) {
            return ret;
        }
        if (n == 0) {
            if (s.charAt(0) == '0' && s.length() > 1) {
                return ret;
            }
            long num = Long.valueOf(s);
            if (num >= 0 && num <= 255) {
                ret.add(String.valueOf(num));
            }
            return ret;
        }
        int m = Math.min(3, s.length());
        if (s.charAt(0) == '0') {
            m = 1;
        }
        for (int i = 0; i < m; i ++) {
            String z = s.substring(0, i + 1);
            long num = Long.valueOf(z);
            if (num >= 0 && num <= 255) {
                ArrayList<String> list = recur(s.substring(i + 1), n - 1);
                for (String sub : list) {
                    ret.add(String.valueOf(num) + "." + sub);
                }
            }
        }
        return ret;
    }
}
