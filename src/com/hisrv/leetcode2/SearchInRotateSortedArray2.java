package com.hisrv.leetcode2;

public class SearchInRotateSortedArray2 {
    private int[] a;
    
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        a = A;
        return search(0, a.length - 1, target);
    }
    
    private boolean search(int start, int end, int target) {
        if (start > end) {
            return false;
        }
        int mid = (start + end) / 2;
        if (a[mid] == target) {
            return true;
        }
        if (a[start] == a[end]) {
            return search(start, mid - 1, target) || search(mid + 1, end, target);
        }
        if (a[start] < a[end]) {
            if (target < a[mid]) {
                return search(start, mid - 1, target);
            } else {
                return search(mid + 1, end, target);
            }
        }
        if (target < a[mid] && target >= a[start] && a[mid] > a[start] || a[mid] < a[start] && (target >= a[start] || target < a[mid])) {
            return search(start, mid - 1, target);
        } else {
            return search(mid + 1, end, target);
        }
    }
}
