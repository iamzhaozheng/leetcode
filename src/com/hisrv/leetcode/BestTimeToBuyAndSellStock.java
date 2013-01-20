package com.hisrv.leetcode;

public class BestTimeToBuyAndSellStock {
	public class Solution {
	    public int maxProfit(int[] prices) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        int[] max = new int[prices.length];
	        int m = 0;
	        int p = 0;
	        for (int i = prices.length - 1; i >= 0; i --) {
	            if (prices[i] > m) {
	                m = prices[i];
	            }
	            max[i] = m;
	        }
	        for (int i = 0; i < prices.length; i ++) {
	            int d = max[i] - prices[i];
	            if (d > p) {
	                p = d;
	            }
	        }
	        return p;
	    }
	}
}
