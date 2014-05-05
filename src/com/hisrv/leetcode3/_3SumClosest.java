package com.hisrv.leetcode3;

import java.util.ArrayList;
import java.util.Arrays;

public class _3SumClosest {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int j, k, sum;
        int ret = num[0] + num[1] + num[2];
        for (int i = 0; i < num.length - 2; i ++) {
            j = i + 1;
            k = num.length - 1;
            while (j < k) {
                sum = num[i] + num[j] + num[k];
                if (sum > target) {
                    k --;
                } else if (sum <= target) {
                    j ++;
                }
                if (Math.abs(ret - target) > Math.abs(sum - target)) {
                    ret = sum;
                }
            }
        }
        return ret;
    }
}
