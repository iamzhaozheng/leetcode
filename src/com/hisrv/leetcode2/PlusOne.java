package com.hisrv.leetcode2;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = digits.length;
        for (int i = n - 1; i >= 0; i --) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] ++;
                return digits;
            }
        }
        int[] out = new int[n + 1];
        Arrays.fill(out, 0);
        out[0] = 1;
        return out;
    }
}
