package com.hisrv.leetcode;

public class BuyStock2 {
	public class Solution {
	    public int maxProfit(int[] prices) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        boolean hold = false;
	        int profit = 0;
	        for (int i = 0; i < prices.length - 1; i ++) {
	            if (prices[i + 1] > prices[i] && !hold) {
	                hold = true;
	                profit -= prices[i];
	            }
	            if (prices[i + 1] < prices[i] && hold) {
	                hold = false;
	                profit += prices[i];
	            }
	        }
	        if (hold) {
	            profit += prices[prices.length - 1];
	        }
	        return profit;
	    }
	} 
}
