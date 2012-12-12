package com.hisrv.leetcode;

public class NextPermutation {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = num.length;
        if (n == 0) {
            return;
        }
        for (int i = n - 1; i > 0; i --) {
            if (num[i - 1] < num[i]) {
                for (int j = n - 1; j >= i; j --) {
                    if (num[i - 1] < num[j]) {
                        swap(num, i - 1, j);
                        rev(num, i, n - 1);
                        return;
                    }
                }
            }
        }
        rev(num, 0, n - 1);
    }
    
    private void swap(int[] num, int i, int j) {
        if (num[i] != num[j]) {
            num[i] ^= num[j];
            num[j] ^= num[i];
            num[i] ^= num[j];
        }
    }
    
    private void rev(int[] num, int i, int j) {
        int n = (j - i + 1) / 2;
        for (int k = 0; k < n; k ++) {
            swap(num, i + k, j - k);
        }
    }
}
