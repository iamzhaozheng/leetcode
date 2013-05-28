package com.hisrv.leetcode2;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    grid[i][j] = 1;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j];
                } else {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
