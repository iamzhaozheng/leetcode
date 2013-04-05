package com.hisrv.leetcode2;

public class BestTimeToBuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = prices.length;
        int m = 0;
        int[] prof1 = new int[n];
        int[] prof2 = new int[n];
        for (int i = 0; i < n; i ++) {
            if (prices[i] < prices[m]) {
                m = i;
            }
            prof1[i] = Math.max(i == 0 ? 0 : prof1[i - 1], prices[i] - prices[m]);
        }
        int ret = 0;
        for (int i = n - 1; i >= 0; i --) {
            if (prices[i] > prices[m]) {
                m = i;
            }
            prof2[i] = Math.max(i == n - 1 ? 0 : prof2[i + 1], prices[m] - prices[i]);
            ret = Math.max(prof2[i] + prof1[i], ret);
        }
        return ret;
    }
}
