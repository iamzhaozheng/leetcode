package com.hisrv.leetcode;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] ret = new int[n][n];
        int cnt = 0;
        int i = 0; 
        int j = 0;
        int dir = 0;
        int loop = 0;
        while (cnt ++ < n * n) {
            ret[i][j] = cnt;
            switch (dir) {
            case 0:
                if (j + 1 < n - loop) {
                    j ++;
                } else {
                    i ++;
                    dir = 1;
                }
                break;
            case 1:
                if (i + 1 < n - loop) {
                    i ++;
                } else {
                    j --;
                    dir = 2;
                }
                break;
            case 2:
                if (j - 1 >= loop) {
                    j --;
                } else {
                    i --;
                    loop ++;
                    dir = 3;
                }
                break;
            case 3:
                if (i - 1 >= loop) {
                    i --;
                } else {
                    j ++;
                    dir = 0;
                }
                break;
            }
        }
        return ret;
    }
}
