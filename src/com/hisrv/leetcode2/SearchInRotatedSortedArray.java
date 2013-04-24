package com.hisrv.leetcode2;

public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        return search(A, 0, n - 1, target);
    }
    
    private int search(int[] A, int s, int e, int target) {
        if (s > e) {
            return -1;
        }
        int m = (s + e) / 2;
        if (A[m] == target) {
            return m;
        } else if (A[m] < target && target <= A[e] || target <= A[e] && A[e] <= A[m] || A[e] <= A[m] && A[m] < target){
            return search(A, m + 1, e, target);
        } else {
            return search(A, s, m - 1, target);
        }
    }
}
