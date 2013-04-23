package com.hisrv.leetcode2;

import java.util.Arrays;

public class _3SumClosest {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = num.length;
        Arrays.sort(num);
        int ret = 0;
        if (n < 3) {
            for (int i = 0; i < n; i ++) {
                ret += num[n];
            }
            return ret;
        }
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i ++) {
            int j = i + 1;
            int k = n - 1;
            while (minDiff != 0 && j < k) {
                int diff = num[i] + num[j] + num[k] - target;
                if (diff > 0) {
                    k --;
                } else {
                    j ++;
                }
                if (Math.abs(minDiff) > Math.abs(diff)) {
                    minDiff = diff;
                }
            }
            if (minDiff == 0) {
                return target;
            }
        }
        return minDiff + target;
    }
}
