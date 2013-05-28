package com.hisrv.leetcode2;

public class SpiralMatrix2 {
    private static final int[] DIR = new int[] {1, 0, 0, 1, -1, 0, 0, -1};
    
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] mat = new int[n][n];
        int x = -1;
        int y = 0;
        int t = n;
        int p = 1;
        int d = 0;
        while (t > 0) {
            for (int i = 0; i < t; i ++) {
                x += DIR[d * 2];
                y += DIR[d * 2 + 1];
                mat[y][x] = p;
                p ++;
            }
            if (d % 2 == 0) {
                t --;
            }
            d = (d + 1) % 4;
        }
        return mat;
    }
}
