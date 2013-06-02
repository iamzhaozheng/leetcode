package com.hisrv.leetcode2;

import java.util.ArrayList;

public class SpiralMatrix {
    private static final int[] DIR = new int[] {1, 0, 0, 1, -1, 0, 0, -1};
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> ret = new ArrayList<Integer> ();
        int n = matrix.length;
        if (n == 0) {
            return ret;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return ret;
        }
        int dir = 0;
        int x = -1, y = 0;
        int t = m;
        int tm = m;
        int tn = n;
        while (t > 0) {
            for (int i = 0; i < t; i ++) {
                x += DIR[dir * 2];
                y += DIR[dir * 2 + 1];
                ret.add(matrix[y][x]);
            }
            t = dir % 2 == 0 ? --tn : --tm;
            dir = (dir + 1) % 4;
        }
        return ret;
    }
}
