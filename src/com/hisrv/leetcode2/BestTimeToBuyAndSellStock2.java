package com.hisrv.leetcode2;

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = prices.length;
        int ret = 0;
        for (int i = 0; i < n - 1; i ++) {
            ret += Math.max(prices[i + 1] - prices[i], 0);
        }
        return ret;
    }
}
