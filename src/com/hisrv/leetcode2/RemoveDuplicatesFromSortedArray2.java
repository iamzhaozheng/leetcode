package com.hisrv.leetcode2;

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        if (n < 2) {
            return n;
        }
        int j = 2;
        int temp = A[0];
        for (int i = 2; i < n; i ++) {
            if (A[i] == A[i - 1] && A[i - 1] == temp) {
                
            } else {
                temp = A[i - 1];
                A[j ++] = A[i];
            }
        }
        return j;
    }
}
