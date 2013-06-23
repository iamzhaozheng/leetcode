package com.hisrv.leetcode2;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int j = 1;
        for (int i = 1; i < n; i ++) {
            if (A[i] != A[i - 1]) {
                A[j ++] = A[i]; 
            } 
        }
        return j;
    }
}
