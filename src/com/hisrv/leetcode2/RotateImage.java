package com.hisrv.leetcode2;

public class RotateImage {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < m / 2; j ++) {
                int ul = matrix[i][j];
                int ur = matrix[j][m - i - 1];
                int dr = matrix[n - i - 1][m - j - 1];
                int dl = matrix[n - j - 1][i];
                matrix[i][j] = dl;
                matrix[j][m - i - 1] = ul;
                matrix[n - i - 1][m - j - 1] = ur;
                matrix[n - j - 1][i] = dr;
            }
        }
    }
}
