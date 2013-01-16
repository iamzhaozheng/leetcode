package com.hisrv.leetcode;

import java.util.ArrayList;

public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> ta) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = ta.size();
        if (n == 0) {
            return 0;
        }
        int[] sum = new int[n];
        sum[0] = ta.get(0).get(0);
        for (int i = 1; i < n; i ++) {
            for (int j = i; j >= 0; j --) {
                if (j == i) {
                    sum[j] = ta.get(i).get(j) + sum[j - 1];
                } else if (j == 0) {
                    sum[j] = ta.get(i).get(j) + sum[0];
                } else {
                    sum[j] = ta.get(i).get(j) + Math.min(sum[j - 1], sum[j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i ++) {
            if (sum[i] < min) {
                min = sum[i];
            }
        }
        return min;
    }
}
