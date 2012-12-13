package com.hisrv.leetcode;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        if (k <= 0) {
            return "";
        }
        k--;
        k = k % factorial(n);
        int[] temp = new int[n];
        for (int i = 0; i < n; i ++) {
            temp[i] = i + 1;
        }
        NextPermutation np = new NextPermutation();
        for (int i = 0; i < k; i ++) {
            np.nextPermutation(temp);
        }
        String ret = "";
        for (int i = 0; i < n; i ++) {
            ret += String.valueOf(temp[i]);
        }
        return ret;
    }
    
    private int factorial(int n) {
        int s = 1;
        for (int i = 2; i <= n; i ++) {
            s *= i;
        }
        return s;
    }
}
