package com.hisrv.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class CombinationSum {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates,
			int target) {
		// Start typing your Java solution below
		// DO NOT write main() function
		Stack<Integer> s = new Stack<Integer>();
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		if (candidates == null || candidates.length < 1) {
			return rst;
		}
		Arrays.sort(candidates);
		int sum = 0;
		int i = 0;
		while (i < candidates.length) {
			sum += candidates[i];
			s.push(i);
			if (sum >= target) {
				if (sum == target) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					for (int j = 0; j < s.size(); j++) {
						list.add(candidates[s.get(j)]);
					}
					rst.add(list);
				}
				int d = s.pop();
				sum -= candidates[d];
				if (s.empty()) {
					break;
				}
				do {
					d = s.pop();
					sum -= candidates[d];
					i = d + 1;
				} while (i >= candidates.length && !s.empty());
			}
		}
		return rst;
	}
}
