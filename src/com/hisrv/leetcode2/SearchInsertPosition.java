package com.hisrv.leetcode2;

public class SearchInsertPosition {
    
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return search(A, target, 0, A.length - 1);
    }
    
    private int search(int[] A, int target, int start, int end) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int mid = (start + end) / 2;
        if (A[mid] == target || A[mid] > target && (mid == 0 || A[mid - 1] < target)) {
            return mid;
        } else if (A[mid] < target) {
            if (mid == end) {
                return end + 1;
            }
            return search(A, target, mid + 1, end);
        } else {
            return search(A, target, start, mid);
        }
    }
}
