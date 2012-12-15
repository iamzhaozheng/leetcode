package com.hisrv.leetcode;

import java.util.Stack;

public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s == null || s.length() == 0) {
			return 0;
		}
		int n = s.length();
		char[] chs = s.toCharArray();
		int max = 0;
		int l = 0;
		int start = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			char ch = chs[i];
			if (ch == ')') {
				if (stack.isEmpty()) {
					if (max < l) {
						max = l;
					}
					l = 0;
					start = i + 1;
				} else {
					stack.pop();
					l += 2;
				}
			} else {
				stack.push(i);
			}
		}
		if (stack.isEmpty()) {
			if (l > max) {
				max = l;
			}
			return max;
		}
		for (int i = 0; i <= stack.size(); i++) {
			if (i == 0) {
				if (stack.get(0) - start > max) {
					max = stack.get(0) - start;
				}
			} else if (i == stack.size()) {
				int t = n - stack.get(stack.size() - 1) - 1;
				if (t > max) {
					max = t;
				}
			} else {
				int t = stack.get(i) - stack.get(i - 1) - 1;
				if (t > max) {
					max = t;
				}
			}
		}
		return max;
	}
}
