package com.hisrv.leetcode3;

public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if (nRows <= 1) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[nRows];
        for (int i = 0; i < sbs.length; i ++) {
            sbs[i] = new StringBuilder();
        }
        char[] chs = s.toCharArray();
        int j = 0;
        boolean inv = false;
        for (int i = 0; i < chs.length; i ++) {
            sbs[j].append(chs[i]);
            if (inv) {
                if (j <= 0) {
                    j ++;
                    inv = false;
                } else {
                    j --;
                }
            } else {
                if (j >= nRows - 1) {
                    j --;
                    inv = true;
                } else {
                    j ++;
                }
            }
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < sbs.length; i ++) {
            ret.append(sbs[i].toString());
        }
        return ret.toString();
    }
    
    public static void main(String[] args) {
    	ZigZagConversion f = new ZigZagConversion();
    	System.out.print(f.convert("A", 2));
    }
}
