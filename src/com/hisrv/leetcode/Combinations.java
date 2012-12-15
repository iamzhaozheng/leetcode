package com.hisrv.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		if (k > n) {
			return rst;
		}
		int i = 0;
		Stack<Integer> s = new Stack<Integer>();
		while (i <= n - k || !s.empty()) {
			s.push(i);
			i++;
			if (s.size() == k || i - 1 > n) {
				if (i - 1 <= n) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					for (int j = 0; j < s.size(); j++) {
						list.add(s.get(j) + 1);
					}
					rst.add(list);
				}
				i = s.pop() + 1;
				while (i > n && !s.empty()) {
					i = s.pop() + 1;
				}
			}
		}
		return rst;
	}
}
