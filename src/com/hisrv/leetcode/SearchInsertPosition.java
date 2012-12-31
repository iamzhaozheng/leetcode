package com.hisrv.leetcode;

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        if (target < A[0]) {
            return 0;
        }
        if (target > A[n - 1]) {
            return n;
        }
        int s = 0;
        int e = n - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (A[m] == target) {
                return m;
            } else if (A[m] < target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        if (A[s] > target) {
            return s;
        } else {
            return s + 1;
        }
    }
}
