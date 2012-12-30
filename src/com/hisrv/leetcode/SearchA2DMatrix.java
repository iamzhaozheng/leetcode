package com.hisrv.leetcode;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return false;
        }
        int l = m * n;
        int s = 0;
        int e = l - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            int v = matrix[mid / m][mid % m];
            if (v == target) {
                return true;
            } else if (v > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return false;
    }
}
