package com.hisrv.leetcode;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        for (int i = 0; i < n; i ++) {
            while (A[i] > 0 && A[i] < n && 
                    i != A[i] - 1 && A[A[i] - 1] != A[i]) {
                swap(A, A[i] - 1, i);
            }
        }
        for (int i = 0; i < n; i ++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
    
    private void swap(int[] num, int a, int b) {
        if (num[a] != num[b]) {
            num[a] ^= num[b];
            num[b] ^= num[a];
            num[a] ^= num[b];
        }
    }
}
