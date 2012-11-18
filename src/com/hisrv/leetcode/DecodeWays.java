package com.hisrv.leetcode;
public class DecodeWays {
	public int numDecodings(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() == 0) {
			return 0;
		}
		if (s.charAt(0) == '0') {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		int a1, a2, a3;
		a1 = 1;
		int r = canMerge(s.charAt(0), s.charAt(1));
		if (r == -1) {
			return 0;
		} else if (r == 0) {
			if (s.charAt(1) == '0') {
				a2 = 1;
			} else {
				a2 = 2;
			}
		} else {
			a2 = 1;
		}
		a3 = a2;
		for (int i = 2; i < s.length(); i++) {
			r = canMerge(s.charAt(i - 1), s.charAt(i));
			if (r == -1) {
				return 0;
			} else if (s.charAt(i) == '0') {
				a3 = a1;
			} else if (r == 0) {
				a3 = a2 + a1;
			} else {
				a3 = a2;
			}
			a1 = a2;
			a2 = a3;
		}
		return a3;
	}

	private int canMerge(char a, char b) {
		if (a == '0' && b == '0') {
			return -1;
		}
		if (a > '2' && b == '0') {
			return -1;
		}
		if (a == '1') {
			return 0;
		}
		if (a == '2' && b <= '6') {
			return 0;
		}
		return 1;
	}
}
