package com.hisrv.leetcode2;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = prices.length;
        int m = 0;
        int[] prof = new int[n];
        int ret = 0;
        for (int i = 0; i < n; i ++) {
            if (prices[i] < prices[m]) {
                m = i;
            }
            prof[i] = Math.max(i == 0 ? 0 : prof[i] - 1, prices[i] - prices[m]);
            ret = Math.max(ret, prof[i]);
        }
        return ret;
    }
}
