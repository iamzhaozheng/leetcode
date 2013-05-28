package com.hisrv.leetcode2;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (i == 0 && j == 0) {
                    //do nothing
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[n - 1][m - 1];
    }
}
