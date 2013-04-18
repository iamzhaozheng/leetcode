package com.hisrv.leetcode2;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        int[][] h = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (matrix[i][j] == '1') {
                    if (i == 0) {
                        h[i][j] = 1;
                    } else {
                        h[i][j] = h[i - 1][j] + 1;
                    }
                    int k = 1;
                    int minh = h[i][j];
                    while (j - k + 1 >= 0 && matrix[i][j - k + 1] == '1') {
                        minh = Math.min(minh, h[i][j - k + 1]);
                        max = Math.max(minh * k, max);
                        k ++;
                    }
                } else {
                    h[i][j] = 0;
                }
            }
        }
        return max;
    }
}
