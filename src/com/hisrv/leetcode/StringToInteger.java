package com.hisrv.leetcode;

public class StringToInteger {
	public int atoi(String str) {
		// Start typing your Java solution below
		// DO NOT write main() function
		char[] s = str.toCharArray();
		int n = s.length;
		if (n == 0) {
			return 0;
		}
		long ret = 0;
		boolean pos = true;
		int start = 0;
		while (s[start] == ' ') {
			start++;
		}
		if (s[start] == '-') {
			pos = false;
			start++;
		} else if (s[start] == '+') {
			pos = true;
			start++;
		}
		while (start < n && s[start] == '0') {
			start++;
		}
		if (start >= n) {
			return 0;
		}
		for (int i = start; i < n; i++) {
			if (s[i] > '9' || s[i] < '0' || ret > Integer.MAX_VALUE) {
				break;
			} else {
				ret *= 10;
				ret += (s[i] - '0');
			}
		}
		ret = pos ? ret : -ret;
		int result;
		if (ret > Integer.MAX_VALUE) {
			result = Integer.MAX_VALUE;
		} else if (ret < Integer.MIN_VALUE) {
			result = Integer.MIN_VALUE;
		} else {
			result = (int) ret;
		}
		return result;
	}
}
