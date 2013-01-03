package com.hisrv.leetcode;

public class SortColors {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        int r = 0;
        int b = n - 1;
        int i = 0;
        while (i <= b) {
            if (A[i] == 0 && r < i) {
                swap(A, r ++, i);
            } else if (A[i] == 2 && i < b) {
                swap(A, b --, i);
            } else {
                i ++;
            }
        }
    }
    
    private void swap(int[] A, int a, int b) {
        if (A[a] != A[b]) {
            A[a] ^= A[b];
            A[b] ^= A[a];
            A[a] ^= A[b];
        }
    }
}
