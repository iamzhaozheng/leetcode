package com.hisrv.leetcode2;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (i == 0 || j == 0) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
