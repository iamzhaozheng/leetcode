package com.hisrv.leetcode2;

import java.util.ArrayList;

public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = triangle.size();
        int[] dp = new int[n];
        int t1, t2 = 0;
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i ++) {
            ArrayList<Integer> row = triangle.get(i);
            for (int j = 0; j <= i; j ++) {
                t1 = j == 0 ? 0 : t2;
                t2 = j == i ? 0 : dp[j];
                dp[j] = j == 0 ? t2 + row.get(j) : j == i ? t1 + row.get(j) : Math.min(t1, t2) + row.get(j);
            }
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < n; i ++) {
            ret = Math.min(ret, dp[i]);
        }
        return ret;
    }
}
