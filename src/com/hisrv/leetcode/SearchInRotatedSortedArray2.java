package com.hisrv.leetcode;

public class SearchInRotatedSortedArray2 {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        if (n == 0) {
            return false;
        }
        return search(A, 0, n - 1, target);
    }
    
    private boolean search(int[] A, int start, int end, int target) {
    	if (start > end) {
    		return false;
    	}
    	int mid = (start + end) / 2;
    	if (A[mid] == target) {
    		return true;
    	} else if (mid == start) {
    		return search(A, mid + 1, end, target);
    	} else if (A[mid] == A[start]) {
    		return search(A, start, mid - 1, target) || search(A, mid + 1, end, target);
    	} else if (A[mid] > A[start] && (target > A[mid] || target < A[start]) || A[mid] < A[start] && target > A[mid] && target < A[start]) {
    		return search(A, mid + 1, end, target);
    	} else {
    		return search(A, start, mid - 1, target);
    	}
    }
}
