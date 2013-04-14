package com.hisrv.leetcode2;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int a = m - 1;
        int b = n - 1;
        for (int i = m + n - 1; i >= 0; i --) {
            if (a >= 0 && b >= 0) {
                A[i] = A[a] > B[b] ? A[a --] : B[b --];
            } else {
                A[i] = a >= 0 ? A[a --] : B[b --];
            }
        }
    }
}
