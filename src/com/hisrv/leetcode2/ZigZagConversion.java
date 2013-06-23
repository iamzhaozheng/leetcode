package com.hisrv.leetcode2;

public class ZigZagConversion {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (nRows <= 1) {
            return s;
        }
        char[] str = s.toCharArray();
        int n = str.length;
        StringBuilder[] mat = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i ++) {
            mat[i] = new StringBuilder();
        }
        int row = 0;
        boolean down = true;
        for (int i = 0; i < n; i ++) {
            mat[row].append(str[i]);
            if (down) {
                row ++;
            } else {
                row --;
            }
            if (row >= nRows) {
                down = false;
                row -= 2;
            } else if (row < 0) {
                down = true;
                row += 2;
            }
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < nRows; i ++) {
            ret.append(mat[i].toString());
        }
        return ret.toString();
    }
}
