package com.hisrv.leetcode;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int i = 0; 
        int j = 1;
        boolean flag = false;
        while (j < n) {
            if (A[i] != A[j] || flag == false) {
                if (A[i] == A[j]) {
                    flag = true;
                } else {
                    flag = false;
                }
                ++ i;
                A[i] = A[j];
            }
            j ++;
        }
        return i + 1;
    }
}
