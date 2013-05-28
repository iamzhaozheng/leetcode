package com.hisrv.leetcode2;

public class SortColors {
    private int[] mA;
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        mA = A;
        int r, w, b;
        r = 0;
        w = 0;
        b = n - 1;
        while (w <= b) {
            if (A[w] == 0) {
                if (w > r) {
                    swap(w, r ++);
                } else {
                    w ++;
                }
            } else if (A[w] == 1) {
                w ++;
            } else {
                swap(w, b --);
            }
        }
    }
    
    private void swap(int a, int b) {
        if (a != b) {
            mA[a] ^= mA[b];
            mA[b] ^= mA[a];
            mA[a] ^= mA[b];
        }
    }
}
