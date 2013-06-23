package com.hisrv.leetcode2;

public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] ret = new int[2];
        int n = A.length;
        int s = searchStart(A, target, 0, n - 1);
        if (s == -1) {
            ret[0] = ret[1] = -1;
            return ret;
        } else {
            int e = searchEnd(A, target, s, n - 1);
            ret[0] = s;
            ret[1] = e;
            return ret;
        }
    }
    
    private int searchStart(int[] A, int target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int m = (s + e) / 2;
        if (m == 0) {
            return A[m] == target ? 0 : searchStart(A, target, m + 1, e);
        }
        if (A[m] < target) {
            return searchStart(A, target, m + 1, e);
        } else if (A[m] == target && A[m - 1] < target) {
            return m;
        } else {
            return searchStart(A, target, s, m - 1);
        }
    }
    
    private int searchEnd(int[] A, int target, int s, int e) {
        int n = A.length;
        int m = (s + e) / 2;
        if (m == n - 1) {
            return A[m] == target ? n - 1 : searchEnd(A, target, s, m - 1);
        }
        if (A[m] > target) {
            return searchEnd(A, target, s, m - 1);
        } else if (A[m] == target && A[m + 1] > target) {
            return m;
        } else {
            return searchEnd(A, target, m + 1, e);
        }
    }
}
