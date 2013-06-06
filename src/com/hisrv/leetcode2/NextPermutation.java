package com.hisrv.leetcode2;

public class NextPermutation {
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = num.length;
        int a = n - 2;
        while (a >= 0 && num[a] >= num[a + 1]) {
            a --;
        }
        if (a < 0) {
            reverse(num, 0, n - 1);
            return;
        }
        int b = n - 1;
        while (num[b] <= num[a]) {
            b --;
        }
        swap(num, a, b);
        reverse(num, a + 1, n - 1);
    }
    
    private void reverse(int[] num, int a, int b) {
        int n = b - a + 1;
        for (int i = 0; i < n / 2; i ++) {
            swap(num, a + i, b - i);
        }
    }
    
    private void swap(int[] num, int a, int b) {
        if (num[a] != num[b]) {
            num[a] ^= num[b];
            num[b] ^= num[a];
            num[a] ^= num[b];
        }
    }
}
