package com.hisrv.leetcode2;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = matrix.length;
        if (n == 0) {
            return;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return;
        }
        boolean row = false, col = false;
        if (matrix[0][0] == 0) {
            row = true;
            col = true;
        } else {
            for (int i = 1; i < n; i ++) {
                if (matrix[i][0] == 0) {
                    row = true;
                }
            }
            for (int i = 1; i < m; i ++) {
                if (matrix[0][i] == 0) {
                    col = true;
                }
            }
        }
        for (int i = 1; i < n; i ++) {
            for (int j = 1; j < m; j ++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i ++) {
            for (int j = 1; j < m; j ++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row) {
            for (int i = 0; i < n; i ++) {
                matrix[i][0] = 0;
            }
        }
        if (col) {
            for (int i = 0; i < m; i ++) {
                matrix[0][i] = 0;
            }
        }
    }
}
