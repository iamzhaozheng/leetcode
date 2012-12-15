package com.hisrv.leetcode;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] ret = null;
        int n = digits.length;
        if (n == 0) {
            return ret;
        }
        for (int i = n - 1; i >= 0; i --) {
            if (digits[i] < 9) {
                digits[i] ++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        ret = new int[n + 1];
        Arrays.fill(ret, 0);
        ret[0] = 1;
        return ret;
    }
}
