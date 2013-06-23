package com.hisrv.leetcode2;

public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        int i = 0;
        int j = 0;
        while (j < n) {
            while (j < n && A[j] == elem) {
                j ++;
            }
            if (j == n) {
                return i;
            }
            A[i ++] = A[j ++];
        }
        return i;
    }
}
