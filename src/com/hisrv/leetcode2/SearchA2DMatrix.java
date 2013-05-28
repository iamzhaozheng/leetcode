package com.hisrv.leetcode2;

public class SearchA2DMatrix {
    private int[][] mMatrix;
    private int mM, mN;
    
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        mMatrix = matrix;    
        mN = matrix.length;
        if (mN == 0) {
            return false;
        }
        mM = matrix[0].length;
        if (mM == 0) {
            return false;
        }
        return find(0, mN * mM - 1, target);
    }
    
    private boolean find(int s, int e, int target) {
        if (s > e) {
            return false;
        }
        int m = (s + e) / 2;
        int row = m / mM;
        int col = m % mM;
        if (mMatrix[row][col] < target) {
            return find(m + 1, e, target);
        } else if (mMatrix[row][col] > target) {
            return find(s, m - 1, target);
        } else {
            return true;
        }
    }
}
