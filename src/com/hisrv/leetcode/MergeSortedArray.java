package com.hisrv.leetcode;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ap = m - 1;
        int bp = n - 1;
        for (int i = m + n - 1; i >= 0; i --) {
            if (ap >= 0 && bp >= 0) {
                A[i] = A[ap] > B[bp] ? A[ap --] : B[bp --];
            } else {
                A[i] = ap >= 0 ? A[ap --] : B[bp --];
            }
        }
    }
}