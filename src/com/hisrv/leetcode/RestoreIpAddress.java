package com.hisrv.leetcode;

import java.util.ArrayList;

public class RestoreIpAddress {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return restore(s, 4);
    }
    
    private boolean avail(String s) {
        if (s.length() == 0) {
            return false;
        }
        if (s.length() == 1) {
            return true;
        } 
        if (s.charAt(0) == '0') {
            return false;
        }
        return true;
    }
    
    private ArrayList<String> restore(String s, int n) {
        ArrayList<String> ret = new ArrayList<String> ();
        if (n == 1) {
            if (!avail(s)) {
                return ret;
            }

            if (s.length() <= 3 && Integer.parseInt(s) <= 255) {
                ret.add(s);
            }
            return ret;
        }
        for (int i = 1; i <= Math.min(3, s.length() - 1); i ++) {
            String s1 = s.substring(0, s.length() - i);
            String s2 = s.substring(s.length() - i, s.length());
            if (!avail(s2)) {
                continue;
            }
            if (Integer.parseInt(s2) <= 255) {
                ArrayList<String> list = restore(s1, n - 1);
                for (String sip : list) {
                    sip += "." + s2;
                    ret.add(sip);
                }
            }
        }
        return ret;
    }

}
