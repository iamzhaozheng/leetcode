package com.hisrv.leetcode2;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] s = new char[n];
        for (int i = 0; i < n; i ++) {
            s[i] = (char)(i + '1');
        }
        for (int i = 0; i < k - 1; i ++) {
            nextPermutation(s);
        }
        return new String(s);
    }
    
    private void nextPermutation(char[] s) {
        int n = s.length;
        int i = n - 2;
        while (i >= 0 && s[i] > s[i + 1]) {
            i --;
        }
        if (i == -1) {
            reverse(s, 0, n - 1);
        } else {
            int j = n - 1;
            while (s[j] < s[i]) {
                j --;
            }
            swap(s, i, j);
            reverse(s, i + 1, n - 1);
        }
    }
    
    private void reverse(char[] s, int a, int b) {
        for (int i = 0; i < (b - a + 1) / 2; i ++) {
            swap(s, a + i, b - i);
        }
    }
    
    private void swap(char[] s, int a, int b) {
        if (s[a] != s[b]) {
            s[a] ^= s[b];
            s[b] ^= s[a];
            s[a] ^= s[b];
        }
    }
}
