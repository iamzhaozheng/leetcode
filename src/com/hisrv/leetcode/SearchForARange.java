package com.hisrv.leetcode;

public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        if (n == 0) {
            return new int[] {-1, -1};
        }
        int s = 0;
        int e = A.length - 1;
        int start = -1;
        int m;
        while (s <= e) {
            m = (s + e) / 2;
            if (A[m] == target && (m == 0 || A[m - 1] != target)) {
                start = m;
                break;
            } else if (A[m] >= target) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        if (start == -1) {
            return new int[] {-1, -1};
        }
        e = A.length - 1;
        s = start;
        while (s <= e) {
            m = (s + e) / 2;
            if (A[m] == target && (m == A.length - 1 || A[m + 1] != target)) {
                return new int[] {start, m};
            } else if (A[m] <= target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return new int[] {-1, -1};
    }
}
