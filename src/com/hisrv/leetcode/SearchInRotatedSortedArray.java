package com.hisrv.leetcode;

public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        if (n == 0) {
            return -1;
        }
        int s = 0;
        int e = A.length - 1;
        int m;
        while (s <= e) {
            m = (s + e) / 2;
            if (A[m] == target) {
                return m;
            } else if (A[m] >= A[0] && (target > A[m] || target < A[0]) || A[m] <= A[0] && target > A[m] && target < A[0]) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }
}
