package com.hisrv.leetcode;

public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int i = 0, j = n;
        while (i < j) {
            if (A[i] == elem) {
                j --;
                while (i < j && A[j] == elem) {
                    j --;
                }
                if (i >= j) {
                    return i;
                }
                A[i] = A[j];
            }
            i ++;
        }
        return i;
    }
}
