package com.hisrv.leetcode;

public class BestTimeToBuyAndSellStock3 {
	public int maxProfit(int[] prices) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int n = prices.length;
		if (n == 0) {
			return 0;
		}
		int[] lpro = new int[n];
		int[] rpro = new int[n];
		int m = prices[0];
		lpro[0] = 0;
		for (int i = 1; i < n; i ++) {
			lpro[i] = Math.max(prices[i] - m, lpro[i - 1]);
			m = Math.min(m, prices[i]);
		}
		m = prices[n - 1];
		rpro[n - 1] = 0;
		for (int i = n - 2; i >= 0; i --) {
			rpro[i] = Math.max(m - prices[i], rpro[i + 1]);
			m = Math.max(m, prices[i]);
		}
		m = 0;
		for (int i = 0; i < n; i ++) {
			m = Math.max(m, lpro[i] + rpro[i]);
		}
		return m;
	}
}
