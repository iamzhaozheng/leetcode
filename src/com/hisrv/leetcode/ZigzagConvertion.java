package com.hisrv.leetcode;

public class ZigzagConvertion {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (nRows <= 1) {
            return s;
        }
        int n = s.length();
        String[] mat = new String[nRows];
        for (int i = 0; i < nRows; i ++) {
            mat[i] = "";
        }
        int r = 0;
        boolean down = true;
        for (int i = 0; i < n; i ++) {
            mat[r] += s.charAt(i);
            if (down) {
                if (r == nRows - 1) {
                    down = !down;
                    r --;
                } else {
                    r ++;
                }
            } else {
                if (r == 0) {
                    down = !down;
                    r ++;
                } else {
                    r --;
                }
            }
        }
        String ret = "";
        for (int i = 0; i < nRows; i ++) {
            ret += mat[i];
        }
        return ret;
    }
}
